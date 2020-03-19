package com.rizomm.gestion.controller;

import com.rizomm.gestion.entity.Team;
import com.rizomm.gestion.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.Optional;

@RestController("/teams")
public class TeamController {

    private final TeamService teamService;

    @Autowired
    public TeamController(TeamService teamService) {
        this.teamService = teamService;
    }

    @GetMapping
    public ResponseEntity<Team> getTeam(@RequestParam @NotNull Long id) {
        Optional<Team> teamOptional = this.teamService.findById(id);

        if (teamOptional.isPresent()) {
            return ResponseEntity.ok(teamOptional.get());
        }

        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Team> create(@RequestBody Team team) {
        Team teamCreated = this.teamService.create(team);

        return ResponseEntity.status(HttpStatus.CREATED).body(teamCreated);
    }

    @PutMapping
    public ResponseEntity<Team> update(@RequestBody @NotNull Team team) {
        Team teamUpdated = this.teamService.update(team);

        return ResponseEntity.ok(teamUpdated);
    }

    @DeleteMapping
    public ResponseEntity<Team> delete(@RequestParam @NotNull Long id) {
        Optional<Team> teamOptional = this.teamService.findById(id);

        if (teamOptional.isPresent()) {
            this.teamService.delete(teamOptional.get());
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.notFound().build();
    }
}
