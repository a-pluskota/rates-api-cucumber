package io.ratesapi.helpers;

import java.util.regex.Pattern;

/**
 * This class contains methods to help you manage the date and its format.
 */
public class DateHelper implements DateMatcher {

    private static Pattern DATE_PATTERN = Pattern
            .compile("^\\d{4}-\\d{2}-\\d{2}$");

    @Override
    public boolean matches(String date) {
        return DATE_PATTERN
                .matcher(date)
                .matches();
    }
}
