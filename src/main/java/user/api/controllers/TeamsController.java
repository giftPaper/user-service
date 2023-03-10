package user.api.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import user.api.dto.PageDto;
import user.api.dto.TeamDto;
import user.domain.entity.TeamsEntity;
import user.service.TeamsService;

@RestController
@RequiredArgsConstructor
@RequestMapping("${server.basePrefixUrl}/teams")
public class TeamsController {

    private final TeamsService teamsService;

    @GetMapping
    public PageDto getTeams(@RequestParam int page, @RequestParam int size){
        return teamsService.getTeams(page, size);
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
