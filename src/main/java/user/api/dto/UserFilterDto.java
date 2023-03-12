package user.api.dto;

import io.swagger.v3.oas.annotations.Parameter;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserFilterDto {

    @NotNull
    @Parameter
    private Integer page;

    @NotNull
    @Parameter
    private Integer size;

    @Parameter
    private String searchBy;

}
