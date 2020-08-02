Feature: Rates API for Latest Foreign Exchange rates

  @rates_api_latest_1
  Scenario: Validate the response success status for the latest reference exchange rates without using any additional parameters.
    Given Prepare the reference exchange rates request without using any additional parameters
    When Submit a request with the GET method to the correct API url of the latest reference exchange rates
    Then The status code of the returned response is 200

  @rates_api_latest_2
  Scenario Outline: Validate the response success status for the latest reference exchange rates with symbols parameter.
    Given Prepare the reference exchange rates request using parameter "symbols" with value "<symbols_value>"
    When Submit a request with the GET method to the correct API url of the latest reference exchange rates
    Then The status code of the returned response is 200

    Examples:
      | symbols_value |
      | USD           |
      | GBP           |
      | USD,GBP       |

  @rates_api_latest_3
  Scenario Outline: Validate the response success status for the latest reference exchange rates with base parameter.
    Given Prepare the reference exchange rates request using parameter "base" with value "<base_value>"
    When Submit a request with the GET method to the correct API url of the latest reference exchange rates
    Then The status code of the returned response is 200

    Examples:
      | base_value |
      | USD        |
      | GBP        |

  @rates_api_latest_4
  Scenario Outline: Validate the response success status for the latest reference exchange rates with symbol and base parameter.
    Given Prepare the reference exchange rates request using parameters "symbols" with value "<symbols_value>" and "base" with value "<base_value>"
    When Submit a request with the GET method to the correct API url of the latest reference exchange rates
    Then The status code of the returned response is 200

    Examples:
      | symbols_value | base_value |
      | GBP           | USD        |
      | USD           | GBP        |

  @rates_api_latest_5
  Scenario: Validate the response for the latest reference exchange rates without using any additional parameters.
    Given Prepare the reference exchange rates request without using any additional parameters
    When Submit a request with the GET method to the correct API url of the latest reference exchange rates
    Then The content type of the response is "application/json"
    Then The response has correct field names and data types
    Then The response field base contains value "EUR"
    Then The response field date contains value of date in_yyyy_mm_dd format

  @rates_api_latest_6
  Scenario Outline: Validate the response for the latest reference exchange rates with symbols parameter.
    Given Prepare the reference exchange rates request using parameter "symbols" with value "<symbols_value>"
    When Submit a request with the GET method to the correct API url of the latest reference exchange rates
    Then The content type of the response is "application/json"
    Then The response has correct field names and data types
    Then The response field base contains value "EUR"
    Then The response field rates contains field "<symbols_value>"
    Then The response field date contains value of date in_yyyy_mm_dd format

    Examples:
      | symbols_value |
      | USD           |
      | GBP           |

  @rates_api_latest_7
  Scenario Outline: Validate the response for the latest reference exchange rates with base parameter.
    Given Prepare the reference exchange rates request using parameter "base" with value "<base_value>"
    When Submit a request with the GET method to the correct API url of the latest reference exchange rates
    Then The content type of the response is "application/json"
    Then The response has correct field names and data types
    Then The response field base contains value "<base_value>"
    Then The response field date contains value of date in_yyyy_mm_dd format

    Examples:
      | base_value |
      | USD        |
      | GBP        |

  @rates_api_latest_8
  Scenario Outline: Validate the response for the latest reference exchange rates with two symbols parameter.
    Given Prepare the reference exchange rates request using parameter "symbols" with two values "<symbols_first_value>" and "<symbols_second_value>"
    When Submit a request with the GET method to the correct API url of the latest reference exchange rates
    Then The content type of the response is "application/json"
    Then The response has correct field names and data types
    Then The response field base contains value "EUR"
    Then The response field date contains value of date in_yyyy_mm_dd format
    Then The response field rates contains field "<symbols_first_value>"
    Then The response field rates contains field "<symbols_second_value>"

    Examples:
      | symbols_first_value |symbols_second_value |
      | USD                 | GBP                 |
      | GBP                 | GBP                 |

  @rates_api_latest_9
  Scenario Outline: Validate the response for the latest reference exchange rates with symbol and base parameter.
    Given Prepare the reference exchange rates request using parameters "symbols" with value "<symbols_value>" and "base" with value "<base_value>"
    When Submit a request with the GET method to the correct API url of the latest reference exchange rates
    Then The content type of the response is "application/json"
    Then The response has correct field names and data types
    Then The response field rates contains field "<symbols_value>"
    Then The response field base contains value "<base_value>"
    Then The response field date contains value of date in_yyyy_mm_dd format

    Examples:
      | symbols_value | base_value |
      | GBP           | USD        |
      | USD           | GBP        |

  @rates_api_latest_10
  Scenario Outline: Validate the response bad request status for the latest reference exchange rates with incorrect symbol and/or incorrect base parameter.
    Given Prepare the reference exchange rates request using parameters "symbols" with value "<symbols_value>" and "base" with value "<base_value>"
    When Submit a request with the GET method to the correct API url of the latest reference exchange rates
    Then The status code of the returned response is 400

    Examples:
      | symbols_value | base_value |
      | ERR           | GBP        |
      | USD           | ERR        |
      | ERR           | ERR        |

  @rates_api_latest_11
  Scenario Outline: Validate the response for the latest reference exchange rates with incorrect symbol and/or incorrect base parameter.
    Given Prepare the reference exchange rates request using parameters "symbols" with value "<symbols_value>" and "base" with value "<base_value>"
    When Submit a request with the GET method to the correct API url of the latest reference exchange rates
    Then The response contains error field
    Then The response field error contains "<validation_message>"

    Examples:
      | symbols_value | base_value | validation_message           |
      | ERR           | GBP        | Symbols 'ERR' are invalid    |
      | USD           | ERR        | Base 'ERR' is not supported. |
      | ERR           | ERR        | Base 'ERR' is not supported. |

  @rates_api_latest_failing_test
  Scenario: Failing test of validate the response for the latest reference exchange rates without using any additional parameters.
    Given Prepare the reference exchange rates request without using any additional parameters
    When Submit a request with the GET method to the correct API url of the latest reference exchange rates
    Then The status code of the returned response is 400