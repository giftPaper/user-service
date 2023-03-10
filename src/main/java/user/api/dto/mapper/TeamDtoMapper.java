package user.api.dto.mapper;

import org.springframework.stereotype.Component;
import user.api.dto.TeamDto;
import user.domain.entity.TeamsEntity;

@Component
public class TeamDtoMapper {

    public TeamDto map(TeamsEntity teamsEntity){

        return TeamDto.builder()
                .id(teamsEntity.getId())
                .teamName(teamsEntity.getTeamName())
                .description(teamsEntity.getDescription())
                .build();
    }
}
