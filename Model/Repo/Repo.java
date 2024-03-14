package Model.Repo;

import Interfaces.iRepo;
import Model.Project;
import Serializator.Serializator;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public abstract class Repo<T> implements iRepo<T> {



    /**
     * Este método añade un proyecto a un fichero con todos los
     * proyectos registrados, si no se ha registrado ningún
     * proyecto aún, crea el fichero con el primer proyecto.
     *
     * @param projectToAdd Recibe el proyecto que queremos añadir al fichero
     * @return Devuelve true si el proyecto se ha añadido y false si no se ha añadido
     */
    public boolean addProjectToFile(Project projectToAdd) {
        File projectsFile = new File("./src/ProjectFileSaves/users.bin");
        boolean correctAdd = false;
        if (projectsFile.exists()) {
            List<Project> projectsFromFile = (List<Project>) Serializator.deserializeObject(projectsFile.toString());
            correctAdd = projectsFromFile.add(projectToAdd);
            Serializator.serializeObject(projectsFromFile, projectsFile.toString());
        } else {
            List<Project> usersFromFiles = new ArrayList<Project>();
            correctAdd = usersFromFiles.add(projectToAdd);
            Serializator.serializeObject(usersFromFiles, projectToAdd.toString());
        }
        return correctAdd;
    }

    public abstract T selectAndSaveInAFile(T selected);
    public abstract T removeFromFiles(T selected);
    public abstract T browseOne(String id);
    public abstract T upgrade(T userToUpgrade, String name);
    public abstract ArrayList<T> browseList();
}
