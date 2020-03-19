package com.rizomm.gestion.service.impl;

import com.rizomm.gestion.entity.Team;
import com.rizomm.gestion.repository.TeamRepository;
import com.rizomm.gestion.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TeamServiceImpl implements TeamService {

    private final TeamRepository teamRepository;

    @Autowired
    public TeamServiceImpl(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    @Override
    public Optional<Team> get(Long id) {
        return this.teamRepository.findById(id);
    }

    @Override
    public Team create(Team team) {
        return this.teamRepository.save(team);
    }

    @Override
    public Team update(Team team) {
        return this.teamRepository.save(team);
    }

    @Override
    public void delete(Team team) {
        this.teamRepository.delete(team);
    }
}
