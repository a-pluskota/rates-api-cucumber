package io.ratesapi.response;

/**
 * This class provides a rates API response model in Plain Old Java Object
 * that allows easy reading and validation of data received from the server.
 */
public class ResponseInPOJOJsonModel {

    private String base;
    private RatesInPOJOJsonModel ratesInPOJOJsonModel;
    private String date;

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public RatesInPOJOJsonModel getRatesInPOJOJsonModel() {
        return ratesInPOJOJsonModel;
    }

    public void setRatesInPOJOJsonModel(RatesInPOJOJsonModel ratesInPOJOJsonModel) {
        this.ratesInPOJOJsonModel = ratesInPOJOJsonModel;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
