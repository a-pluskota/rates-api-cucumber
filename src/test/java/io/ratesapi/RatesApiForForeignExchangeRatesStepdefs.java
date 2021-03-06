package io.ratesapi;

import com.jayway.restassured.response.ValidatableResponse;
import com.jayway.restassured.specification.RequestSpecification;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.ratesapi.helpers.DateHelper;
import io.ratesapi.request.RequestBuilder;
import io.ratesapi.request.RequestSpecificationBuilder;
import io.ratesapi.response.ErrorResponseInPOJOJsonModel;
import io.ratesapi.response.ResponseInPOJOJsonModel;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;

import static org.hamcrest.collection.IsMapContaining.hasKey;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class RatesApiForForeignExchangeRatesStepdefs {

    private static final String BASE_FIELD_ASSERTION_MESSAGE
            = "Base response field do not have correct value.";
    private static final String DATE_FIELD_ASSERTION_MESSAGE
            = "Date response field do not have correct value.";
    private static final String ERROR_FIELD_ASSERTION_MESSAGE
            = "Error response field do not have correct value.";

    private RequestSpecification requestSpecificationForForeignExchangeRates;
    private HashMap<String, Object> mapOfParametersOfRequestForForeignExchangeRates;
    private ValidatableResponse validatableResponseFromForeignExchangeRates;
    private ResponseInPOJOJsonModel responseFromForeignExchangeRatesInPOJOJsonModel;
    private ErrorResponseInPOJOJsonModel errorResponseFromForeignExchangeRatesInPOGOJsonModel;

    @Given("Prepare the reference exchange rates request without using any additional parameters")
    public void prepare_the_reference_exchange_rates_request_without_using_any_additional_parameters() {

        this.requestSpecificationForForeignExchangeRates = new RequestSpecificationBuilder()
                .buildRequestSpecificationWithoutAnyParams()
                .log()
                .all();
    }

    @Given("Prepare the reference exchange rates request using parameter {string} with value {string}")
    public void prepare_the_reference_exchange_rates_request_using_parameter_with_value(
            String paramName,
            String paramValue
    ) {

        this.mapOfParametersOfRequestForForeignExchangeRates = new HashMap();
        this.mapOfParametersOfRequestForForeignExchangeRates.put(paramName, paramValue);

        this.requestSpecificationForForeignExchangeRates = new RequestSpecificationBuilder()
                .buildRequestSpecificationWithParams(this.mapOfParametersOfRequestForForeignExchangeRates)
                .log()
                .all();
    }

    @Given("Prepare the reference exchange rates request using parameters {string} with value {string} and {string} with value {string}")
    public void prepare_the_reference_exchange_rates_request_using_parameters_with_value_and_with_value(
            String symbolsParamName,
            String symbolsParamValue,
            String baseParamName,
            String baseParamValue
    ) {

        this.mapOfParametersOfRequestForForeignExchangeRates = new HashMap();
        this.mapOfParametersOfRequestForForeignExchangeRates.put(symbolsParamName, symbolsParamValue);
        this.mapOfParametersOfRequestForForeignExchangeRates.put(baseParamName, baseParamValue);

        this.requestSpecificationForForeignExchangeRates = new RequestSpecificationBuilder()
                .buildRequestSpecificationWithParams(this.mapOfParametersOfRequestForForeignExchangeRates)
                .log()
                .all();

    }

    @Given("Prepare the reference exchange rates request using parameter {string} with two values {string} and {string}")
    public void prepare_the_reference_exchange_rates_request_using_parameter_with_two_values(
            String paramName,
            String firstParamValue,
            String secondParamValue
    ) {

        String concatParamValue = firstParamValue.concat(",").concat(secondParamValue);

        this.mapOfParametersOfRequestForForeignExchangeRates = new HashMap();
        this.mapOfParametersOfRequestForForeignExchangeRates.put(paramName, concatParamValue);

        this.requestSpecificationForForeignExchangeRates = new RequestSpecificationBuilder()
                .buildRequestSpecificationWithParams(this.mapOfParametersOfRequestForForeignExchangeRates)
                .log()
                .all();
    }

    @When("Submit a request with the GET method to the correct API url of the latest reference exchange rates")
    public void submit_a_request_with_the_get_method_to_the_correct_api_url_of_the_latest_reference_exchange_rates() {

        this.validatableResponseFromForeignExchangeRates
                = new RequestBuilder(this.requestSpecificationForForeignExchangeRates)
                .sendRequestForLatestForeignExchangeRates()
                .then()
                .assertThat()
                .log()
                .all();
    }

    @When("Submit a request with the GET method to the correct API url with date {string} of the past reference exchange rates")
    public void submit_a_request_with_the_get_method_to_the_correct_api_url_with_date_of_the_past_reference_exchange_rates(
            String date
    ) {

        if (date.equals("today")) {
            date = LocalDate
                    .now()
                    .format(DateTimeFormatter
                    .ofPattern("yyyy-MM-dd"));
        }

        this.validatableResponseFromForeignExchangeRates = new RequestBuilder(this.requestSpecificationForForeignExchangeRates)
                .sendRequestForPastForeignExchangeRates(date)
                .then()
                .assertThat()
                .log()
                .all();
    }

    @Then("The status code of the returned response is {int}")
    public void the_status_code_of_the_returned_response_is(
            int statusCode
    ) {

        this.validatableResponseFromForeignExchangeRates
                .statusCode(statusCode);
    }

    @Then("The content type of the response is {string}")
    public void the_content_type_of_the_response_is(
            String expectedContentType
    ) {

        validatableResponseFromForeignExchangeRates
                .contentType(expectedContentType);
    }

    @Then("The response has correct field names and data types")
    public void the_response_has_correct_field_names_and_data_types() {

        this.responseFromForeignExchangeRatesInPOJOJsonModel = validatableResponseFromForeignExchangeRates
                .extract()
                .as(ResponseInPOJOJsonModel.class);
    }

    @Then("The response field base contains value {string}")
    public void the_response_field_base_contains_value(
            String baseFieldExpectedValue
    ) {

        assertEquals(BASE_FIELD_ASSERTION_MESSAGE,
                baseFieldExpectedValue,
                this.responseFromForeignExchangeRatesInPOJOJsonModel.getBase());
    }

    @Then("The response field rates contains field {string}")
    public void the_response_field_rates_contains_field(
            String ratesFieldName
    ) {

        this.validatableResponseFromForeignExchangeRates
                .body("rates", hasKey(ratesFieldName));
    }

    @Then("The response field date contains value of date in_yyyy_mm_dd format")
    public void the_response_field_date_contains_value_of_date_in_yyyy_mm_dd_format() {

        assertTrue(DATE_FIELD_ASSERTION_MESSAGE,
                new DateHelper().matches(
                        this.responseFromForeignExchangeRatesInPOJOJsonModel.getDate()));
    }

    @Then("The response contains error field")
    public void the_response_contains_error_field() {

        this.errorResponseFromForeignExchangeRatesInPOGOJsonModel = validatableResponseFromForeignExchangeRates
                .extract()
                .as(ErrorResponseInPOJOJsonModel.class);
    }

    @Then("The response field error contains {string}")
    public void the_response_field_error_contains(
            String expectedValidationMessage
    ) {

        assertTrue(ERROR_FIELD_ASSERTION_MESSAGE,
                this.errorResponseFromForeignExchangeRatesInPOGOJsonModel
                        .getError()
                        .contains(expectedValidationMessage));
    }

    @Then("The response field date contains value {string}")
    public void the_response_field_date_contains_value(
            String dateFieldExpectedValue
    ) {
        assertEquals(DATE_FIELD_ASSERTION_MESSAGE,
                dateFieldExpectedValue,
                this.responseFromForeignExchangeRatesInPOJOJsonModel.getDate());
    }

}
