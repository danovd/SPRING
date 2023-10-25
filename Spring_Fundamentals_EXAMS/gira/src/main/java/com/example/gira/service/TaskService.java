package com.example.gira.service;

import com.example.gira.model.entity.Task;
import com.example.gira.model.service.TaskServiceModel;

import java.util.List;

public interface TaskService {
    void add(TaskServiceModel map);

    List<Task> getAllTasks();

    void makeProgressById(String id);
}
