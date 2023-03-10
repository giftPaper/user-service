package user.api.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import user.api.dto.TeamDto;
import user.domain.entity.TeamsEntity;
import user.service.TeamsService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("${server.basePrefixUrl}/teams")
public class TeamsController {

    private final TeamsService teamsService;

    @GetMapping
    public List<TeamDto> getTeams(){
        return teamsService.getTeams();
    }

    @GetMapping("/{id}")
    public TeamsEntity getTeamByID(@PathVariable Long id){
        return teamsService.getTeamById(id);
    }

    @PostMapping
    public TeamDto create(@RequestBody TeamDto teamDto){
        return teamsService.create(teamDto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        teamsService.delete(id);
    }
}
