package Controller;

import Interfaces.iTaskController;
import Model.Repo.TaskRepo;
import Model.Task;
import View.Utils.Utils;
import View.ViewTask;

import java.util.ArrayList;

public class ControllerTask implements iTaskController {
    ViewTask viewTask = new ViewTask();
    TaskRepo taskRepo = new TaskRepo();

    @Override
    public void createTask() {
        Task taskcreate = viewTask.createTask();
        taskRepo.selectAndSaveInAFile(taskcreate);
        if (taskcreate != null) {
            Utils.printMsg("Tarea creada correctamente");
        } else {
            Utils.printMsg("Error al crear la tarea");
        }
    }


    @Override
    public Task removeTask() {
        Task taskToDelete = viewTask.removeTask();

        Task removedTask = taskRepo.removeFromFiles(taskToDelete);

        if (removedTask != null) {
            Utils.printMsg("Usuario eliminado correctamente");
        } else {
            Utils.printMsg("Fallo al eliminar la tarea, comprueba el nombre");
        }

        return removedTask;
    }


    @Override
    public void listAllTask() {
        ArrayList<Task> tasks = taskRepo.browseList();
        viewTask.listTask(tasks);
    }

    @Override
    public void showTask() {
        String nameTask = Utils.readString("Introduce el nombre de la tarea");
        Task taskToShow = taskRepo.browseOne(nameTask);
        //Metodo de la vista para mostrar
        if (taskToShow != null) {
            viewTask.showTask(taskToShow);
        } else {
            Utils.printMsg("Tarea no encontrada");
        }
    }

    @Override
    public void selectTask() {
       String nameTask = Utils.readString("Introduce el nombre de la tarea");
        if (taskRepo.selectTask(nameTask)) {
            Utils.printMsg("Se ha selecionado correctamente");
        } else {
            Utils.printMsg("Ha habido un problema al seleccionar");
        }
    }
    }



