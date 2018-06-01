/*
* Klasa służąca do ustawiania i pobierana inputu
* */

package calcEngine;

// import klas log4j
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public class InputValueContainer {

    // załączenie loggera do klasy
    private static final Logger logger = LogManager.getLogger(InputValueContainer.class);
    private static InfoPrinter info = new InfoPrinter();

    private InputValidator checkedInput = new InputValidator();
    private double x;
    private double y;

    /*
     * Input handling section
     * */

    public void collectInput() {
        getUserInputForX();
        getUserInputForY();
    }

    public void getUserInputForX(){
        boolean queryOnOff = true; // przełącznik zapytania: true - zapytanie działa, false - zapytanie zostaje zatrzymane,

        logger.trace("Entering getting method for X.");

        logger.trace("Asking, if user wants to use last computation value for X.");
        info.printCaption("input_get_X");

        while (queryOnOff) {
            double userChoice = checkedInput.validateInput(); // zmienna przechowująca dane użytkownika

            if (userChoice == 1) {
                this.x = Memory.getMemoryArrayValueAtIndex(0);
                System.out.println("\n Used result of last computation as input for the first number. Used value: " + Memory.getMemoryArrayValueAtIndex(0));
                queryOnOff = false; // zamknięcie zapytania, po użyciu ostatniego wyniku
            } else if (userChoice == 2) {
                logger.trace("Asking user to input first number.");
                System.out.println("\n Enter first number: \n");
                this.setX();
                logger.info("Setting X to: " + this.x);
                queryOnOff = false; // zamknięcie zapytania, po wprowadzeniu poprawnych danych do pamięci
            } else {
                logger.error("Invalid input for X. User picked number out of range.");
                System.out.println("\n You have given invalid input. Please use 1 or 2"); // powtórzenie zapytania, gdy użytkownik poda nieprawidłowe dane
            }
        }

    }

    public void getUserInputForY(){
        boolean queryOnOff = true; // przełącznik zapytania: true - zapytanie działa, false - zapytanie zostaje zatrzymane,

        logger.trace("Entering getting method for Y.");

        logger.trace("Asking, if user wants to use last computation value for Y.");
        info.printCaption("input_get_Y");

        while (queryOnOff) {
            double userChoice = checkedInput.validateInput(); // zmienna przechowująca dane użytkownika

            if (userChoice == 1) {
                this.y = Memory.getMemoryArrayValueAtIndex(0);
                System.out.println("\n Used result of last computation as input for the second number. Used value: " + Memory.getMemoryArrayValueAtIndex(0));
                queryOnOff = false; // zamknięcie zapytania, po użyciu ostatniego wyniku
            } else if (userChoice == 2) {
                logger.trace("Asking user to input second number.");
                System.out.println("\n Enter second number: \n");
                this.setY();
                logger.info("Setting Y to: " + this.y);
                queryOnOff = false; // zamknięcie zapytania, po wprowadzeniu poprawnych danych do pamięci
            } else {
                logger.error("Invalid input for Y. User picked number out of range.");
                System.out.println("\n You have given invalid input. Please use 1 or 2"); // powtórzenie zapytania, gdy użytkownik poda nieprawidłowe dane
            }
        }
    }

    public double getX() {
        return x;
    }

    private void setX() {
        this.x = checkedInput.validateInput();
    }

    public double getY() {
        return y;
    }

    private void setY() {
        this.y = checkedInput.validateInput();
    }

}
