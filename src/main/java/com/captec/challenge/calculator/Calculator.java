package com.captec.challenge.calculator;

import static com.captec.challenge.calculator.Utils.ADD_CHAR;
import static com.captec.challenge.calculator.Utils.CLEAR_CHAR;
import static com.captec.challenge.calculator.Utils.DIGITS;
import static com.captec.challenge.calculator.Utils.EQUALS_CHAR;
import static com.captec.challenge.calculator.Utils.ERROR;
import static com.captec.challenge.calculator.Utils.INITIAL_DISPLAY_LABEl;
import static com.captec.challenge.calculator.Utils.VALID_SYMBOLS;

/**
 * Calculator
 * Contains all logic for adding, clearing and equals.
 */
public class Calculator {

    private String display;
    private int runningTotal = 0;
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
        switch (symbol) {
            case ADD_CHAR:
                processAdd();
                break;
            case CLEAR_CHAR:
                processClear();
                break;
            case EQUALS_CHAR:
                processEquals();
                break;
        }
    }

    private void processAdd() {
        if (currentValue == 0) {
            reset();
            display = INITIAL_DISPLAY_LABEl;
        } else {
            try {
                int result = Math.addExact(runningTotal, currentValue);
                runningTotal = result;
                currentValue = 0;
                display = String.valueOf(result);
            } catch (ArithmeticException e) {
                reset();
                display = ERROR;
            }
        }
    }

    private void processClear() {
        reset();
        display = INITIAL_DISPLAY_LABEl;
    }

    private void processEquals() {
        display = String.valueOf(runningTotal);
        reset();
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
        runningTotal = 0;
        currentValue = 0;
    }
}
