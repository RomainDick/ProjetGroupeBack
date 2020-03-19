package com.rizomm.gestion.repository;

import com.rizomm.gestion.entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TeamRepository extends JpaRepository<Team, Long> {

}
