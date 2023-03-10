package user.api.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;
import user.enums.RolesEnum;

import java.time.Instant;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Schema(description = "Пользователь")
public class UserDto {

    private Long id;
    private String firstname;
    private String lastname;
    private String middlename;
    @Enumerated(EnumType.STRING)
    private RolesEnum role;
    private LocalDate birthDt;
}