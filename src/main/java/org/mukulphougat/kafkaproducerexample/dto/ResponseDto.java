package org.mukulphougat.kafkaproducerexample.dto;

import org.springframework.http.HttpStatus;

public class ResponseDto {
    private String message;
    private String status;
    public ResponseDto(String status, String message) {
        this.status = status;
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
