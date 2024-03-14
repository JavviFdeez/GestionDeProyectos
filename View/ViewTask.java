package View;

import Interfaces.iViewTask;
import Model.Task;
import Model.User;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Scanner;

public class ViewTask implements iViewTask {
    Scanner scanner = new Scanner(System.in);

    /**
     * @author Javier Fernández
     * Método para mostrar el Menu Tareas de 5 opciones para elegir
     * Method to display the task menu with 5 options to choose
     * @return int
     */
    @Override
    public int menuTask() {
        // Muestra el menu
        System.out.println();
        System.out.println("╔═══════════════════════════════════════════════════════════════╗");
        System.out.println("                  === \uD83C\uDF1F MENÚ PROYECTO \uD83C\uDF1F ===    ");
        System.out.println("╠═══════════════════════════════════════════════════════════════╣");
        System.out.println("  = [1]. MOSTRAR MIEMBROS \uD83D\uDC40️ ");
        System.out.println("  == [2]. AÑADIR MIEMBROS ➕️      ");
        System.out.println("  === [3]. ELIMINAR MIEMBROS \uD83D\uDDD1️️        ");
        System.out.println("  ==== [4]. AÑADIR TAREA ➕️️        ");
        System.out.println("  ===== [5]. ELIMINAR TAREA \uD83D\uDDD1️️        ");
        System.out.println("  ====== [6]. MOSTRAR TAREA DE TU USUARIO \uD83D\uDC40️        ");
        System.out.println("  ======= [7]. MOSTRAR TODAS TAREA DE TU PROYECTO \uD83D\uDC40️        ");
        System.out.println("  ======== [8]. SELECCIONAR TAREA ☑️️        ");
        System.out.println("  ========= [9]. SALIR PROYECTO \uD83D\uDEAA️        ");
        System.out.println("╚═══════════════════════════════════════════════════════════════╝");

        // Solicitar la entrada del usuario
        String userInput = JOptionPane.showInputDialog(null, "Selecciona una opción: ");

        // Convertir la entrada a un entero y devolverlo
        try {
            return Integer.parseInt(userInput);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "❌ Por favor, introduce un número válido.");
            return -1;
        }
    }

    /**
     * @author Javier Fernández
     * Método para crear una tarea
     * Method to create a task
     * @return Task
     */
    @Override
    public Task createTask() {
        // Muestra el menu
        System.out.println();
        System.out.println("╔════════════════════════════════════════════════════════════╗");
        System.out.println("                   === 🛠️ CREAR TAREA 🛠️ ===              ");
        System.out.println("╠════════════════════════════════════════════════════════════╣");
        System.out.print(" \uD83D\uDC64 Nombre Usuario Asigando: ");
        String taskNameUserInput = scanner.nextLine();
        // Crea un objeto User temporal con la entrada del usuario
        User userTemporary = new User(taskNameUserInput, null, null, null);
        System.out.print(" \uD83D\uDD10 Nombre Tarea: ");
        String taskNameTaskInput = scanner.nextLine();
        System.out.print(" \uD83D\uDD10 Descripción: ");
        String taskDescriptionInput = scanner.nextLine();
        System.out.println("╚════════════════════════════════════════════════════════════╝");

        // Crea un objeto Task temporal con la entrada del usuario
        Task temporaryTask = new Task(userTemporary, taskNameTaskInput, taskDescriptionInput);

        // Devuelve el objeto Project temporal
        return temporaryTask;
    }

    /**
     * @author Javier Fernández
     * Método para eliminar una tarea
     * Method to remove a task
     * @return Task
     */
    @Override
    public Task removeTask() {
        // Muestra el menú
        System.out.println();
        System.out.println("╔════════════════════════════════════════════╗");
        System.out.println("          === ❌ ELIMINAR TAREA ❌ ===       ");
        System.out.println("╠════════════════════════════════════════════╣");
        System.out.print(" \uD83D\uDC64 Nombre Tarea: ");
        String taskNameInput = scanner.nextLine();
        System.out.println("╚════════════════════════════════════════════╝");

        // Crea y devuelve un nuevo objeto Task con la información ingresada
        return new Task(null, taskNameInput, null);
    }

    /**
     * @author Javier Fernández
     * Método para mostrar una tarea
     * Method to show a task
     * @param taskToShow
     */
    @Override
    public void showTask(Task taskToShow) {
        // Muestra el menú
        System.out.println();
        System.out.println("╔══════════════════════════════════════════════════════════════════════════════╗");
        System.out.println("                               === ✏ TAREA ✏ ===                             ");
        System.out.println("╠══════════════════════════════════════════════════════════════════════════════╣");

        if (taskToShow != null) {
            System.out.println(" \uD83D\uDD25 Nombre: " + taskToShow.getName());
            System.out.println(" \uD83D\uDCDD Descripción: " + taskToShow.getDecripcion());
            System.out.println(" \uD83D\uDCC5 Fecha de Inicio: " + taskToShow.getDateStar());
            System.out.println(" \uD83D\uDCC4 Fecha de Finalización: " + taskToShow.getDateFinis());
            System.out.println(" \uD83D\uDE80 Estado: " + taskToShow.getEstado());
            System.out.println(" \uD83D\uDC68‍ Persona Encargada: " + taskToShow.getIntegrante().getNameUser());
        } else {
            System.out.println(" ❌ No se proporcionó una tarea válida para mostrar.");
        }

        System.out.println("╚═════════════════════════════════════════════════════════════════════════════╝");
    }

    /**
     * @author Javier Fernández
     * Metodo para listar las tareas
     * Method to list the tasks
     */
    @Override
    public void listTask(ArrayList<Task> tasks) {
        Task selectedTask = null;
        // Menu de tareas
        if (tasks != null && !tasks.isEmpty()) {
            int taskIndex = 1;

            System.out.println();
            System.out.println("╔══════════════════════════════════════════════════════════╗");
            System.out.println("              === \uD83D\uDCCB LISTA DE TAREAS \uD83D\uDCCB ===           ");
            System.out.println("╠══════════════════════════════════════════════════════════╣");

            // Mostrar la lista de tareas y sus detalles uno por uno
            for (Task task : tasks) {
                System.out.println(" [" + taskIndex + "] " + task.getName());
                // Llama al método showTask para mostrar los detalles de la tarea actual
                showTask(task);

                taskIndex++;
            }

            System.out.println("╚════════════════════════════════════════════════════════╝");
        } else {
            System.out.println(" ❌ No hay tareas disponibles.");
        }
    }
}