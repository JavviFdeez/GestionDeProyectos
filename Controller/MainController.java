package Controller;


import Model.Repo.SelectedTask;
import Model.Repo.TaskRepo;
import View.*;
import Enum.Estado;
import View.Utils.Utils;

public class MainController {
    ControllerLogin controllerLogin = new ControllerLogin();
    ControllerProject controllerProject = new ControllerProject();
    ControllerTask controllerTask = new ControllerTask();
    ControllerUser controllerUser = new ControllerUser();
    View view = new View();

    public void loginMainMenuSelection() {
        view.showMessageWelcome();
        MainMenu mainMenu = new MainMenu();
        int userInput;
        boolean comp = false;
        do {
            userInput = mainMenu.displayMainMenu();
            switch (userInput) {
                case 1:
                    // Lógica para registrar un usuario
                    comp = controllerLogin.createUser();
                    break;
                case 2:
                    // Lógica para iniciar sesión de un usuario
                    comp = controllerLogin.selectUser();
                    break;
                case 3:
                    view.showMessageGoodBye();
                    break;
                default:
                    throw new IllegalStateException("Opción inválida: " + userInput);
            }
            if (comp) {
                menu();
            }
        } while (userInput != 3);
    }

    public void menu() {
        ViewProject viewProject = new ViewProject();
        int userInput;
        do {
            userInput = viewProject.menuProject();
            switch (userInput) {
                case 1:
                    // Lógica para buscar un proyecto
                    controllerProject.showProject();
                    Utils.pressEnter();
                    break;
                case 2:
                    // Lógica para mostrar proyectos
                    controllerProject.listAllProjects();
                    Utils.pressEnter();
                    break;
                case 3:
                    // Lógica para crear proyectos
                    controllerProject.createProject();
                    Utils.pressEnter();
                    break;
                case 4:
                    // Lógica para eliminar proyectos
                    controllerProject.removeProject();
                    Utils.pressEnter();
                    break;
                case 5:
                    // Lógica para entrar en un proyecto
                    controllerProject.selectProject();
                    menuProject();
                    break;
                case 6:
                    // Lógica para actualizar un proyecto
                    controllerProject.upgradeProject();
                    Utils.pressEnter();
                    break;
                case 7:
                    break;
                default:
                    Utils.printMsg("Opción inválida: " + userInput);
            }
        } while (userInput != 7);

    }

    public void menuProject() {
        ViewTask viewTask = new ViewTask();
        int userInput;
        do {
            userInput = viewTask.menuTask();
            switch (userInput) {
                case 1:
                    // Lógica para mostrar miembro
                    controllerUser.listAllMember();
                    Utils.pressEnter();
                    break;
                case 2:
                    // Lógica para añadir miembro
                    controllerUser.addMember();
                    Utils.pressEnter();
                    break;
                case 3:
                    // Lógica para eliminar miembro
                    controllerUser.removeMember();
                    Utils.pressEnter();
                    break;
                case 4:
                    // Lógica para añadir tarea
                    controllerTask.createTask();
                    Utils.pressEnter();
                    break;
                case 5:
                    // Lógica para eleminar tarea
                    controllerTask.removeTask();
                    Utils.pressEnter();
                    break;
                case 6:
                    // Mostrar tarea de tu usuario
                    controllerTask.showTask();
                    Utils.pressEnter();
                    break;
                case 7:
                    //Mostrar todas las tareas
                    controllerTask.listAllTask();
                    Utils.pressEnter();
                    break;
                case 8:
                    // Lógica para selecionar una tarea
                    controllerTask.selectTask();
                    menuTask();
                    break;
                case 9:
                    break;
                default:
                    Utils.printMsg("Opción inválida: " + userInput);
            }
        } while (userInput != 9);
    }

    public void menuTask() {
        ViewTaskScreen viewTaskScreen = new ViewTaskScreen();
        TaskRepo taskRepo = new TaskRepo();
        ViewTask viewTask = new ViewTask();
        int userInput;
        do {
            userInput = viewTaskScreen.menuTaskScreen();
            switch (userInput) {
                case 1:
                    // Información tarea
                    viewTask.showTask(taskRepo.browseOne(SelectedTask.get_instance().getActualProject().getName()));
                    Utils.pressEnter();
                    break;
                case 2:
                    // Cambiar estado

                    int tmp = viewTaskScreen.menuState();
                    switch (tmp) {
                        case 1:
                            SelectedTask.get_instance().getActualProject().setEstado(Estado.Iniciada);
                            break;
                        case 2:
                            SelectedTask.get_instance().getActualProject().setEstado(Estado.Sin_Iniciar);
                            break;
                        case 3:
                            SelectedTask.get_instance().getActualProject().setEstado(Estado.Finalizado);
                            break;
                        default:
                            break;
                    }
                    Utils.pressEnter();
                    break;
                case 3:
                    // Modificar nombre
                    String newName = Utils.readString("Introduce el nuevo nombre: ");
                    SelectedTask.get_instance().getActualProject().setName(newName);
                    Utils.pressEnter();
                    break;
                case 4:
                    // Modificar Descripción
                    String newDescription = Utils.readString("Introduce la nueva descripción: ");
                    SelectedTask.get_instance().getActualProject().setName(newDescription);
                    Utils.pressEnter();
                    break;
                case 5:
                default:
                    Utils.printMsg("Opción inválida: " + userInput);
            }
        }while (userInput!=5);
    }


}




