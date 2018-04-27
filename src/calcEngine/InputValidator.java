/*
* Klasa obsługująca sprawdzanie danych wprowadzonych przez użytkownika
* */

package calcEngine;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputValidator {
    public float validateInput() {
        BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
        float readed = 0;
        boolean czyPoprawne = true;
        int tryCounter = 0;

        while (czyPoprawne) {

            //obsługa wyjątków
            try {
                readed = Float.parseFloat(userInput.readLine());
                // zamknięcie pętli po poprawnym wyniku
                czyPoprawne = false;
            } catch (NumberFormatException n) {
                System.out.println("Invalid data type. Please use numbers.");
                ++tryCounter;
                if (tryCounter == 3) {
                    czyPoprawne = false;
                    System.out.println("\n After 3 unsuccessful trials of getting user input, program stopped asking. \n");
                }
            } catch (IOException e) {
                System.out.println("Error");
            }

        }

        return readed;
    }
}
