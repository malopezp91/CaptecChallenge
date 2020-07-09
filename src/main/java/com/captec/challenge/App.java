package com.captec.challenge;

import com.captec.challenge.calculator.Calculator;
import org.jline.terminal.Terminal;
import org.jline.terminal.TerminalBuilder;
import org.jline.utils.NonBlockingReader;

import java.io.IOException;
import java.util.Objects;

import static com.captec.challenge.calculator.Utils.APP_TITLE;
import static com.captec.challenge.calculator.Utils.CALCULATOR_INSTRUCTIONS;
import static com.captec.challenge.calculator.Utils.DEFAULT_CHAR;
import static com.captec.challenge.calculator.Utils.ESCAPE_CHAR;
import static com.captec.challenge.calculator.Utils.INITIAL_DISPLAY_LABEl;
import static com.captec.challenge.calculator.Utils.formatOutput;


/**
 * App
 * Main App Entry point
 */
public class App {
    public static void main(String[] args) throws IOException {

        Calculator calculator = new Calculator();
        System.out.println(APP_TITLE);
        System.out.println(CALCULATOR_INSTRUCTIONS);
        System.out.println(formatOutput(INITIAL_DISPLAY_LABEl, '-'));

        /*
        jline3 used for a more seamless user experience
        For reference: https://github.com/jline/jline3
         */
        Terminal terminal = TerminalBuilder.builder()
                .system(true)
                .build();
        terminal.enterRawMode();
        NonBlockingReader reader = terminal.reader();

        char inputValue = DEFAULT_CHAR;
        while (inputValue != ESCAPE_CHAR) {
            inputValue = (char) reader.read();
            String result = calculator.process(inputValue);
            // Only non null results are displayed to console
            if (Objects.nonNull(result)) {
                System.out.println(formatOutput(result, inputValue));
            }
        }

        reader.close();
        terminal.close();
    }
}
