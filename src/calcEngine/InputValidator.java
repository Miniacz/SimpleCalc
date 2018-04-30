/*
* Klasa obsługująca sprawdzanie danych wprowadzonych przez użytkownika
* */

package calcEngine;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputValidator {
    public double validateInput() {
        BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
        double readed = 0;
        boolean inputQueryOnOff = true;
        int tryCounter = 0;

        while (inputQueryOnOff) {

            //obsługa wyjątków
            try {
                readed = Double.parseDouble(userInput.readLine());
                // zamknięcie pętli po poprawnym wyniku
                inputQueryOnOff = false;
            } catch (NumberFormatException n) {
                System.out.println("Invalid data type. Please use numbers.");
                ++tryCounter;
                if (tryCounter == 3) {
                    inputQueryOnOff = false;
                    System.out.println("\n After 3 unsuccessful trials of getting valid user input, program stopped asking and used 0 as input value. \n");
                }
            } catch (IOException e) {
                System.out.println("Error occured: problem with Input/Output data handling. \n Probably You've done something which was not predicted by developer, \n therefore some unwanted byproducts may have also occured - such as local Tornado or Trump reelection.");
            }

        }

        return readed;
    }
}
