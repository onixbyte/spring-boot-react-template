package com.onixbyte.server.controller.advice;

import com.onixbyte.server.data.response.ExceptionResponse;
import com.onixbyte.server.exception.BizException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * ExceptionAdvise is a global exception handler.
 *
 * @author zihluwang
 */
@RestControllerAdvice
public class ExceptionAdvise {

    /**
     * Logger instance.
     */
    private static final Logger log = LoggerFactory.getLogger(ExceptionAdvise.class);

    /**
     * Exception handler for {@link BizException}.
     *
     * @param ex exception instance
     * @return response entity represents this exception
     */
    @ExceptionHandler(BizException.class)
    public ResponseEntity<ExceptionResponse> handleBizException(BizException ex) {
        return ex.composeResponse();
    }

}
