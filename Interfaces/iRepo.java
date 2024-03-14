package Interfaces;


import java.util.ArrayList;

public interface iRepo<T> {
    T selectAndSaveInAFile(T selected);
    T removeFromFiles(T selected);
    T browseOne(String id);
    T upgrade(T userToUpgrade, String oldPassword);
    ArrayList<T> browseList();
}
