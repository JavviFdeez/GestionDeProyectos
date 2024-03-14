package Interfaces;

import Model.User;

public interface iUserController {
    void showUser();
    User removeUser();
    void upgradeUser();
    void listAllMember();
    boolean addMember();
    boolean removeMember();
}
