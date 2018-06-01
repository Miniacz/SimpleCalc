/*
* Klasa obsługująca sprawdzanie danych wprowadzonych przez użytkownika
* */

package calcEngine;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// import klas log4j
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public class InputValidator {

    // załączenie loggera do klasy
    private static final Logger logger = LogManager.getLogger(InputValidator.class);

    public double validateInput() {
        BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
        double readed = 0; // zmienna przechowująca dane od użytkownika; double jest dlatego, że klasa jest wykorzystana do wczytania także liczb niecałkowitych od użytkownika
        boolean inputQueryOnOff = true; // przełącznik zapytania dla wczytywania danych. Dopóki wartość jest true, program będzie próbował pobrać dane od uzytkownika
        int tryCounter = 0; // licznik prób uzyskania poprawnych danych wejściowych od użytkownika

        while (inputQueryOnOff) {
            //obsługa wyjątków
            try {
                logger.trace("Waiting for user input.");
                readed = Double.parseDouble(userInput.readLine()); // włąściwe wczytanie danych od użytkownika
                inputQueryOnOff = false; // zamknięcie pętli po zebraniu poprawnych danych od użytkownika
                logger.trace("Input collected properly.");
            } catch (NumberFormatException n) {
                logger.error("User used invalid data type. Repeating query.");
                System.out.println("Invalid data type. Please use numbers.");
                ++tryCounter; // zwiększenie licznkia prób o jeden
                if (tryCounter == 3) {
                    inputQueryOnOff = false; // zamknięcie pętli po dojechaniu do trzech nieudanych prób otrzymania danych od użytkownika
                    System.out.println("\n After 3 unsuccessful trials of getting valid user input, program stopped asking and used 0 as input value. \n");
                    logger.warn("User used invalid data type more than 3 times, program stopped asking.");
                }
            } catch (IOException e) {
                logger.error("User did something that broke Input/Output data handling.");
                System.out.println("Error occured: problem with Input/Output data handling.");
            }

        }

        return readed;
    }
}
