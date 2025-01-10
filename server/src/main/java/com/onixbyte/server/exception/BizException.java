package com.onixbyte.server.exception;

import com.onixbyte.server.data.response.ExceptionResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;

/**
 * BizException represents all business exceptions. By throwing this exception or any sub-exception,
 * the system will capture the exception and resolve it as {@link ExceptionResponse} automatically.
 *
 * @author zihluwang
 */
public class BizException extends RuntimeException {

    /**
     * The status of a web request.
     */
    private final HttpStatus status;

    /**
     * Get status of a web request.
     *
     * @return status of a web request
     */
    public HttpStatus getStatus() {
        return status;
    }

    /**
     * Constructor of {@code BizException}.
     *
     * @param status  status of a web request
     * @param message message of a business exception
     */
    public BizException(HttpStatus status, String message) {
        super(message);
        this.status = status;
    }

    /**
     * Constructor of {@code BizException}, the message will be specified as Spring-defined
     * status reason phrase.
     *
     * @param status status of a web request
     */
    public BizException(HttpStatus status) {
        super(status.getReasonPhrase());
        this.status = status;
    }

    public ResponseEntity<ExceptionResponse> composeResponse() {
        return ResponseEntity.status(status)
                .body(ExceptionResponse.builder()
                        .message(getMessage())
                        .timestamp(LocalDateTime.now())
                        .build());
    }

}
