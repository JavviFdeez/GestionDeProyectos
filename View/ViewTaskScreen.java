package View;

import Interfaces.iViewTaskScreen;
import Model.Task;

import javax.swing.*;
import java.util.Scanner;

public class ViewTaskScreen implements iViewTaskScreen {
    Scanner scanner = new Scanner(System.in);

    /**
     * @author Firstname Lastname
     * Método para mostrar el Menu Tareas de 5 opciones para elegir
     * Method to display the task menu with 5 options to choose
     * @return int
     */
    @Override
    public int menuTaskScreen() {
        int selectedOption = -1;

        while (selectedOption < 1 || selectedOption > 5) {
            // Muestra el menu
            System.out.println();
            System.out.println("╔════════════════════════════════════════════════════════╗");
            System.out.println("              === \uD83C\uDF1F MENÚ TAREA \uD83C\uDF1F ===    ");
            System.out.println("╠════════════════════════════════════════════════════════╣");
            System.out.println("  = [1]. INFORMACION TAREA ℹ️️ ");
            System.out.println("  == [2]. CAMBIAR ESTADO ↻️ ");
            System.out.println("  === [3]. MODIFICAR NOMBRE ✏️️      ");
            System.out.println("  ==== [4]. MODIFICAR DESCRIPCIÓN ✏️️        ");
            System.out.println("  ===== [5]. SALIR \uD83D\uDEAA️        ");
            System.out.println("╚════════════════════════════════════════════════════════╝");

            // Solicitar la entrada del usuario
            String userInput = JOptionPane.showInputDialog(null, "Selecciona una opción: ");

            // Convertir la entrada a un entero y verificar si está en el rango válido
            try {
                selectedOption = Integer.parseInt(userInput);
                if (selectedOption < 1 || selectedOption > 5) {
                    JOptionPane.showMessageDialog(null, "❌ Por favor, introduce un número entre 1 y 3.");
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "❌ Por favor, introduce un número válido.");
            }
        }

        return selectedOption;
    }

    /**
     * @Author: Javier Fernández
     * Método para modificar el estado de la tarea
     * Method to modify the state of the task
     * @return int
     */
    @Override
    public int menuState() {
        int selectedOption = -1;

        while (selectedOption < 1 || selectedOption > 4) {
            // Muestra el menu
            System.out.println();
            System.out.println("╔════════════════════════════════════════════════════════╗");
            System.out.println("              === \uD83D\uDE80 NUEVO ESTADO \uD83D\uDE80 ===    ");
            System.out.println("╠════════════════════════════════════════════════════════╣");
            System.out.println("  = [1]. EN PROCESO \uD83D\uDD04️️ ");
            System.out.println("  == [2]. SIN INICIAR \uD83D\uDD04 ");
            System.out.println("  === [3]. FINALIZADO ✅️️      ");
            System.out.println("  ==== [4]. SALIR \uD83D\uDEAA️        ");
            System.out.println("╚════════════════════════════════════════════════════════╝");

            // Solicitar la entrada del usuario
            String userInput = JOptionPane.showInputDialog(null, "Selecciona una opción: ");

            // Convertir la entrada a un entero y verificar si está en el rango válido
            try {
                selectedOption = Integer.parseInt(userInput);
                if (selectedOption < 1 || selectedOption > 4) {
                    JOptionPane.showMessageDialog(null, "❌ Por favor, introduce un número entre 1 y 4.");
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "❌ Por favor, introduce un número válido.");
            }
        }

        return selectedOption;
    }

    /**
     * @Author: Javier Fernández
     * Método para modificar el nombre de la tarea
     * Method to modify the name of the task
     * @return Task
     */

    @Override
    public Task modifyNameTask(Task task) {
        // Muestra la información de la tarea
        System.out.println();
        System.out.println("╔══════════════════════════════════════════════════════════════════════════════╗");
        System.out.println("                           === ✏ MODIFICAR NOMBRE ✏ ===                      ");
        System.out.println("╠══════════════════════════════════════════════════════════════════════════════╣");

        // Pide al usuario que ingrese el nuevo nombre
        System.out.print(" \uD83D\uDC64 Nuevo Nombre de la Tarea: ");
        String newTaskName = scanner.nextLine();

        // Crea una nueva tarea con el nuevo nombre y la misma descripción
        task.setName(newTaskName);

        // Muestra la información modificada de la tarea
        System.out.println();
        System.out.println(" ℹ Información Modificada de la Tarea ℹ");
        System.out.println(" ✅ Nuevo Nombre de la Tarea: " +task.getName());
        System.out.println("╚═════════════════════════════════════════════════════════════════════════════╝");

        // Devuelve la tarea modificada
        return task;
    }

    /**
     * @Author: Javier Fernández
     * Método para modificar la descripción de la tarea
     * Method to modify the description of the task
     * @return Task
     */
    @Override
    public Task modifyDescriptionTask(Task task) {
        // Muestra el menu de la descripción
        System.out.println();
        System.out.println("╔══════════════════════════════════════════════════════════════════════════════╗");
        System.out.println("                        === ✏ MODIFICAR DESCRIPCION ✏ ===                    ");
        System.out.println("╠══════════════════════════════════════════════════════════════════════════════╣");

        // Pide al usuario que ingrese el nuevo nombre
        System.out.print(" \uD83D\uDCDD Nueva Descripcion de la Tarea: ");
        String newTaskDescription = scanner.nextLine();

        // Crea una nueva tarea con el nuevo nombre y la misma descripción
        task.setDecripcion(newTaskDescription);

        // Muestra la información modificada de la tarea
        System.out.println();
        System.out.println(" ℹ Información Modificada de la Tarea ℹ");
        System.out.println(" ✅ Nueva Descripcion de la Tarea: " +task.getDecripcion());
        System.out.println("╚═════════════════════════════════════════════════════════════════════════════╝");

        // Devuelve la tarea modificada
        return task;
    }
}