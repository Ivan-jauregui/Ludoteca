package com.ludoteca.dtos.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import org.springframework.http.HttpStatus;


import java.time.LocalDateTime;
import java.util.Map;


@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ErrorResponse {
    private HttpStatus status;
    private String error;
    private String message;
    private String path;
    private LocalDateTime timestamp;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    Map<String,String> validations;

    public ErrorResponse() {
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public Map<String, String> getValidations() {
        return validations;
    }

    public void setValidations(Map<String, String> validations) {
        this.validations = validations;
    }
}
