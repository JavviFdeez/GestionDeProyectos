package Model.Repo;

import Model.Project;
import Model.Task;

public class SelectedTask {
    private static SelectedTask _instance;
    private Task actualTask;

    public static SelectedTask get_instance() {
        return _instance;
    }

    public static Task addTask(Task taskToUse) {
        _instance.actualTask=taskToUse;
        return _instance.actualTask;
    }

    public Task getActualProject() {
        return actualTask;
    }
}
