package user.service;

import user.api.dto.TeamDto;
import user.domain.entity.TeamsEntity;

import java.util.List;

public interface TeamsService {
    List<TeamDto> getTeams();
    TeamsEntity getTeamById(Long id);
    TeamDto create(TeamDto teamDto);
    TeamDto update();
    void delete(Long id);
}
