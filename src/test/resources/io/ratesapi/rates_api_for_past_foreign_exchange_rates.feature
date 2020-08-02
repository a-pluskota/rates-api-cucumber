Feature: Rates API for Past Foreign Exchange rates

  @rates_api_past_1
  Scenario Outline: Validate the response success status for the past reference exchange rates without using any additional parameters.
    Given Prepare the reference exchange rates request without using any additional parameters
    When Submit a request with the GET method to the correct API url with date "<date_value>" of the past reference exchange rates
    Then The status code of the returned response is 200

    Examples:
      | date_value |
      | 1999-01-04 |
      | 2020-02-29 |
      | today      |

  @rates_api_past_2
  Scenario Outline: Validate the response success status for the past reference exchange rates with symbols parameter.
    Given Prepare the reference exchange rates request using parameter "symbols" with value "<symbols_value>"
    When Submit a request with the GET method to the correct API url with date "<date_value>" of the past reference exchange rates
    Then The status code of the returned response is 200

    Examples:
      | symbols_value | date_value |
      | USD           | 1999-01-04 |
      | GBP           | 2016-02-29 |
      | USD,GBP       | today      |

  @rates_api_past_3
  Scenario Outline: Validate the response success status for the past reference exchange rates with base parameter.
    Given Prepare the reference exchange rates request using parameter "base" with value "<base_value>"
    When Submit a request with the GET method to the correct API url with date "<date_value>" of the past reference exchange rates
    Then The status code of the returned response is 200

    Examples:
      | base_value | date_value |
      | USD        | 1999-01-04 |
      | GBP        | 2016-02-29 |
      | EUR        | today      |

  @rates_api_past_4
  Scenario Outline: Validate the response success status for the past reference exchange rates with symbol and base parameter.
    Given Prepare the reference exchange rates request using parameters "symbols" with value "<symbols_value>" and "base" with value "<base_value>"
    When Submit a request with the GET method to the correct API url with date "<date_value>" of the past reference exchange rates
    Then The status code of the returned response is 200

    Examples:
      | symbols_value | base_value | date_value |
      | GBP           | USD        | 1999-01-04 |
      | USD           | GBP        | 2020-02-29 |
      | USD,GBP       | EUR        | today      |

  @rates_api_past_5
  Scenario Outline: Validate the response for the past reference exchange rates without using any additional parameters.
    Given Prepare the reference exchange rates request without using any additional parameters
    When Submit a request with the GET method to the correct API url with date "<date_value>" of the past reference exchange rates
    Then The content type of the response is "application/json"
    Then The response has correct field names and data types
    Then The response field base contains value "EUR"
    Then The response field date contains value of date in_yyyy_mm_dd format

    Examples:
      | date_value |
      | 1999-01-04 |
      | 2016-02-29 |
      | today      |


  @rates_api_past_6
  Scenario Outline: Validate the response for the past reference exchange rates with symbols parameter.
    Given Prepare the reference exchange rates request using parameter "symbols" with value "<symbols_value>"
    When Submit a request with the GET method to the correct API url with date "<date_value>" of the past reference exchange rates
    Then The content type of the response is "application/json"
    Then The response has correct field names and data types
    Then The response field base contains value "EUR"
    Then The response field rates contains field "<symbols_value>"
    Then The response field date contains value "<date_value>"

    Examples:
      | symbols_value | date_value |
      | USD           | 1999-01-04 |
      | GBP           | 2016-02-29 |

  @rates_api_past_7
  Scenario Outline: Validate the response for the past reference exchange rates with base parameter.
    Given Prepare the reference exchange rates request using parameter "base" with value "<base_value>"
    When Submit a request with the GET method to the correct API url with date "<date_value>" of the past reference exchange rates
    Then The content type of the response is "application/json"
    Then The response has correct field names and data types
    Then The response field base contains value "<base_value>"
    Then The response field date contains value "<date_value>"

    Examples:
      | base_value | date_value |
      | USD        | 1999-01-04 |
      | GBP        | 2016-02-29 |

  @rates_api_past_8
  Scenario Outline: Validate the response for the past reference exchange rates with two symbols parameter.
    Given Prepare the reference exchange rates request using parameter "symbols" with two values "<symbols_first_value>" and "<symbols_second_value>"
    When Submit a request with the GET method to the correct API url with date "<date_value>" of the past reference exchange rates
    Then The content type of the response is "application/json"
    Then The response has correct field names and data types
    Then The response field base contains value "EUR"
    Then The response field rates contains field "<symbols_first_value>"
    Then The response field rates contains field "<symbols_second_value>"
    Then The response field date contains value "<date_value>"

    Examples:
      | symbols_first_value |symbols_second_value | date_value |
      | USD                 | GBP                 | 1999-01-04 |
      | GBP                 | GBP                 | 2016-02-29 |

  @rates_api_past_9
  Scenario Outline: Validate the response for the past reference exchange rates with symbol and base parameter.
    Given Prepare the reference exchange rates request using parameters "symbols" with value "<symbols_value>" and "base" with value "<base_value>"
    When Submit a request with the GET method to the correct API url with date "<date_value>" of the past reference exchange rates
    Then The content type of the response is "application/json"
    Then The response has correct field names and data types
    Then The response field rates contains field "<symbols_value>"
    Then The response field base contains value "<base_value>"
    Then The response field date contains value "<date_value>"

    Examples:
      | symbols_value | base_value | date_value |
      | GBP           | USD        | 1999-01-04 |
      | USD           | GBP        | 2016-02-29 |

  @rates_api_past_10
  Scenario Outline: Validate the response bad request status for the past reference exchange rates with incorrect symbol and/or incorrect base parameter.
    Given Prepare the reference exchange rates request using parameters "symbols" with value "<symbols_value>" and "base" with value "<base_value>"
    When Submit a request with the GET method to the correct API url with date "<date_value>" of the past reference exchange rates
    Then The status code of the returned response is 400

    Examples:
      | symbols_value | base_value | date_value |
      | ERR           | GBP        | 1999-01-04 |
      | USD           | ERR        | 2016-02-29 |
      | ERR           | ERR        | today      |

  @rates_api_past_11
  Scenario Outline: Validate the response for the past reference exchange rates with incorrect date parameter.
    Given Prepare the reference exchange rates request using parameters "symbols" with value "<symbols_value>" and "base" with value "<base_value>"
    When Submit a request with the GET method to the correct API url with date "<date_value>" of the past reference exchange rates
    Then The response contains error field
    Then The response field error contains "<validation_message>"

    Examples:
      | symbols_value | base_value | date_value | validation_message           |
      | ERR           | GBP        | 1999-01-04 | Symbols 'ERR' are invalid    |
      | USD           | ERR        | 2016-02-29 | Base 'ERR' is not supported. |
      | ERR           | ERR        | today      | Base 'ERR' is not supported. |

  @rates_api_past_12
  Scenario Outline: Validate the response bad request status for the past reference exchange rates with incorrect date parameter.
    Given Prepare the reference exchange rates request without using any additional parameters
    When Submit a request with the GET method to the correct API url with date "<date_value>" of the past reference exchange rates
    Then The status code of the returned response is 400

    Examples:
      | date_value |
      | 1998-12-31 |
      | 2019-02-29 |
      | 2016-29-02 |
      | dddd-mm-dd |
      | 19990401   |

  @rates_api_past_13
  Scenario Outline: Validate the response for the past reference exchange rates with incorrect date parameter.
    Given Prepare the reference exchange rates request without using any additional parameters
    When Submit a request with the GET method to the correct API url with date "<date_value>" of the past reference exchange rates
    Then The response contains error field
    Then The response field error contains "<validation_message>"

    Examples:
      | date_value | validation_message                                      |
      | 1998-12-31 | There is no data for dates older then 1999-01-04.       |
      | 2019-02-29 | day is out of range for month                           |
      | 2016-29-02 | time data '2016-29-02' does not match format '%Y-%m-%d' |
      | dddd-mm-dd | time data 'dddd-mm-dd' does not match format '%Y-%m-%d' |
      | 19990401   | time data '19990401' does not match format '%Y-%m-%d'   |