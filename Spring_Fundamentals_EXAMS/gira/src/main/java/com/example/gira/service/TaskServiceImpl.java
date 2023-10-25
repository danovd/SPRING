package com.example.gira.service;

import com.example.gira.model.entity.Classification;
import com.example.gira.model.entity.Task;
import com.example.gira.model.entity.User;
import com.example.gira.model.entity.enums.ProgressEnum;
import com.example.gira.model.service.TaskServiceModel;
import com.example.gira.repository.ClassificationRepository;
import com.example.gira.repository.TaskRepository;
import com.example.gira.util.CurrentUser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {
    private final TaskRepository taskRepository;
    private final ModelMapper modelMapper;
    private final ClassificationRepository classificationRepository;
    private final UserService userService;
    private final CurrentUser currentUser;

    public TaskServiceImpl(TaskRepository taskRepository, ModelMapper modelMapper, ClassificationRepository classificationRepository, UserService userService, CurrentUser currentUser) {
        this.taskRepository = taskRepository;
        this.modelMapper = modelMapper;
        this.classificationRepository = classificationRepository;

        this.userService = userService;
        this.currentUser = currentUser;
    }

    @Override
    public void add(TaskServiceModel taskServiceModel) {

        Task task = modelMapper.map(taskServiceModel, Task.class);
        task.setProgress(ProgressEnum.OPEN);

        User creator = userService.findById(currentUser.getId());
        task.setUser(creator);

        Classification classification = classificationRepository.findByClassificationName(taskServiceModel.getClassification());
        task.setClassification(classification);


        taskRepository.save(task);
    }

    @Override
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    @Override
    public void makeProgressById(String id) {
        Task task = taskRepository.findById(id).orElse(null);
        String progress = task.getProgress().name();
        switch (progress){
            case "OPEN" -> {task.setProgress(ProgressEnum.IN_PROGRESS); taskRepository.save(task); }
            case "IN_PROGRESS" -> {task.setProgress(ProgressEnum.COMPLETED);  taskRepository.save(task);}
            case "COMPLETED" -> taskRepository.delete(task);
            default -> {task.setProgress(ProgressEnum.OTHER);  taskRepository.save(task);}
        }
    }
}
