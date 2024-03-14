package Model.Repo;

import Model.Project;
import Model.Task;

public class SelectedProject {
    private static SelectedProject _instance;
    private Project actualProject;

    public static SelectedProject get_instance() {
        return _instance;
    }

    public static Project addProject(Project projectToUse) {
        _instance.actualProject=projectToUse;
        return _instance.actualProject;
    }

    public Project getActualProject() {
        return actualProject;
    }

    public boolean addTaskToActualProject(Task taskToAdd){
        boolean comp=false;
        if (!actualProject.getTasks().contains(taskToAdd)){
            actualProject.getTasks().add(taskToAdd);
            comp=true;
            ProjectRepo.saveProject(actualProject);
        }
        return comp;
    }
}
