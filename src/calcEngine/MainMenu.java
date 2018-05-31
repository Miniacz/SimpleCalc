/*
* Klasa obsługująca główną pętlę menu
* */

package calcEngine;

import java.util.InputMismatchException;
import java.util.Scanner;

// import klas log4j
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public class MainMenu {
    // załączenie loggera do aplikacji
    private static final Logger logger = LogManager.getLogger(MainMenu.class);

    public void initializeMainMenu() {

        boolean switchOnOff = true; // zmienna włączająca / wyłączająca menu

        Calculation option = new Calculation(); // inicjalizacja obiektu menu
        InfoPrinter info = new InfoPrinter(); // inicjalizacja obiektu wyświetlania informacji

        info.displayMainMenu(); // wyświetlenie menu

        while (switchOnOff){
            int menuControl; // zmienna sterująca menu - sterowana przez użytkownika

            // obsługa wyjątku, gdzie użytkownik podaje niewłaściwe dane sterujące, inne niż 0-5
            try {
                Scanner read = new Scanner(System.in);
                menuControl = read.nextInt();
            } catch (InputMismatchException e) {
                logger.error("User used wrong value to navigate the main menu.");
                System.out.println("You have used invalid character(s). To control menu, You have to use 0,1,2,3,4 or 5.");
                menuControl = -1; // czyszczenie wartości dla zmiennej sterującej menu; inaczej pętla wykorzysta ostatnią wybraną wartość.
            }

            // główny element sterowania menu
            if (menuControl == 1) {
                option.calculationMethod("add"); // wybór wariantu metody - tu: dodawanie (bo metoda przyjmuje parametr 1)
                info.displayMainMenu(); // wyświetlenie menu
            } else if (menuControl == 2) {
                option.calculationMethod("subtract"); // wybór wariantu metody - tu: odejmowanie (bo metoda przyjmuje parametr 2)
                info.displayMainMenu(); // wyświetlenie menu
            } else if (menuControl == 3) {
                option.calculationMethod("multiply"); // wybór wariantu metody - tu: mnożenie (bo metoda przyjmuje parametr 3)
                info.displayMainMenu(); // wyświetlenie menu
            } else if (menuControl == 4) {
                option.calculationMethod("divide"); // wybór wariantu metody - tu: dzielenie (bo metoda przyjmuje parametr 3)
                info.displayMainMenu(); // wyświetlenie menu
            } else if (menuControl == 5) {
                Memory.memoryArrayDisplay();
                info.displayMainMenu(); // wyświetlenie menu
            }  else if (menuControl > 5) {
                logger.error("User used wrong value to navigate the menu.");
                System.out.println("\n ERROR - Wrong value picked. " + "\n Please enter value between 0 up to 5" + "\n");
            }

            if (menuControl == 0) {
                logger.trace("User quits.");
                System.out.println("\n" + "Bye!" + "\n");
                switchOnOff = false; // wyłączenie menu
            }
        }
    }
}
