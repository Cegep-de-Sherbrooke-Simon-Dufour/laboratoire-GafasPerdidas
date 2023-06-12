package com.example.lab6_1.ui;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.lab6_1.data.User;
import com.example.lab6_1.data.UserListRepository;

import java.util.ArrayList;
import javax.inject.Inject;
import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class UserListViewModel extends ViewModel {
    private UserListRepository repository;

    @Inject
    public UserListViewModel(UserListRepository repository) {
        this.repository = repository;
    }

    public void addUser(String name, String email) {
        repository.addUser(new User(name, email));
    }
    public void addUser(User user) {
        repository.addUser(user);
    }

    public void removeUser(String name, String email) {
        repository.removeUser(new User(name, email));
    }
    public void removeUser(User user) {
        repository.removeUser(user);
    }

    public LiveData<ArrayList<User>> get_users() {
        return repository.get_users();
    }
}
