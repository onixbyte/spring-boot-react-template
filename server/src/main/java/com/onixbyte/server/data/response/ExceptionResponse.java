package com.onixbyte.server.data.response;

import java.time.LocalDateTime;

/**
 * ExceptionResponse represents the response data entity when exception occurs.
 *
 * @param message   the message of the exception
 * @param timestamp the time when the exception happened
 */
public record ExceptionResponse(
        String message,
        LocalDateTime timestamp
) {

    /**
     * Get a builder instance.
     *
     * @return a builder instance that supports chained-build process
     */
    public static ExceptionResponseBuilder builder() {
        return new ExceptionResponseBuilder();
    }

    /**
     * Builder of {@code ExceptionResponse}.
     */
    public static class ExceptionResponseBuilder {
        private String message;
        private LocalDateTime timestamp;

        /**
         * Private constructor prevent from instantiate by other classes.
         */
        private ExceptionResponseBuilder() {
        }

        /**
         * Set the message of a {@code ExceptionResponse}.
         *
         * @param message the message of a business exception
         * @return the builder instance
         */
        public ExceptionResponseBuilder message(String message) {
            this.message = message;
            return this;
        }

        /**
         * Set the timestamp of a {@code ExceptionResponse}.
         *
         * @param timestamp the timestamp of a business exception
         * @return the builder instance
         */
        public ExceptionResponseBuilder timestamp(LocalDateTime timestamp) {
            this.timestamp = timestamp;
            return this;
        }

        /**
         * Construct a {@code ExceptionResponse}.
         *
         * @return an instance of {@code ExceptionResponse}
         */
        public ExceptionResponse build() {
            return new ExceptionResponse(message, timestamp);
        }
    }

}
