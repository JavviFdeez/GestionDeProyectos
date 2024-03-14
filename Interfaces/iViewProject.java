package Interfaces;

import Model.Project;

import java.util.List;

public interface iViewProject {
    int menuProject();
    String searchProject();
    void showProject(Project projecttoshow);
    void listProject(List<Project> projects);
    Project createProject();
    Project removeProject();
    Project upgradeProject();
}