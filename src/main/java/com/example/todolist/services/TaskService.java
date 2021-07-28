package com.example.todolist.services;

import com.example.todolist.entities.Tasks;

import java.util.List;

public interface TaskService {

    List<Tasks> getAllTasks();

    Tasks deleteUser(Long id);

    void addTask(Tasks task);

    Tasks getItem(Long id);

    void saveTask(Tasks task);

    void deleteTask(Long id);
}
