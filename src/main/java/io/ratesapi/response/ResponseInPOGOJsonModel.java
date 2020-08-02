package io.ratesapi.response;

/**
 * This class provides a rates API response model that allows
 * easy reading and validation of data received from the server.
 */
public class ResponseInPOGOJsonModel {

    private String base;
    private RatesInPOGOJsonModel ratesInPOGOJsonModel;
    private String date;

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public RatesInPOGOJsonModel getRatesInPOGOJsonModel() {
        return ratesInPOGOJsonModel;
    }

    public void setRatesInPOGOJsonModel(RatesInPOGOJsonModel ratesInPOGOJsonModel) {
        this.ratesInPOGOJsonModel = ratesInPOGOJsonModel;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
