package com.rizomm.gestion.controller;

import com.rizomm.gestion.entity.Task;
import com.rizomm.gestion.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.Optional;

@RestController("/tasks")
public class TaskController  {

    private final TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    public ResponseEntity<Task> get(@RequestParam @NotNull Long id) {
        Optional<Task> taskOptional = this.taskService.get(id);

        if (taskOptional.isPresent()) {
            return ResponseEntity.ok(taskOptional.get());
        }

        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Task> create(@RequestBody Task task) {
        Task taskCreated = this.taskService.create(task);

        return ResponseEntity.status(HttpStatus.CREATED).body(taskCreated);
    }

    @PutMapping
    public ResponseEntity<Task> update(@RequestBody @NotNull Task task) {
        Task taskUpdated = this.taskService.update(task);

        return ResponseEntity.ok(taskUpdated);
    }

    @DeleteMapping
    public ResponseEntity delete(@RequestParam @NotNull Long id) {
        Optional<Task> taskOptional = this.taskService.get(id);

        if (taskOptional.isPresent()) {
            this.taskService.delete(taskOptional.get());
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.notFound().build();
    }
}
