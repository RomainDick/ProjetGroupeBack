package com.rizomm.gestion.controller;

import com.rizomm.gestion.entity.Team;
import com.rizomm.gestion.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;
import java.util.Optional;

@RestController
public class TeamController {

    private final TeamService teamService;

    @Autowired
    public TeamController(TeamService teamService) {
        this.teamService = teamService;
    }

    @GetMapping
    public ResponseEntity<Team> findById(@RequestParam @NotNull Long id) {
        Optional<Team> teamOpt = this.teamService.findById(id);

        if (teamOpt.isPresent()) {
            return ResponseEntity.ok(teamOpt.get());
        }

        return ResponseEntity.notFound().build();
    }
}
