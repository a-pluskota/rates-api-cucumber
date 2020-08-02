package io.ratesapi.response;

/**
 * This class provides a rates API error response model in Plain Old Java Object
 * that allows easy reading and validation of data received from the server.
 */
public class ErrorResponseInPOJOJsonModel {

    private String error;

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
