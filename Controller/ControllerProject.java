package Controller;

import Interfaces.iProjectController;
import Model.Project;
import Model.Repo.ProjectRepo;
import View.Utils.Utils;
import View.ViewProject;

import java.util.ArrayList;

public class ControllerProject implements iProjectController {
    ViewProject viewProject = new ViewProject();
    ProjectRepo projectRepo = new ProjectRepo();


    @Override
    public Project createProject() {
        Project projectToCreate = viewProject.createProject();
        Project projectTemp = projectRepo.selectAndSaveInAFile(projectToCreate);

        if (projectTemp != null) {
            Utils.printMsg("Proyecto creado corretamente");
        } else {
            Utils.printMsg("Error al crear el Proyecto");
        }
        return null;
    }


    @Override
    public Project removeProject() {
        Project projectToDelete = viewProject.removeProject();

        Project removedProject = projectRepo.removeFromFiles(projectToDelete);

        if (removedProject != null) {
            Utils.printMsg("Usuario eliminado correctamente");
        } else {
            Utils.printMsg("Fallo al eliminar el proyecto, comprueba el nombre");
        }

        return removedProject;
    }

    @Override
    public void showProject() {
        String nameProject = viewProject.searchProject();
        Project projecttoshow = projectRepo.browseOne(nameProject);
        //Metodo de la vista para mostrar
        if (projecttoshow != null) {
            viewProject.showProject(projecttoshow);
        } else {
            Utils.printMsg("Proyecto no encontrada");
        }
    }

    @Override
    public void selectProject() {
        String nameProject = Utils.readString("Introduce el nombre del proyecto");
        if (projectRepo.selectAProject(nameProject)) {
            Utils.printMsg("Se ha selecionado correctamente");
        } else {
            Utils.printMsg("Ha habido un problema al seleccionar");
        }
    }


    @Override
    public void listAllProjects() {
        ArrayList<Project> projects = projectRepo.browseList();
        viewProject.listProject(projects);

    }

    @Override
    public void upgradeProject() {
        String oldname = Utils.readString("Nombre del proyecto a modificar");

        Project projectToUpgrade = viewProject.upgradeProject();

        viewProject.showProject(projectRepo.upgrade(projectToUpgrade, oldname));
    }
}

