package Interfaces;

import Model.Project;

public interface iProjectController {
    Project createProject();
    Project removeProject();
    void showProject();
    void selectProject();
    void listAllProjects();
    void upgradeProject();
}
