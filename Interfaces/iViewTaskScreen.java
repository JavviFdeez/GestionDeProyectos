package Interfaces;

import Model.Task;

public interface iViewTaskScreen {
    int menuTaskScreen();
    int menuState();
    Task modifyNameTask(Task task);
    Task modifyDescriptionTask(Task task);
}