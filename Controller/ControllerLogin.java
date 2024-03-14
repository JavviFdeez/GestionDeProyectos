package Controller;

import Interfaces.iLoginController;
import Model.Repo.UserRepo;
import Model.User;
import View.Utils.Utils;
import View.ViewLogin;

public class ControllerLogin implements iLoginController {
    ViewLogin viewLogin = new ViewLogin();
    UserRepo repo = new UserRepo();

    /**
     * Método para crear un nuevo usuario.
     * - Obtiene la información del usuario a través de la vista.
     * - Utiliza el repositorio para seleccionar y guardar el usuario en un archivo.
     * - Muestra un mensaje de inicio de sesión exitoso o fallido según el resultado.
     */
    @Override
    public boolean createUser() {
        boolean comp = false;
        User userToCreate = viewLogin.displayRegister();
        User userTemp = repo.selectAndSaveInAFile(userToCreate);

        if (userTemp.getNameUser() != null || userTemp.getPassword() != null || userTemp.getGmail() != null) {
            viewLogin.showMessageStartSessionSuccessful();
            comp = true;
        } else {
            viewLogin.showMessageStartSessionFailed();
        }
        return comp;
    }

    /**
     * Método para seleccionar un usuario e iniciar sesión.
     * - Obtiene las credenciales del usuario a través de la vista.
     * - Utiliza el repositorio para seleccionar y obtener un usuario existente.
     * - Verifica las credenciales y muestra mensajes apropiados en la consola.
     */
    @Override
    public boolean selectUser() {
        boolean comp = false;
        User loginUser = viewLogin.displayLogIn();
        User existingUser = repo.selectAndSaveInAFile(loginUser);

        if (existingUser != null && existingUser.getPassword().equals(loginUser.getPassword())) {
            Utils.printMsg("Inicio de sesión exitoso");
            comp = true;
        } else {
            Utils.printMsg("Fallo en el inicio de sesión");
        }
        return comp;

    }
}


