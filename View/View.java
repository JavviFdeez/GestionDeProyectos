package View;

import Interfaces.iView;
import Model.Project;
import Model.Task;
import Model.User;

public class View implements iView {
/**
 * @author Javier Fernández
 * Método para mostrar un mensaje de bienvenida
 * Method to display a welcome message
**/
    public void showMessageWelcome() {
        // Mensaje de bienvenida
        System.out.println("╔════════════════════════════════════════════════════════════════════════════╗");
        System.out.println("             🚀 ¡BIENVENIDOS AL SISTEMA DE GESTIÓN DE PROYECTOS! 🚀            ");
        System.out.println("╠════════════════════════════════════════════════════════════════════════════╣");
        System.out.println("         🛠️  Bienvenido al sistema de gestión de proyectos en Java. 🛠️        ");
        System.out.println("         🌟 ¡Optimiza tu trabajo colaborativo con nuestra aplicación! 🌟        ");
        System.out.println("           🚧 Organiza tareas, proyectos y colabora eficientemente. 🚧         ");
        System.out.println("                👩‍💻 ¡Desarrolla tus proyectos de manera exitosa! 👨‍💻          ");
        System.out.println("                   \uD83D\uDCB2 Crea, colabora, ¡triunfa con tu equipo! \uD83D\uDCB2         ");
        System.out.println("╠════════════════════════════════════════════════════════════════════════════╣");
        System.out.println("║                                    [Designed by Team Gestion de Proyectos.]║");
        System.out.println("╚════════════════════════════════════════════════════════════════════════════╝");
        System.out.println();
    }

    /**
     * @author Javier Fernández
     * Método para mostrar un mensaje de despedida
     * Method to display a goodbye message
     **/
    public void showMessageGoodBye() {
        // Mensaje de despedida
        System.out.println("╔════════════════════════════════════════════════════════════════════════════╗");
        System.out.println("     🌟 ¡GRACIAS POR UTILIZAR NUESTRO SISTEMA DE GESTIÓN DE PROYECTOS! 🌟");
        System.out.println("╠════════════════════════════════════════════════════════════════════════════╣");
        System.out.println("         🚀 Esperamos que hayas tenido una experiencia productiva. 🚀   ");
        System.out.println("          💡 ¡Continúa trabajando eficientemente en tus proyectos! 💡 ");
        System.out.println("              🌐 ¡Vuelve pronto para más funciones y mejoras! 🌐           ");
        System.out.println("╠════════════════════════════════════════════════════════════════════════════╣");
        System.out.println("║                                    [Designed by Team Gestion de Proyectos.]║");
        System.out.println("╚════════════════════════════════════════════════════════════════════════════╝");
        System.out.println();
    }

}
