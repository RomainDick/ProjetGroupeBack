package com.rizomm.gestion.service;

import com.rizomm.gestion.entity.Team;

import java.util.Optional;

public interface TeamService {
    Optional<Team> findById(Long id);
}
