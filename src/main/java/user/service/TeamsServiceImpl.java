package user.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import user.api.dto.PageDto;
import user.api.dto.TeamDto;
import user.api.dto.mapper.TeamDtoMapper;
import user.domain.entity.TeamsEntity;
import user.domain.entity.mapper.TeamsEntityMapper;
import user.domain.repo.TeamsRepo;
import user.exceptions.RestApiException;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TeamsServiceImpl implements TeamsService {

    private final TeamsRepo teamsRepo;
    private final TeamDtoMapper teamDtoMapper;
    private final TeamsEntityMapper teamsEntityMapper;

    @Override
    public PageDto getTeams(int page, int size) {
        PageRequest pageRequest = PageRequest.of(page, size);
        Page<TeamsEntity> team = teamsRepo.findAll(pageRequest);
        return PageDto.builder()
                .totalPages(team.getTotalPages())
                .totalElements(team.getTotalElements())
                .content(team.getContent().stream()
                        .map(teamDtoMapper::map)
                        .collect(Collectors.toList()))
                .build();
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
    //todo Пока нинада
    @Override
    public TeamDto update() {
        return null;
    }

    @Override
    public void delete(Long id) {
        teamsRepo.deleteById(id);
    }
}