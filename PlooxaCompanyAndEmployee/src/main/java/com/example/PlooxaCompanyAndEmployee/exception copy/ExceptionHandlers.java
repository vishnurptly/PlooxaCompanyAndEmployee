package webresort.exception;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.bind.support.WebExchangeBindException;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import webresort.resort.Payload.ApiBasicResponse;

@Slf4j
@Order(Ordered.HIGHEST_PRECEDENCE)
@RestControllerAdvice
public class ExceptionHandlers {

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ApiBasicResponse<Object> serverExceptionHandler(Exception ex) {
        log.error(ex.getMessage(), ex);
        return new ApiBasicResponse<Object>(false, "Something went wrong, please try again");
    }

    @ExceptionHandler(WebExchangeBindException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    protected ApiBasicResponse<List<String>> handleMethodArgumentNotValid(WebExchangeBindException ex) {
        var errors = ex.getBindingResult()
                .getAllErrors()
                .stream()
                .map(DefaultMessageSourceResolvable::getDefaultMessage)
                .collect(Collectors.toList());
        return new ApiBasicResponse<List<String>>(false, "Validation error, Please check your input", errors);
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    protected ApiBasicResponse<String> handleMissingServletRequestParameterException(
            MethodArgumentTypeMismatchException ex) {
        String error = ex.getName() + " should be of type " + ex.getRequiredType().getName();
        return new ApiBasicResponse<String>(false, ex.getLocalizedMessage(), error);
    }

    @ExceptionHandler(com.datastax.oss.driver.api.core.servererrors.UnauthorizedException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public ApiBasicResponse<Object> handleUnauthorizedException(Exception ex) {
        log.error(ex.getMessage());
        return new ApiBasicResponse<Object>(false, ex.getMessage());
    }

    @ExceptionHandler(DuplicateResourceException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public ApiBasicResponse<Object> handleDuplicateResourceException(Exception ex) {
        log.error(ex.getMessage());
        return new ApiBasicResponse<Object>(false, ex.getMessage());
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ApiBasicResponse<Object> handleResourceNotFoundException(Exception ex) {
        log.error(ex.getMessage());
        return new ApiBasicResponse<Object>(false, ex.getMessage());
    }

    // @ExceptionHandler(FeignException.class)
    // public String handleFeignStatusException(FeignException e, HttpServletResponse response) {
    //     response.setStatus(e.status());
    //     return "feignError";
    // }

}