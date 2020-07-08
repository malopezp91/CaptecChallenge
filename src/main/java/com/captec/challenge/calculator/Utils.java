package com.captec.challenge.calculator;

import com.google.common.collect.ImmutableSet;

import java.util.Set;

/**
 * Utils
 * Includes constant values and helper methods.
 */
public final class Utils {

    // Texts and labels to be displayed
    public static final String APP_TITLE = "Captec Awesome Calculator!";
    public static final String ERROR = "ERROR!";
    public static final String INITIAL_DISPLAY_LABEl = "0";
    public static final String START_OF_LINE = "> ";

    // Accepted values of inputs
    public static final char DEFAULT_CHAR = '-';
    public static final char ESCAPE_CHAR = 'e';
    public static final char ADD_CHAR = '+';
    public static final char EQUALS_CHAR = '=';
    public static final char CLEAR_CHAR = 'C';
    public static final Set DIGITS =
            ImmutableSet.of('0', '1', '2', '3', '4', '5', '6', '7', '8', '9');
    public static final Set VALID_SYMBOLS =
            ImmutableSet.of(EQUALS_CHAR, ADD_CHAR, CLEAR_CHAR, ESCAPE_CHAR);

    public static String formatOutput(String result) {
        return START_OF_LINE + result;
    }
}
