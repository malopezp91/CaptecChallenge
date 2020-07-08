package com.captec.challenge.calculator;

import static com.captec.challenge.calculator.Utils.ADD_CHAR;
import static com.captec.challenge.calculator.Utils.DIGITS;
import static com.captec.challenge.calculator.Utils.ERROR;
import static com.captec.challenge.calculator.Utils.INITIAL_DISPLAY_LABEl;
import static com.captec.challenge.calculator.Utils.VALID_SYMBOLS;

/**
 * Calculator
 * Contains all logic for adding, clearing and equals.
 */
public class Calculator {

    private String display;
    private int previousValue = 0;
    private int currentValue = 0;

    public String process(char input) {
        if (VALID_SYMBOLS.contains(input)) {
            processSymbol(input);
            return display;
        } else if (DIGITS.contains(input)) {
            processDigit(input);
            return display;
        }
        return null;
    }

    private void processSymbol(char symbol) {
        if (ADD_CHAR == symbol) {
            processAdd();
        }
    }

    private void processAdd() {
        if (currentValue == 0) {
            reset();
            display = INITIAL_DISPLAY_LABEl;
        } else {
            try {
                int result = Math.addExact(previousValue, currentValue);
                previousValue = result;
                currentValue = 0;
                display = String.valueOf(result);
            } catch (ArithmeticException e) {
                reset();
                display = ERROR;
            }
        }
    }

    private void processDigit(char digit) {
        try {
            int tempValue = Math.multiplyExact(currentValue, 10);
            currentValue = Math.addExact(tempValue, Integer.parseInt(Character.toString(digit)));
            display = String.valueOf(currentValue);
        } catch (ArithmeticException e) {
            reset();
            display = ERROR;
        }
    }

    private void reset() {
        previousValue = 0;
        currentValue = 0;
    }
}
