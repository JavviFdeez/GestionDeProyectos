package Model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static java.awt.geom.Path2D.contains;

public class Project implements Serializable {
    private List<User> members = new ArrayList<>();
    private User boss;
    private String name;
    private String descripcion;
    private List<Task> tasks = new ArrayList<>();

    public Project( User boss, String name, String descripcion) {
        this.boss = boss;
        this.name = name;
        this.descripcion = descripcion;
        this.tasks= new ArrayList<>();
        this.members =new ArrayList<>();
    }

    public List<User> getMembers() {
        return members;
    }

    public void setMembers(List<User> members) {
        this.members = members;
    }

    public User getBoss() {
        return boss;
    }

    public void setBoss(User boss) {
        this.boss = boss;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Proyect: ").append(name).append("\n");
        sb.append("Descripción: ").append(descripcion).append("\n");
        sb.append("Jefe del Equipo: ").append(boss).append("\n");
        sb.append("Miembros del Equipo:\n");
        for (User member : members) {
            sb.append("\t- ").append(member).append("\n");
        }
        sb.append("Tareas del Equipo:\n");
        for (Task task : tasks) {
            sb.append("\t- ").append(task).append("\n");
        }
        return sb.toString();
    }

    /**
     * Crea y añade un integrante y no se puede repetir
     * @param u Usuario que introduce el jefe
     * @return introduce el miembro al proyecto
     */
    public boolean createUser(User u) {
        boolean isDiferent=false;
        if(!members.contains(u)){
            members.add(u);
            isDiferent=true;
        }
        return isDiferent;
    }

    /**
     * Elimina el mienbro del proyecto mediante un iterator
     * @param toremove el nombre del usuario para eliminarlo
     *
     * @return elimina el usuario
     */
    public boolean deleteUser(User toremove) {
        boolean isDiferent=false;

        if(members.contains(toremove)){
            members.remove(toremove);
            isDiferent=true;
        }
        return isDiferent;
    }
    /**
     * Crea y añade un tarea
     * @param t tarea que introduce el jefe
     * @return introduce el miembro al proyecto
     */
    public boolean createTask(Task t) {
        boolean isDifetent= false;
        if(!tasks.contains(t)){
            tasks.add(t);
            isDifetent=true;
        }
        return isDifetent;
    }

    /**
     * Elimina el tarea del proyecto
     * @param toremove el nombre de la tarea para eliminarlo
     * @return elimina la tarea
     */
    public boolean deleteTask(Task toremove) {
        boolean isDifetent= false;
        if(tasks.contains(toremove)){
            tasks.remove(toremove);
            isDifetent=true;
        }
        return isDifetent;

    }

}
