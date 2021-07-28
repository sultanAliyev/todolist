package com.example.todolist.services.impl;

import com.example.todolist.entities.Tasks;
import com.example.todolist.repositories.TaskRepository;
import com.example.todolist.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImpl  implements TaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Override
    public List<Tasks> getAllTasks() {
        return taskRepository.findAll();
    }

    @Override
    public Tasks deleteUser(Long id) {
        taskRepository.delete(taskRepository.getById(id));
        return null;
    }

    @Override
    public void addTask(Tasks task) {
        taskRepository.save(task);
    }

    @Override
    public Tasks getItem(Long id) {
        return taskRepository.findById(id).orElse(null);
    }

    @Override
    public void saveTask(Tasks task) {
        taskRepository.save(task);
    }

    @Override
    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }
}
