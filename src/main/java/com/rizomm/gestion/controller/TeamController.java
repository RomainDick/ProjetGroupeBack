package com.rizomm.gestion.controller;

import com.rizomm.gestion.entity.Team;
import com.rizomm.gestion.service.TeamService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.Optional;

@RestController("/teams")
@Api("API for CRUD operations on teams")
public class TeamController {

    private final TeamService teamService;

    @Autowired
    public TeamController(TeamService teamService) {
        this.teamService = teamService;
    }

    @GetMapping
    @ApiOperation("Get a team by its id if it's existing")
    public ResponseEntity<Team> get(@RequestParam @NotNull Long id) {
        Optional<Team> teamOptional = this.teamService.get(id);

        if (teamOptional.isPresent()) {
            return ResponseEntity.ok(teamOptional.get());
        }

        return ResponseEntity.notFound().build();
    }

    @PostMapping
    @ApiOperation("Create a team")
    public ResponseEntity<Team> create(@RequestBody Team team) {
        Team teamCreated = this.teamService.create(team);

        return ResponseEntity.status(HttpStatus.CREATED).body(teamCreated);
    }

    @PutMapping
    @ApiOperation("Update a team")
    public ResponseEntity<Team> update(@RequestBody @NotNull Team team) {
        Team teamUpdated = this.teamService.update(team);

        return ResponseEntity.ok(teamUpdated);
    }

    @DeleteMapping
    @ApiOperation("Delete a team if it's existing")
    public ResponseEntity<Team> delete(@RequestParam @NotNull Long id) {
        Optional<Team> teamOptional = this.teamService.get(id);

        if (teamOptional.isPresent()) {
            this.teamService.delete(teamOptional.get());
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.notFound().build();
    }
}
