package Controller;

import Interfaces.iUserController;
import Model.Repo.ProjectRepo;
import Model.Repo.UserRepo;
import Model.User;
import View.Utils.Utils;
import View.ViewLogin;
import View.ViewUser;

import java.util.ArrayList;

public class ControllerUser implements iUserController {
    ViewUser viewUser = new ViewUser();
    ViewLogin viewLogin = new ViewLogin();
    UserRepo userRepo = new UserRepo();
    ProjectRepo projectRepo = new ProjectRepo();

    /**
     * Este método pide un  usuario  a través de la vista (viewUser)
     * Luegolo pasa el usuario al repositorio de usuarios (userRepo).
     * Si el usuario existe, se muestra en la vista, de lo contrario,
     * se muestra un mensaje indicando que el usuario no se encontró.
     */
    @Override
    public void showUser() {
        User UserName = viewUser.searchUser();

        User existingUser = userRepo.browseOne(UserName.getNameUser());

        if (existingUser != null) {
            viewUser.displayUser(existingUser);
        } else {
            Utils.printMsg("Usuario no encontrado");
        }
    }

    /**
     * Este método muestra pide un  usuario  a través de la vista (viewUser)
     * Luegolo pasa el usuario al repositorio de usuarios (userRepo).
     * Si el usuario existe, se elemina, de lo contrario,
     * se muestra un mensaje indicando que el usuario no se encontró.
     */
    @Override
    public User removeUser() {
        User userNameToDelete = viewUser.removeUser();

        User removedUser = userRepo.removeFromFiles(userNameToDelete);

        if (removedUser != null) {
            Utils.printMsg("Usuario eliminado correctamente");
        } else {
            Utils.printMsg("Fallo al eliminar el usuario, comprueba el nombre");
        }

        return removedUser;

    }

    /**
     * Este método pide un incio de sesión a través de la vista (viewUser)
     * Luegolo pasa el usuario al repositorio de usuarios (userRepo).
     * Si el usuario existe, se podrá actualizar, de lo contrario,
     * se muestra un mensaje indicando que el usuario no se encontró.
     */
    @Override
    public void upgradeUser() {
        User loginUser = viewLogin.displayLogIn();

        User existingUser = userRepo.selectAndSaveInAFile(loginUser);

        if (existingUser != null && existingUser.getPassword().equals(loginUser.getPassword())) {
            Utils.printMsg("Inicio de sesión exitoso");

            User updatedUser = viewUser.upgradeUser();

            if (updatedUser != null) {
                userRepo.upgrade(updatedUser, existingUser.getNameUser());
                Utils.printMsg("Datos del usuario actualizados exitosamente");
            } else {
                Utils.printMsg("No se han realizado cambios en los datos del usuario");
            }
        } else {
            Utils.printMsg("Fallo en el inicio de sesión");
        }
    }

    /**
     *En este metodo muestra todos los miembros que esten en el proyecto.
     */
    @Override
    public void listAllMember() {
        ArrayList<User> users = userRepo.browseList();
        viewUser.listUsers(users);
    }

    @Override
    public boolean addMember() {
        boolean comp = false;
        String memberName = Utils.readString("Introduce el usuario del miembro que quieres añadir");
        if (projectRepo.addMember(memberName)) {
            Utils.printMsg("Miembro añadido correctamente");
        } else {
            Utils.printMsg("Error al añadir el miembro");
        }

        return comp;
    }

    @Override
    public boolean removeMember() {
        boolean comp = false;
        String memberName = Utils.readString("Introduce el usuario del miembro que quieres eliminar");
        if (projectRepo.removeMember(memberName)) {
            Utils.printMsg("Miembro eliminado correctamente");
        } else {
            Utils.printMsg("Error al eliminar el miembro");
        }

        return comp;
    }

}










