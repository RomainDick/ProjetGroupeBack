package com.rizomm.gestion.repository;

import com.rizomm.gestion.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository  extends JpaRepository<Task, Long> {

}
