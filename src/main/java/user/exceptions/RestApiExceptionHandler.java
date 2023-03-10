package user.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import user.exceptions.Dto.RestApiExceptionDto;

@ControllerAdvice
public class RestApiExceptionHandler {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    @ExceptionHandler
    public RestApiExceptionDto restException(RestApiException e){
        return RestApiExceptionDto.builder()
                .massage(e.getMessage())
                .status(HttpStatus.NOT_FOUND.value())
                .build();
    }
}
