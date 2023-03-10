package user.api.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.time.Instant;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Schema(description = "Команда")
public class TeamDto {

    private Long id;
    private String teamName;
    private String description;
}
