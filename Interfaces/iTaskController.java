package Interfaces;

import Model.Task;

public interface iTaskController {
    void createTask();
    Task removeTask();
    void listAllTask();
    void showTask();
    void selectTask();
}
