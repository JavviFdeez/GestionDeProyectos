package Interfaces;

import Model.Project;
import Model.Task;
import Model.User;

import java.util.ArrayList;
import java.util.List;

public interface iViewTask {
    int menuTask();
    Task createTask();
    Task removeTask();
    void showTask(Task taskToShow);
    void listTask(ArrayList<Task> tasks);
}