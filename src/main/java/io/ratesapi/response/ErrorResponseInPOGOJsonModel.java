package io.ratesapi.response;

/**
 * This class provides a rates API error response model that allows
 * easy reading and validation of data received from the server.
 */
public class ErrorResponseInPOGOJsonModel {

    private String error;

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
