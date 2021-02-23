package sample.service;

import sample.entity.Task;
import sample.entity.Utilisateur;
import sample.repository.TaskRepositoryImpl;
import sample.repository.UtilisateurRepositoryImpl;

public class TaskService {

    private TaskRepositoryImpl taskRepository;

    public TaskService(){
        this.taskRepository = new TaskRepositoryImpl();
    }

    public void createTask(Task task){
        taskRepository.create(task);
    }

}


