package com.captec.challenge;

import com.captec.challenge.calculator.Calculator;
import com.google.common.collect.ImmutableList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * CalculatorTest
 * Tests that validates processing of digit inputs and symbols
 */
final class CalculatorTest {

    private Calculator calculator;

    @BeforeEach
    public void setup() {
        calculator = new Calculator();
    }

    @ParameterizedTest
    @ValueSource(chars = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'})
    public void calculator_processWithDigit_digitIsReturnedForDisplay(char input) {
        String response = calculator.process(input);

        assertEquals(String.valueOf(input), response);
    }

    @Test
    public void calculator_processAddSymbol_zeroIsReturned() {
        char input = '+';

        String response = calculator.process(input);

        assertEquals("0", response);
    }

    @Test
    public void calculator_processClearSymbol_zeroIsReturned() {
        char input = 'C';

        String response = calculator.process(input);

        assertEquals("0", response);
    }

    @Test
    public void calculator_processEqualsSymbol_zeroIsReturned() {
        char input = '=';

        String response = calculator.process(input);

        assertEquals("0", response);
    }

    @Test
    public void calculator_input3DigitNumber_fullNumberIsReturned() {
        List<Item> values = ImmutableList.of(
                new Item('4', "4"),
                new Item('5', "45"),
                new Item('6', "456")
        );

        for (Item item : values) {
            String result = calculator.process(item.getInput());
            assertEquals(item.getResult(), result);
        }
    }

    @Test
    public void calculator_input3DigitNumberAndAddSymbol_fullNumberIsReturned() {
        List<Item> values = ImmutableList.of(
                new Item('4', "4"),
                new Item('5', "45"),
                new Item('6', "456"),
                new Item('+', "456")
        );

        for (Item item : values) {
            String result = calculator.process(item.getInput());
            assertEquals(item.getResult(), result);
        }
    }

    @Test
    public void calculator_input3DigitNumberAndClearSymbol_resetIsReturned() {
        List<Item> values = ImmutableList.of(
                new Item('4', "4"),
                new Item('5', "45"),
                new Item('6', "456"),
                new Item('C', "0")
        );

        for (Item item : values) {
            String result = calculator.process(item.getInput());
            assertEquals(item.getResult(), result);
        }
    }

    @Test
    public void calculator_input3DigitNumberAndEqualsSymbol_zeroIsReturnedAsRunningTotalIsZero() {
        List<Item> values = ImmutableList.of(
                new Item('4', "4"),
                new Item('5', "45"),
                new Item('6', "456"),
                new Item('=', "0")
        );

        for (Item item : values) {
            String result = calculator.process(item.getInput());
            assertEquals(item.getResult(), result);
        }
    }

    @Test
    public void calculator_addingTwo1DigitsNumbersAndAddSymbol_resultIsReturned() {
        List<Item> values = ImmutableList.of(
                new Item('6', "6"),
                new Item('+', "6"),
                new Item('9', "9"),
                new Item('+', "15")
        );

        for (Item item : values) {
            String result = calculator.process(item.getInput());
            assertEquals(item.getResult(), result);
        }
    }

    @Test
    public void calculator_addingTwoDifferentDigitsNumbersAndAddSymbol_resultIsReturned() {
        List<Item> values = ImmutableList.of(
                new Item('6', "6"),
                new Item('0', "60"),
                new Item('+', "60"),
                new Item('3', "3"),
                new Item('+', "63")
        );

        for (Item item : values) {
            String result = calculator.process(item.getInput());
            assertEquals(item.getResult(), result);
        }
    }

    @Test
    public void calculator_addingTwoDifferentDigitsNumbersAndEqualsSymbol_firstNumberIsReturnedAsItIsTotalRunning() {
        List<Item> values = ImmutableList.of(
                new Item('6', "6"),
                new Item('0', "60"),
                new Item('+', "60"),
                new Item('3', "3"),
                new Item('=', "60")
        );

        for (Item item : values) {
            String result = calculator.process(item.getInput());
            assertEquals(item.getResult(), result);
        }
    }

    @Test
    public void calculator_addingTwoDifferentDigitsNumbersAndAddSymbolTwice_resetIsReturned() {
        List<Item> values = ImmutableList.of(
                new Item('6', "6"),
                new Item('0', "60"),
                new Item('+', "60"),
                new Item('3', "3"),
                new Item('+', "63"),
                new Item('+', "0")
        );

        for (Item item : values) {
            String result = calculator.process(item.getInput());
            assertEquals(item.getResult(), result);
        }
    }

    @Test
    public void calculator_addingTwoDifferentDigitsNumbersAndClearSymbolTwice_resetIsReturned() {
        List<Item> values = ImmutableList.of(
                new Item('6', "6"),
                new Item('0', "60"),
                new Item('+', "60"),
                new Item('3', "3"),
                new Item('C', "0"),
                new Item('C', "0")
        );

        for (Item item : values) {
            String result = calculator.process(item.getInput());
            assertEquals(item.getResult(), result);
        }
    }

    @Test
    public void calculator_addingTwoDifferentDigitsNumbersAndEqualsSymbolTwice_resetIsReturned() {
        List<Item> values = ImmutableList.of(
                new Item('6', "6"),
                new Item('0', "60"),
                new Item('+', "60"),
                new Item('3', "3"),
                new Item('=', "60"),
                new Item('=', "0")
        );

        for (Item item : values) {
            String result = calculator.process(item.getInput());
            assertEquals(item.getResult(), result);
        }
    }

    @Test
    public void calculator_addingTwoDifferentDigitsNumbersThenAddSymbolThenClearSymbol_resetIsReturned() {
        List<Item> values = ImmutableList.of(
                new Item('6', "6"),
                new Item('0', "60"),
                new Item('+', "60"),
                new Item('3', "3"),
                new Item('+', "63"),
                new Item('C', "0")
        );

        for (Item item : values) {
            String result = calculator.process(item.getInput());
            assertEquals(item.getResult(), result);
        }
    }

    @Test
    public void calculator_addingTwoDifferentDigitsNumbersThenAddSymbolThenEqualsSymbol_runningTotalIsReturned() {
        List<Item> values = ImmutableList.of(
                new Item('6', "6"),
                new Item('0', "60"),
                new Item('+', "60"),
                new Item('3', "3"),
                new Item('+', "63"),
                new Item('=', "63")
        );

        for (Item item : values) {
            String result = calculator.process(item.getInput());
            assertEquals(item.getResult(), result);
        }
    }

    @Test
    public void calculator_addingTwoDifferentNumbersAndAddSymbolTwiceAndNewAdding_resultIsReturned() {
        List<Item> values = ImmutableList.of(
                new Item('6', "6"),
                new Item('+', "6"),
                new Item('3', "3"),
                new Item('+', "9"),
                new Item('+', "0"),
                new Item('4', "4"),
                new Item('+', "4"),
                new Item('7', "7"),
                new Item('+', "11")
        );

        for (Item item : values) {
            String result = calculator.process(item.getInput());
            assertEquals(item.getResult(), result);
        }
    }

    @Test
    public void calculator_addingTwoDifferentNumbersAndClearSymbolAndNewAdding_resultIsReturned() {
        List<Item> values = ImmutableList.of(
                new Item('6', "6"),
                new Item('+', "6"),
                new Item('3', "3"),
                new Item('+', "9"),
                new Item('C', "0"),
                new Item('4', "4"),
                new Item('+', "4"),
                new Item('7', "7"),
                new Item('+', "11")
        );

        for (Item item : values) {
            String result = calculator.process(item.getInput());
            assertEquals(item.getResult(), result);
        }
    }

    @Test
    public void calculator_addingTwoDifferentNumbersAndEqualsSymbolAndNewAdding_resultIsReturned() {
        List<Item> values = ImmutableList.of(
                new Item('6', "6"),
                new Item('+', "6"),
                new Item('3', "3"),
                new Item('+', "9"),
                new Item('=', "9"),
                new Item('4', "4"),
                new Item('+', "4"),
                new Item('7', "7"),
                new Item('+', "11")
        );

        for (Item item : values) {
            String result = calculator.process(item.getInput());
            assertEquals(item.getResult(), result);
        }
    }

    @Test
    public void calculator_insertingNumberOverflows_errorIsReturned() {
        List<Item> values = ImmutableList.of(
                new Item('1', "1"),
                new Item('2', "12"),
                new Item('3', "123"),
                new Item('4', "1234"),
                new Item('5', "12345"),
                new Item('6', "123456"),
                new Item('7', "1234567"),
                new Item('8', "12345678"),
                new Item('9', "123456789"),
                new Item('0', "1234567890"),
                new Item('1', "ERROR!")
        );

        for (Item item : values) {
            String result = calculator.process(item.getInput());
            assertEquals(item.getResult(), result);
        }
    }

    @Test
    public void calculator_insertingNumberOverflowsAndValuesInMemoryAreReset_errorIsReturned() {
        List<Item> values = ImmutableList.of(
                new Item('1', "1"),
                new Item('2', "12"),
                new Item('3', "123"),
                new Item('4', "1234"),
                new Item('5', "12345"),
                new Item('6', "123456"),
                new Item('7', "1234567"),
                new Item('8', "12345678"),
                new Item('9', "123456789"),
                new Item('0', "1234567890"),
                new Item('1', "ERROR!"),
                new Item('1', "1")
        );

        for (Item item : values) {
            String result = calculator.process(item.getInput());
            assertEquals(item.getResult(), result);
        }
    }

    public static class Item {
        private char input;
        private String result;

        Item(char input, String result) {
            this.input = input;
            this.result = result;
        }

        char getInput() {
            return input;
        }

        String getResult() {
            return result;
        }
    }
}
