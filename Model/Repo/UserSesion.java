package Model.Repo;

import Model.Project;
import Model.User;
import Serializator.Serializator;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public class UserSesion {
    private static UserSesion _instance;

    private User currentUser;
    private List<Project> projects;

    private UserSesion(User user) {
        currentUser = user;
        projects = new ArrayList<>();
        if (takeAllProjectForAUser()!=null) {
            projects = takeAllProjectForAUser();
        }
    }

    public static UserSesion getInstance() {
        return _instance;
    }

    public static UserSesion getInstance(User userToUse) {
        if (_instance == null) {
            _instance = new UserSesion(userToUse);
        }
        return _instance;
    }

    public User getCurrentUser() {
        return currentUser;
    }

    public List<Project> getProjects() {
        return projects;
    }

    /**
     * Este método comprueba en que proyectos está el
     * usuario introducido ya sea como miembro o como jefe
     *
     * @return Devuelve todos los proyectos de los que es miembro o jefe
     */
    public List<Project> takeAllProjectForAUser() {
        List<Project> userProjects = new ArrayList<>();
        File projectsFile = new File("./src/ProjectFileSaves/projects.bin");
        List<Project> allProjects = Serializator.deserializeObject(projectsFile.toString());
        if (allProjects!=null) {
            Iterator<Project> iterator = allProjects.iterator();
            if (projectsFile.exists()) {
                while (iterator.hasNext()) {
                    Project tmpProject = iterator.next();
                    if (tmpProject.getBoss()!=null && tmpProject.getBoss().equals(currentUser) || proveUserMemberOf(tmpProject)) {
                        userProjects.add(tmpProject);
                    }
                }
            }
        }

        return userProjects;
    }

    /**
     * Este método comprueba si el usuario instanciado es miembro del proyecto
     *
     * @param projectToCheck Recibe el proyecto que queremos comprobar
     * @return Devuelve true si es miembro y false si no
     */
    public boolean proveUserMemberOf(Project projectToCheck) {
        Iterator<User> iterator = projectToCheck.getMembers().iterator();
        boolean result = false;
        while (iterator.hasNext()) {
            User tmpUser = iterator.next();
            if (tmpUser.equals(currentUser)) {
                result = true;
            }
        }
        return result;
    }

    public boolean addProject(Project projectToAdd) {
        boolean result = false;
        if (!projects.contains(projectToAdd)) {
            projects.add(projectToAdd);
            result = true;
        }
        return result;
    }
}
