package com.example.lab6_1;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    private UserAdapter adapter;

    private ArrayList<User> users = new ArrayList<>(Arrays.asList(
        new User("Audrey Audet", "Audrey.Audet@courriel.net")
    ,   new User("Alexandre Aignant", "Alexandre.Aignant@courriel.net")
    ,   new User("Claudia Castonguay", "Claudia.Castonguay@courriel.net")
    ,   new User("Christophe Caron", "Christophe.Caron@courriel.net")
    ,   new User("Laurie Lamarche", "Laurie.Lamarche@courriel.net")
    ,   new User("Lucien Leclerc", "Lucien.Leclerc@courriel.net")
    ,   new User("Dianne Desmarais", "Dianne.Desmarais@courriel.net")
    ,   new User("Dominique Dorval", "Dominique.Dorval@courriel.net")
    ,   new User("Julie Jutras", "Julie.Juras@courriel.net")
    ,   new User("Joseph Jolicoeur", "Joseph.Jolicoeur@courriel.net")
    ));

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        adapter = new UserAdapter();

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        adapter.set_callback(user -> {
            users.remove(user);
            adapter.submitList(new ArrayList<>(users));
        });
        adapter.submitList(new ArrayList<>(users));

        FloatingActionButton addUser = findViewById(R.id.floatingActionButton);
        addUser.setOnClickListener(addUserOnClickListener);
    }

    ActivityResultLauncher<Intent> mGetContent = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult()
            ,   new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    Intent data = result.getData();
                    String[] newUser = data.getExtras().getStringArray("newUser");
                    if(newUser[0].length() > 0 && newUser[1].length() > 0) {
                        User user = new User(newUser[0], newUser[1]);
                        users.add(user);
                        adapter.submitList(new ArrayList<>(users));
                    }
                }
            }
    );

    View.OnClickListener addUserOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(MainActivity.this, AddUserActivity.class);
            mGetContent.launch(intent);
        }
    };
}