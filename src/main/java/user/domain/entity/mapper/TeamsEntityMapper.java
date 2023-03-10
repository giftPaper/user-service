package user.domain.entity.mapper;

import org.springframework.stereotype.Component;
import user.api.dto.TeamDto;
import user.domain.entity.TeamsEntity;

@Component
public class TeamsEntityMapper {
    public TeamsEntity map(TeamDto teamDto){
        return TeamsEntity.builder()
                .teamName(teamDto.getTeamName())
                .description(teamDto.getDescription())
                .build();
    }
}
