package io.ratesapi.request;

import com.jayway.restassured.specification.RequestSpecification;

import java.util.HashMap;
import java.util.Map;

import static com.jayway.restassured.RestAssured.given;

/**
 * @see <a href="http://ratesapi.io/documentation/">Rates API</a>
 * <p>
 * This class provides methods for creating request specification to rates API.
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
     * Uses REST assured to specify how the request will look like with two additional parameters
     *
     * @param parameters HashMap of parameters to send, where keys specify a parameters names
     * and values specify a parameters values
     * @return The request specification
     */
    public RequestSpecification buildRequestSpecificationWithParams(
            HashMap<String, Object> parameters
    ) {

        RequestSpecification requestSpecification = buildRequestSpecificationWithoutAnyParams();

        for(Map.Entry<String, Object> entry : parameters.entrySet()) {

            String paramName = entry.getKey();
            Object paramValue = entry.getValue();

            requestSpecification
                    .param(paramName, paramValue);
        }

        return requestSpecification;
    }
}
