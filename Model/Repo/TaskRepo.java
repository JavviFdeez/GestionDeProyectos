package Model.Repo;

import Model.Project;
import Model.Task;
import Model.User;
import Serializator.Serializator;

import java.io.File;
import java.util.ArrayList;

public class TaskRepo extends Repo<Task>{


    /**
     * Este método nos guarda la tarea en un archivo y añade la tarea al proyecto en uso
     * @param selected Tarea que queremos guardar y usar en el proyecto
     * @return Devuelve la tarea que se ha guardado o null si ha dado error
     */
    @Override
    public Task selectAndSaveInAFile(Task selected) {
        File taskFile=new File("./src/TaskFileSaves/"+selected.getName());
        Task taskToReturn=(Task) Serializator.deserializeObject(taskFile.toString());
        if (!taskFile.exists()){
            Serializator.serializeObject(selected,taskFile.toString());
            SelectedProject.get_instance().addTaskToActualProject(selected);
        } else if (!SelectedProject.get_instance().addTaskToActualProject(taskToReturn)) {
            taskToReturn=null;
        }
        return taskToReturn;
    }

    /**
     * Este método elimina el archivo de una tarea y la elimina del proyecto que tenemos seleccionado
     * @param selected Recibe la tarea que queremos eliminar
     * @return Devuelve la tarea eliminada o null si hay un error
     */
    @Override
    public Task removeFromFiles(Task selected) {
        File taskFile=new File("./src/TaskFileSaves/"+selected.getName());
        Task taskToCheck=(Task) Serializator.deserializeObject(taskFile.toString());
        if (taskFile.exists() && SelectedProject.get_instance().getActualProject().getTasks().remove(taskToCheck)){
            taskFile.delete();
        }else {
            taskToCheck=null;
        }
        return taskToCheck;
    }

    /**
     * Este método recibe un nombre y devuelve una tarea que esté guardada
     * @param id Recibe un identificador de la tarea, en este caso el nombre
     * @return Devuelve la tarea con el nombre que recibe
     */
    @Override
    public Task browseOne(String id) {
        return (Task) Serializator.deserializeObject("./src/TaskFileSaves/"+id);
    }

    /**
     * Este método modifica la tarea indicada
     * @param taskToUpgrade
     * @param name
     * @return
     */
    @Override
    public Task upgrade(Task taskToUpgrade, String name) {
        File taskSelectedFile = new File("./src/TaskFileSaves/" + name.toLowerCase().replaceAll(" ", ""));
        File taskUpgradedFile = new File("./src/TaskFileSaves/" + taskToUpgrade.getName().toLowerCase().replaceAll(" ", ""));
        Task taskToReturn=null;
        if (!taskUpgradedFile.exists()){
            taskToReturn=(Task) Serializator.deserializeObject(taskSelectedFile.toString());
            taskSelectedFile.delete();
            saveTask(taskToUpgrade);
        }
        return taskToReturn;
    }

    public boolean selectTask(String taskName){
        boolean comp=false;
        Task taskToSelect=Serializator.deserializeObject("./src/TaskFileSaves/"+taskName);
        if (taskToSelect!=null){
            SelectedTask.addTask(taskToSelect);
            comp=true;
        }
        return comp;
    }

    @Override
    public ArrayList<Task> browseList() {
        return (ArrayList<Task>) SelectedProject.get_instance().getActualProject().getTasks();
    }

    public static boolean saveTask(Task taskToSave){
        return Serializator.serializeObject(taskToSave,"./src/TaskFileSaves/"+taskToSave.getName());
    }
}
