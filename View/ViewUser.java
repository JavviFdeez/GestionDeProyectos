package View;

import Interfaces.iViewUser;
import Model.Project;
import Model.Task;
import Model.User;

import java.util.List;
import java.util.Scanner;

public class ViewUser implements iViewUser {
    Scanner scanner = new Scanner(System.in);

    /**
     * @author Javier Fernández
     * Método para listar los usuarios
     * Method to list users
     */
    @Override
    public void listUsers(List<User> users) {
        if (users != null && !users.isEmpty()) {
            // Mostrar el Menu
            System.out.println();
            System.out.println("╔════════════════════════════════════════════════════════╗");
            System.out.println("              === 📋 LISTA DE USUARIOS 📋 ===            ");
            System.out.println("╠════════════════════════════════════════════════════════╣");

            // Mostrar la lista de usuarios
            for (User user : users) {
                System.out.println(" \uD83D\uDC64 Usuario: " + user.getNameUser());
                System.out.println(" \uD83D\uDCE7 Correo Electrónico: " + user.getGmail());
                System.out.println(" \uD83D\uDC68 Nombre: " + user.getName());
            }

            System.out.println("╚════════════════════════════════════════════════════════╝");
        } else {
            System.out.println(" ❌ No hay usuarios para mostrar.");
        }
    }


    /**
     * @author Javier Fernández
     * Metodo para eliminar un usuario
     * Method to delete a user
     * @return User
     */
    @Override
    public User removeUser() {
        // Muestra el menú
        System.out.println();
        System.out.println("╔════════════════════════════════════════════╗");
        System.out.println("         === ❌ ELIMINAR USUARIO ❌ ===      ");
        System.out.println("╠════════════════════════════════════════════╣");
        System.out.print(" \uD83D\uDC64 Nombre Usuario: ");
        String userNameInput = scanner.nextLine();
        System.out.println("╚════════════════════════════════════════════╝");

        // Crea y devuelve un nuevo objeto User con la información ingresada
        return new User(userNameInput, null, null, null);
    }

    /**
     * @author Javier Fernández
     * Metodo para actualizar un usuario
     * Method to update a user
     * @return User
     */
    @Override
    public User upgradeUser() {
        // Muestra el menu
        System.out.println();
        System.out.println("╔════════════════════════════════════════════════════════╗");
        System.out.println("           === \uD83D\uDD04 ACTUALIZAR USUARIO \uD83D\uDD04 ===        ");
        System.out.println("╠════════════════════════════════════════════════════════╣");
        System.out.print(" \uD83D\uDC64 Nombre Usuario: ");
        String userNameUserInput = scanner.nextLine();
        System.out.print(" \uD83D\uDCDD Contraseña: ");
        String userPasswordInput = scanner.nextLine();
        System.out.print(" \uD83D\uDCDD Gmail: ");
        String userGmailInput = scanner.nextLine();
        System.out.print(" \uD83D\uDCDD Nombre: ");
        String userNameInput = scanner.nextLine();
        System.out.println("╚════════════════════════════════════════════════════════╝");

        // Crea un objeto User temporal con la entrada del usuario
        User temporaryUser = new User(userNameUserInput, userPasswordInput, userGmailInput, userNameInput);

        // Devuelve el objeto User temporal
        return temporaryUser;
    }

    /**
     * @author Javier Fernández
     * Metodo para buscar un usuario
     * Method to search a user
     * @return String
     */
    @Override
    public User searchUser() {
        // Muestra el menú
        System.out.println();
        System.out.println("╔════════════════════════════════════════════════════════╗");
        System.out.println("                 === 🔍 BUSCAR USUARIO 🔍 ===            ");
        System.out.println("╠════════════════════════════════════════════════════════╣");
        System.out.print(" \uD83D\uDC64 Nombre de Usuario: ");
        String usernameInput = scanner.nextLine();
        System.out.println("╚════════════════════════════════════════════════════════╝");

        // Devuelve un nuevo objeto User con el nombre de usuario ingresado por el usuario
        return new User(usernameInput, null, null, null);
    }

    /**
     * @author Javier Fernández
     * Metodo para mostrar el usuario
     * Method to display the user
     * @param user
     */
    @Override
    public void displayUser(User user) {
        if (user != null) {
            // Mostrar el usuario
            System.out.println();
            System.out.println("╔════════════════════════════════════════════════════════╗");
            System.out.println("                 🔍 DETALLES DE USUARIO 🔍               ");
            System.out.println("╠════════════════════════════════════════════════════════╣");
            System.out.println(" \uD83D\uDC64 Nombre de Usuario: " + user.getNameUser());
            System.out.println(" \uD83D\uDCE7 Correo Electrónico: " + user.getGmail());
            System.out.println(" \uD83D\uDC68 Nombre: " + user.getName());
            System.out.println("╚════════════════════════════════════════════════════════╝");
        } else {
            System.out.println(" ❌ No se ha proporcionado un usuario válido.");
        }
    }
}