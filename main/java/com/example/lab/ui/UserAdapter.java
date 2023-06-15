package com.example.lab6_1.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lab6_1.data.User;
import com.example.lab6_1.R;
import com.example.lab6_1.RecyclerCallback;

import java.util.Objects;

public class UserAdapter extends ListAdapter<User, UserAdapter.ViewHolder> {
    private RecyclerCallback<User> callback = (u) -> {};

    public UserAdapter() {
        super(new DiffUtil.ItemCallback<User>() {
            @Override
            public boolean areItemsTheSame(@NonNull User oldItem, @NonNull User newItem) {
                return oldItem == newItem;
            }

            @Override
            public boolean areContentsTheSame(@NonNull User oldItem, @NonNull User newItem) {
                return Objects.equals(oldItem, newItem);
            }
        });
    }

    public void set_callback(RecyclerCallback<User> callback) {
        this.callback = callback;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.user_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(getItem(position));
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private final TextView name;
        private final TextView email;
        private User user;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.user_name);
            email = itemView.findViewById(R.id.user_email);
            user = new User(itemView.findViewById(R.id.user_name).toString(), itemView.findViewById(R.id.user_email).toString());
            itemView.setOnClickListener(view -> {
                callback.onClick(user);
            });
        }

        public void bind(User user) {
            this.user = user;
            name.setText(user.get_name());
            email.setText(user.get_email());
        }
    }
}
