package com.rizomm.gestion.service.impl;

import com.rizomm.gestion.entity.Task;
import com.rizomm.gestion.repository.TaskRepository;
import com.rizomm.gestion.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;

    @Autowired
    public TaskServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public Optional<Task> get(Long id) {
        return this.taskRepository.findById(id);
    }

    @Override
    public Task create(Task task) {
        return this.taskRepository.save(task);
    }

    @Override
    public Task update(Task task) {
        return this.taskRepository.save(task);
    }

    @Override
    public void delete(Task task) {
        this.taskRepository.delete(task);
    }
}
