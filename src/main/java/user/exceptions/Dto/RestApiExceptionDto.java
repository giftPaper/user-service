package user.exceptions.Dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
@Builder
public class RestApiExceptionDto {
    private int status;
    private String massage;
}
