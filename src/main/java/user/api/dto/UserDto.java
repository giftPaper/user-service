package user.api.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.time.Instant;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Schema(description = "Пользователь")
public class UserDto {

    private Long id;
    private String firstname;
    private String lastname;
    private String middlename;
    private Instant birthDt;
}