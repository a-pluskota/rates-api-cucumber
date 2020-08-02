package io.ratesapi.request;

import com.jayway.restassured.specification.RequestSpecification;

import static com.jayway.restassured.RestAssured.given;

/**
 * @see <a href="http://ratesapi.io/documentation/">Rates API</a>
 * <p>
 * This class provides methods for creating and sending request specification to rates API.
 */
public class RequestSpecificationBuilder {

    /**
     * Uses REST assured to specify how the request will look like without any parameters.
     *
     * @return The request specification
     */
    public RequestSpecification buildRequestSpecificationWithoutAnyParams() {

        return given()
                .contentType("application/json");
    }

    /**
     * Uses REST assured to specify how the request will look like with one additional parameter.
     *
     * @param paramName Specify a parameter name that'll be sent with the request
     * @param paramValue Specify a parameter paramName value that'll be sent with the request
     * @return The request specification
     */
    public RequestSpecification buildRequestSpecificationWithOneParam(
            String paramName,
            String paramValue
    ) {

        return buildRequestSpecificationWithoutAnyParams()
                .param(paramName, paramValue);
    }

    /**
     * Uses REST assured to specify how the request will look like with two additional parameters.
     *
     * @param firstParamName Specify a first parameter name that'll be sent with the request
     * @param firstParamValue Specify a parameter firstParamValue value that'll be sent with the request
     * @param secondParamName Specify a second parameter name that'll be sent with the request
     * @param secondParamValue Specify a parameter secondParamName value that'll be sent with the request
     * @return The request specification
     */
    public RequestSpecification buildRequestSpecificationWithTwoParams(
            String firstParamName,
            String firstParamValue,
            String secondParamName,
            String secondParamValue
    ) {

        return buildRequestSpecificationWithoutAnyParams()
                .param(firstParamName, firstParamValue)
                .param(secondParamName, secondParamValue);
    }
}
