package View;

import Interfaces.iViewLogin;
import Model.User;

import java.util.Scanner;
import java.util.regex.Pattern;

public class ViewLogin implements iViewLogin {
    Scanner scanner = new Scanner(System.in);

    /**
     * @author Javier Fernández
     * Metodo para mostrar el menu de registro
     * Method to display the registration menu
     */
    public User displayRegister() {
        Scanner scanner = new Scanner(System.in);
        String usernameInput = "";
        String passwordInput = "";
        String emailInput = "";
        String nameInput="";


        // Muestra el menu
        System.out.println();
        System.out.println("╔══════════════════════════════════════╗");
        System.out.println("         === \uD83D\uDD11 REGISTRARSE \uD83D\uDD11 ===         ");
        System.out.println("╠══════════════════════════════════════╣");
        do {

            System.out.print(" \uD83D\uDC64 Nombre de Usuario: ");
            usernameInput = scanner.nextLine();
        } while (!(Pattern.compile("[A-Za-z0-9]+").matcher(usernameInput).matches()));
        do {
            System.out.print(" \uD83D\uDD10 Contraseña: ");
            passwordInput = scanner.nextLine();
        } while (!(Pattern.compile("[A-Za-z0-9]+").matcher(passwordInput).matches()));
        do {
            System.out.print(" \uD83D\uDCE7 Correo Electrónico: ");

        System.out.print(" \uD83D\uDC64 Nombre de Usuario: ");
            usernameInput = scanner.nextLine();
        } while (!(Pattern.compile("[A-Za-z0-9]+").matcher(usernameInput).matches()));
        do {
        System.out.print(" \uD83D\uDD10 Contraseña: ");
            passwordInput = scanner.nextLine();
        } while (!(Pattern.compile("[A-Za-z0-9]+").matcher(passwordInput).matches()));
        do {
        System.out.print(" \uD83D\uDCE7 Correo Electrónico: ");

            emailInput = scanner.nextLine();
        } while (!Pattern.compile("[A-Za-z0-9]+@gmail[.](com|es)").matcher(emailInput).matches());
        System.out.print(" \uD83D\uDC68 Nombre: ");
        nameInput = scanner.nextLine();
        System.out.println("╚══════════════════════════════════════╝");

        // Crear un usuario temporal con los datos ingresados por el usuario
        User temporaryUser = new User(usernameInput, passwordInput, emailInput, nameInput);

        // Puedes devolver este usuario temporal o utilizarlo según tus necesidades
        return temporaryUser;
    }

    /**
     * @author Javier Fernández
     * Metodo para mostrar el menu de inicio de sesión
     * Method to display the log in menu
     */
    public User displayLogIn() {
        // Muestra el menu
        System.out.println();
        System.out.println("╔══════════════════════════════════════╗");
        System.out.println("         === \uD83D\uDD11 INICIAR SESIÓN \uD83D\uDD11 ===        ");
        System.out.println("╠══════════════════════════════════════╣");
        System.out.print(" \uD83D\uDC64 Nombre de Usuario: ");
        String usernameInput = scanner.nextLine();
        System.out.print(" \uD83D\uDD10 Contraseña: ");
        String passwordInput = scanner.nextLine();
        System.out.println("╚══════════════════════════════════════╝");

        // Crear un usuario temporal con los datos ingresados por el usuario
        return new User(usernameInput, passwordInput, null, null);
    }

    /**
     * @Author: Javier Fernández
     * Metodo para mostrar mensaje de inicio de sesión exitoso
     * Method to display a successful login message
     */
    public void showMessageStartSessionSuccessful() {
        System.out.println("✅ Inicio de sesión exitoso.");
    }

    public void showMessageStartSessionFailed() {
        System.out.println("❌ Inicio de sesión fallido. Usuario o contraseña incorrectos.");
    }
}