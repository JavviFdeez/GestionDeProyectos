package View;

import Interfaces.iViewProject;
import Model.Project;
import Model.User;

import javax.swing.*;
import java.util.List;
import java.util.Scanner;

public class ViewProject implements iViewProject {
    Scanner scanner = new Scanner(System.in);

    /**
     * @author Javier Fernández
     * Método para mostrar el Menu Proyectos de 5 opciones para elegir
     * Method to display the project menu with 5 options to choose
     */
    @Override
    public int menuProject() {
        int selectedOption = -1;

        while (selectedOption < 1 || selectedOption > 7) {
            // Muestra el menu
            System.out.println();
            System.out.println("╔════════════════════════════════════════════════════════╗");
            System.out.println("              === \uD83C\uDF1F MENÚ PRINCIPAL \uD83C\uDF1F ===    ");
            System.out.println("╠════════════════════════════════════════════════════════╣");
            System.out.println("  = [1]. BUSCAR PROYECTOS \uD83D\uDD0D️ ");
            System.out.println("  == [2]. MOSTRAR PROYECTOS \uD83D\uDC40️ ");
            System.out.println("  === [3]. CREAR PROYECTOS \uD83D\uDEE0️      ");
            System.out.println("  ==== [4]. ELIMINAR PROYECTOS \uD83D\uDDD1️️        ");
            System.out.println("  ===== [5]. SELECCIONAR UN PROYECTO ➡️️        ");
            System.out.println("  ====== [6]. ACTUALIZAR PROYECTOS ↻️ ");
            System.out.println("  ======= [7]. ELIMINAR USUARIO \uD83D\uDDD1️ ");
            System.out.println("  ======== [8]. ACTUALIZAR USUARIO \uD83D\uDD04 ");
            System.out.println("  ========= [9]. BUSCAR USUARIO \uD83D\uDD0D ");
            System.out.println("  ========== [10]. SALIR / CERRAR SESION \uD83D\uDEAA️        ");
            System.out.println("╚════════════════════════════════════════════════════════╝");


            // Solicitar la entrada del usuario
            String userInput = JOptionPane.showInputDialog(null, "Selecciona una opción: ");

            // Convertir la entrada a un entero y verificar si está en el rango válido
            try {
                selectedOption = Integer.parseInt(userInput);
                if (selectedOption < 1 || selectedOption > 7) {
                    JOptionPane.showMessageDialog(null, "❌ Por favor, introduce un número entre 1 y 7.");
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "❌ Por favor, introduce un número válido.");
            }
        }

        return selectedOption;
    }

    /**
     * @return Project
     * @author Javier Fernández
     * Metodo para buscar un proyecto
     * Method to search a project
     */
    @Override
    public String searchProject() {
        // Muestra el menu
        System.out.println();
        System.out.println("╔════════════════════════════════════════════════════════╗");
        System.out.println("                === 🔍 BUSCAR PROYECTO 🔍 ===            ");
        System.out.println("╠════════════════════════════════════════════════════════╣");
        System.out.print(" \uD83D\uDC64 Nombre del Proyecto: ");
        String projectNameInput = scanner.nextLine();
        System.out.println("╚════════════════════════════════════════════════════════╝");

        // Devuelve el nombre del proyecto
        return projectNameInput;
    }

    /**
     * @author Javier Fernández
     * Metodo para crear un proyecto
     * Method to create a project
     */
    @Override
    public Project createProject() {
        // Muestra el menu
        System.out.println();
        System.out.println("╔════════════════════════════════════════════════════════╗");
        System.out.println("                 === 🛠️ CREAR PROYECTO 🛠️ ===            ");
        System.out.println("╠════════════════════════════════════════════════════════╣");
        System.out.print(" \uD83D\uDC64 Nombre: ");
        String projectNameInput = scanner.nextLine();
        System.out.print(" \uD83D\uDD10 Descripción: ");
        String projectDescriptionInput = scanner.nextLine();
        System.out.println("╚════════════════════════════════════════════════════════╝");

        // Crea un objeto Project temporal con la entrada del usuario
        Project temporaryProject = new Project(null, projectNameInput, projectDescriptionInput);

        // Devuelve el objeto Project temporal
        return temporaryProject;
    }


    /**
     * @author Javier Fernández
     * Metodo para eliminar un proyecto
     * Method to delete a project
     */
    @Override
    public Project removeProject() {
        // Muestra el menu
        System.out.println();
        System.out.println("╔════════════════════════════════════════════════════════╗");
        System.out.println("               === ❌ ELIMINAR PROYECTO ❌ ===           ");
        System.out.println("╠════════════════════════════════════════════════════════╣");
        System.out.print(" \uD83D\uDC64 Nombre: ");
        String projectNameInput = scanner.nextLine();
        System.out.print(" \uD83D\uDCDD Descripción: ");
        String descriptionInput = scanner.nextLine();
        System.out.println("╚════════════════════════════════════════════════════════╝");

        // Crear y devolver un nuevo objeto Project con la información ingresada
        return new Project(null, projectNameInput, descriptionInput);
    }

    /**
     * @author Javier Fernández
     * Metodo para actualizar un proyecto
     * Method to update a project
     * @return Project
     */
    @Override
    public Project upgradeProject() {
        // Muestra el menu
        System.out.println();
        System.out.println("╔════════════════════════════════════════════════════════╗");
        System.out.println("           === \uD83D\uDD04 ACTUALIZAR PROYECTO \uD83D\uDD04 ===        ");
        System.out.println("╠════════════════════════════════════════════════════════╣");
        System.out.print(" \uD83D\uDC64 Nombre: ");
        String projectNameInput = scanner.nextLine();
        System.out.print(" \uD83D\uDCDD Descripción: ");
        String projectDescriptionInput = scanner.nextLine();
        System.out.println("╚════════════════════════════════════════════════════════╝");

        // Crea un objeto Project temporal con la entrada del usuario
        Project temporaryProject = new Project(null, projectNameInput, projectDescriptionInput);

        // Devuelve el objeto Project temporal
        return temporaryProject;
    }

    /**
     * @author Javier Fernández
     * Metodo para mostrar un proyecto
     * Method to show a project
     * @return
     */
    @Override
    public void showProject(Project projecttoshow) {
        Project currentProject = null;
        // Mostrar el proyecto
        if (currentProject != null) {
            System.out.println();
            System.out.println("╔════════════════════════════════════════════════════════╗");
            System.out.println("                  ===  ✏ PROYECTO ✏ ===                ");
            System.out.println("╠════════════════════════════════════════════════════════╣");
            System.out.println(" * Detalles del Proyecto *");
            System.out.println(" \uD83D\uDC64 Nombre: " + currentProject.getName());
            System.out.println(" \uD83D\uDCDD Descripción: " + currentProject.getDescripcion());

            // Mostrar el jefe del equipo
            User boss = currentProject.getBoss();
            if (boss != null) {
                System.out.println(" \uD83D\uDC68‍🚀 Jefe del Equipo: " + boss.getNameUser());
            } else {
                System.out.println(" ❌ No hay jefe del equipo asignado.");
            }

            if (currentProject.getMembers() != null && !currentProject.getMembers().isEmpty()) {
                System.out.println(" \uD83E\uDD16 Miembros del Proyecto:");

                for (User member : currentProject.getMembers()) {
                    System.out.println(" \uD83E\uDD16 - " + member.getNameUser());
                }
            } else {
                System.out.println(" ❌ No hay usuarios asociados a este proyecto.");
            }
        } else {
            System.out.println(" ❌ No hay proyecto actual.");
        }
        System.out.println("╚═══════════════════════════════════════════════════════════╝");
    }

    /**
     * @author Javier Fernández
     * Metodo para listar proyectos
     * Method to list projects
     * @param projects
     */
    @Override
    public void listProject(List<Project> projects) {
        Project selectedProject = null;
        // Mostrar la lista de proyectos
        if (projects != null && !projects.isEmpty()) {
            int projectIndex = 1;

            System.out.println();
            System.out.println("╔════════════════════════════════════════════════════════╗");
            System.out.println("      === \uD83D\uDCCB LISTA DE PROYECTOS \uD83D\uDCCB ===    ");
            System.out.println("╠════════════════════════════════════════════════════════╣");

            // Mostrar la lista de proyectos
            for (Project project : projects) {
                System.out.println(" [" + projectIndex + "] " + project.getName());
                projectIndex++;
            }

            System.out.println("╚═════════════════════════════════════════════════════════╝");
        }
    }
}