package io.ratesapi.request;

import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;

/**
 * @see <a href="http://ratesapi.io/documentation/">Rates API</a>
 * <p>
 * This class provides methods for creating and sending requests to rates API.
 */
public class RequestBuilder {

    private static final String RATES_API_BASE_URL = "https://api.ratesapi.io/api";
    private static final String RATES_API_LATEST_URL = RATES_API_BASE_URL.concat("/latest");
    private RequestSpecification requestSpecificationForForeignExchangeRates;


    public RequestBuilder(
            RequestSpecification requestSpecificationForForeignExchangeRates
    ) {
        this.requestSpecificationForForeignExchangeRates = requestSpecificationForForeignExchangeRates;
    }

    /**
     * Uses REST assured to send request for latest foreign exchange rates.
     *
     * @return The response with the data from latest foreign exchange rates.
     */
    public Response sendRequestForLatestForeignExchangeRates() {

        return this.requestSpecificationForForeignExchangeRates
                .when()
                .get(RATES_API_LATEST_URL);
    }

    /**
     * Uses REST assured to send request for historical foreign exchange rates.
     *
     * @param date any date since 1999 in yyyy-MM-dd format
     * @return The response with the data from historical foreign exchange rates.
     */
    public Response sendRequestForPastForeignExchangeRates(
            String date
    ) {

        String pastForeignExchangeRatesUrl = RATES_API_BASE_URL
                .concat("/")
                .concat(date);

        return this.requestSpecificationForForeignExchangeRates
                .when()
                .get(pastForeignExchangeRatesUrl);
    }
}
