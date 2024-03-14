package Model.Repo;

import Model.Project;
import Model.User;
import Serializator.Serializator;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ProjectRepo extends Repo<Project>{

    /**
     * Este método recibe un proyecto y lo guarda en un archivo propio y
     * en un archivo con el resto de proyectos y pone como jefe al usuario
     * que tiene sesión iniciada
     * @param selected Recibe el proyecto que queremos crear
     * @return Devuelve el proyecto creado si se ha insertado correctamente y null si algo ha fallado
     */
    @Override
    public Project selectAndSaveInAFile(Project selected) {
        File projectFile=new File("./src/ProjectFileSaves/"+selected.getName());
        Project tmpProject=null;
        selected.setBoss(UserSesion.getInstance().getCurrentUser());
        if (!projectFile.exists() && UserSesion.getInstance().addProject(selected)) {
            saveProject(selected);
            addProjectToArrayFile(selected);
            tmpProject=selected;
        }
        return tmpProject;
    }

    /**
     * Este método elimina el proyecto de los ficheros de proyectos
     * @param selected Recibe el proyecto que deseamos eliminar
     * @return Devuelve el proyecto eliminado
     */
    @Override
    public Project removeFromFiles(Project selected) {
        File projectFile=new File("./src/ProjectFileSaves/"+selected.getName());
        Project tmpProject=null;
        if (projectFile.exists()){
            tmpProject=selected;
            projectFile.delete();
            removeFromArrayFile(selected);
            UserSesion.getInstance().getProjects().remove(selected);
        }
        return tmpProject;
    }

    /**
     * Este método busca un proyecto
     * @param username Recibe el nombre del proyecto
     * @return Devuelve el proyecto completo
     */
    @Override
    public Project browseOne(String username) {
        File projectFile=new File("./src/ProjectFileSaves/"+username);
        Project projectToReturn=null;
        if (projectFile.exists()){
            projectToReturn=Serializator.deserializeObject(projectFile.toString());
        }
        return projectToReturn;
    }

    @Override
    public Project upgrade(Project projectToUpgrade, String name) {
        File projectSelectedFile = new File("./src/ProjectFileSaves/" + name.toLowerCase().replaceAll(" ", ""));
        File projectUpgradedFile = new File("./src/ProjectFileSaves/" + projectToUpgrade.getName().toLowerCase().replaceAll(" ", ""));
        Project projectToReturn=null;
        if (!projectUpgradedFile.exists()){
            projectToReturn=Serializator.deserializeObject(projectSelectedFile.toString());
            removeFromArrayFile(projectToReturn);
            projectSelectedFile.delete();
            saveProject(projectToUpgrade);
            addProjectToArrayFile(projectToUpgrade);
        }
        return projectToReturn;
    }

    /**
     * Este método devuelve todos los proyectos del usuario que ha iniciado sesión actualmente
     * @return Devuelve todos los proyectos del usuario
     */
    @Override
    public ArrayList<Project> browseList() {
        return (ArrayList<Project>) UserSesion.getInstance().getProjects();
    }

    /**
     * Este método añade un proyecto a un fichero con todos los
     * proyectos registrados, si no se ha registrado ningún
     * proyecto aún, crea el fichero con el primer usuario.
     *
     * @param projectToAdd Recibe el proyecto que queremos añadir al fichero
     * @return Devuelve true si el proyecto se ha añadido y false si no se ha añadido
     */
    public boolean addProjectToArrayFile(Project projectToAdd) {
        File projectsFile = new File("./src/ProjectFileSaves/projects.bin");
        boolean correctAdd = false;
        if (projectsFile.exists()) {
            List<Project> projectsFromFile = Serializator.deserializeObject(projectsFile.toString());
                projectsFromFile.add(projectToAdd);
                Serializator.serializeObject(projectsFromFile, projectsFile.toString());
                correctAdd = true;
        } else {
            List<Project> projectsFromFile = new ArrayList<Project>();
            projectsFromFile.add(projectToAdd);
            Serializator.serializeObject(projectsFromFile, projectsFile.toString());
            correctAdd = true;
        }

        return correctAdd;
    }

    /**
     * Este método elimina el proyecto del archivo con todos los proyectos
     * @param projectToRemove Recibe el proyecto a eliminar
     * @return Devuelve true si se ha eliminado correctamente y false si ha habido algun error
     */
    public boolean removeFromArrayFile(Project projectToRemove) {
        File projectsFile = new File("./src/ProjectFileSaves/projects.bin");
        boolean correctRemove = false;
        List<Project> projectsFromFile = Serializator.deserializeObject(projectsFile.toString());
        if (projectsFromFile.remove(projectToRemove)) {
            correctRemove = true;
        }
        return correctRemove;
    }

    public boolean selectAProject(String projectName){
        boolean comp=false;
        File projectFile=new File("./src/ProjectFileSaves/"+projectName);
        Project projectToCheck=Serializator.deserializeObject(projectFile.toString());
        if (projectFile.exists() && UserSesion.getInstance().getProjects().contains(projectToCheck)){
            SelectedProject.addProject(projectToCheck);
            comp=true;
        }
        return comp;
    }

    public boolean addMember(String userName){
        User userToAdd=Serializator.deserializeObject("./src/ProjectFileSaves/"+userName);
        boolean comp=SelectedProject.get_instance().getActualProject().createUser(userToAdd);
        if (comp){
            saveProject(SelectedProject.get_instance().getActualProject());
        }
        return comp;
    }

    public boolean removeMember(String userName){
        User userToAdd=Serializator.deserializeObject("./src/ProjectFileSaves/"+userName);
        boolean comp=SelectedProject.get_instance().getActualProject().deleteUser(userToAdd);
        if (comp){
            saveProject(SelectedProject.get_instance().getActualProject());
        }
        return comp;
    }



    public static boolean saveProject(Project projectToSave){
        return Serializator.serializeObject(projectToSave,"./src/ProjectFileSaves/"+projectToSave.getName());
    }


}
