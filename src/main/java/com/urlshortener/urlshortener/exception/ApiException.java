package com.urlshortener.urlshortener.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.ZonedDateTime;

/**
 * ApiException is model for CustomException messages.
 *
 * @author Kayhan Öztürk
 * @version  0.1
 * @since    0.1
 *
 */
@Data
@AllArgsConstructor
public class ApiException {
    private final String message;
    private final HttpStatus httpStatus;
    private final ZonedDateTime timeStamp;
}