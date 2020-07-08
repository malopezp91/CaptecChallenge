package com.captec.challenge;

import org.jline.terminal.Terminal;
import org.jline.terminal.TerminalBuilder;
import org.jline.utils.NonBlockingReader;

import java.io.IOException;

import static com.captec.challenge.calculator.Utils.APP_TITLE;
import static com.captec.challenge.calculator.Utils.DEFAULT_CHAR;
import static com.captec.challenge.calculator.Utils.ESCAPE_CHAR;


/**
 * App
 * Main App Entry point
 */
public class App {
    public static void main(String[] args) throws IOException {

        System.out.println(APP_TITLE);

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
            System.out.println(inputValue);
        }

        reader.close();
        terminal.close();
    }
}
