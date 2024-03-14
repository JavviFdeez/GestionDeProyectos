package Interfaces;

import Model.User;

import java.util.List;

public interface iViewUser {
    void listUsers(List<User> users);
    User removeUser();
    User upgradeUser();
    User searchUser();
    void displayUser(User user);
}