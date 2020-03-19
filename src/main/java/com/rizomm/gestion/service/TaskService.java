package com.rizomm.gestion.service;

import com.rizomm.gestion.entity.Task;

import java.util.Optional;

public interface TaskService {
    Optional<Task> get(Long id);

    Task create(Task team);

    Task update(Task team);

    void delete(Task team);
}
