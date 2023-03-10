package user.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import user.api.dto.TeamDto;
import user.api.dto.mapper.TeamDtoMapper;
import user.domain.entity.TeamsEntity;
import user.domain.entity.mapper.TeamsEntityMapper;
import user.domain.repo.TeamsRepo;
import user.exceptions.RestApiException;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TeamsServiceImpl implements TeamsService {

    private final TeamsRepo teamsRepo;
    private final TeamDtoMapper teamDtoMapper;
    private final TeamsEntityMapper teamsEntityMapper;

    @Override
    public List<TeamDto> getTeams() {
        return teamsRepo.findAll(Sort.by("id").descending())
                .stream()
                .map(teamDtoMapper::map)
                .collect(Collectors.toList());
    }
    @Override
    public TeamsEntity getTeamById(Long id) {
        return teamsRepo.findById(id)
                .orElseThrow(() -> new RestApiException(String.format("Команда с ID: %s не найдена", id)));
    }

    @Override
    public TeamDto create(TeamDto teamDto) {
        var teamEntity = teamsEntityMapper.map(teamDto);
        return teamDtoMapper.map(teamsRepo.save(teamEntity));
    }

    @Override
    public TeamDto update() {
        return null;
    }

    @Override
    public void delete(Long id) {
        teamsRepo.deleteById(id);
    }
}