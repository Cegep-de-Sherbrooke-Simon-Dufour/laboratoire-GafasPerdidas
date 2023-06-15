package com.example.lab6_1.data;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.ArrayList;
import java.util.Arrays;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class UserListRepository {
    @Inject
    public UserListRepository(){}

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

    private final MutableLiveData<ArrayList<User>> usersLiveData = new MutableLiveData<>(users);

    public void addUser(User u){
        users.add(u);
        usersLiveData.setValue(users);
    }

    public void removeUser(User u){
        users.remove(u);
        usersLiveData.setValue(users);
    }

    public LiveData<ArrayList<User>> get_users() {
        return usersLiveData;
    }
}