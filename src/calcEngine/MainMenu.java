/*
* Klasa obsługująca główną pętlę menu
* */

package calcEngine;

import java.util.InputMismatchException;
import java.util.Scanner;

import static java.lang.Float.POSITIVE_INFINITY; // zaimportowana stała nieskończona dla floata

public class MainMenu {

    private void displayMainMenu(){
        // main menu + plus info
        System.out.println(
                "\n \n" +
                "Please pick menu option:" +
                "\n 1 - adds two numbers" +
                "\n 2 - subtracts two numbers" +
                "\n 3 - multiplies two numbers" +
                "\n 4 - divides two numbers" +
                "\n 0 - quit" +
                "\n \n");
    }

    public void initializeMainMenu() {
        // zmienna sterująca menu - sterowana przez użytkownika
        int menuControl;
        // zmienna wyłączająca menu
        boolean switchOnOff = true;

        // inicjalizacja obiektu menu
        Calculation option = new Calculation();
        this.displayMainMenu();

        while (switchOnOff){

            // obsługa wyjątku, gdzie użytkownik podaje niewłaściwe dane sterujące, inne niż 0-5
            try {
                Scanner read = new Scanner(System.in);
                menuControl = read.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("You have used invalid character(s). To control menu, You have to use 0,1,2,3,4 or 5.");
                // czyszczenie wartości dla zmiennej sterującej menu; inaczej pętla wykorzysta ostatnią wybraną wartość.
                menuControl = -1;
            }

            // główny element sterowania menu
            if (menuControl == 1) {
                System.out.println("\n Addition result: " + option.addXY() + "\n");
                this.displayMainMenu();
            } else if (menuControl == 2) {
                System.out.println("\n Subtraction result: " + option.subtractXY() + "\n");
                this.displayMainMenu();
            } else if (menuControl == 3) {
                System.out.println("\n Multiplication result: " + option.multiplyXY() + "\n");
                this.displayMainMenu();
            } else if (menuControl == 4) {

                /*
                obsługa dzielenia przez zero
                zmienna divideByZeroCheck ma przechować wynik dzielenia, żeby sprawdzić, czy wychodzi nieskończoność.
                Jeśli tak, ma być podany alternatywny komunikat.
                */
                float divideByZeroCheck = option.divideXY();
                if (divideByZeroCheck == POSITIVE_INFINITY) {
                    System.out.println("\n Division did result in positive infinity, possibly because of dividing by zero." + "\n");
                } else {
                    System.out.println("\n Division result: " + divideByZeroCheck + "\n");
                }

                this.displayMainMenu();

            } else if (menuControl > 4) {
                System.out.println("\n ERROR - Wrong value picked. " + "\n Please enter value between 0 up to 5" + "\n");
            }

            if (menuControl == 0) {
                System.out.println("\n" + "Bye!" + "\n");
                switchOnOff = false;
            }
        }
    }
}
