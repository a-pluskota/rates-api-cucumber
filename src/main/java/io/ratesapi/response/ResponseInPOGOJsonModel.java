package io.ratesapi.response;

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
