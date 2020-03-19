package com.rizomm.gestion.service;

import com.rizomm.gestion.entity.Team;

import java.util.Optional;

public interface TeamService {
    Optional<Team> get(Long id);

    Team create(Team team);

    Team update(Team team);

    void delete(Team team);
}
