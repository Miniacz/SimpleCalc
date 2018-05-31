/*
* Klasa obsługująca poszczególne kalkulacje / obliczenia
* */

package calcEngine;

import static java.lang.Float.POSITIVE_INFINITY; // zaimportowana stała nieskończona dla floata

// import klas log4j
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public class Calculation {

    // załączenie loggera do aplikacji
    private static final Logger logger = LogManager.getLogger(Calculation.class);

    // zmienne dla przechowywania instancji klas, odpowiedzialnych za przechowanie inputu i "drukowanie" wyników
    private InputValueContainer value = new InputValueContainer();
    private InfoPrinter info = new InfoPrinter();

    /*
    * Calculation methods
    * */

    // zbiorcza metoda dla operacji

    public void calculationMethod(String methodType) {

        logger.entry();
        logger.trace("Caption printed");
        // wyświetlenie odpowiednich nagłówków
        switch (methodType) {
            case "add":
                info.printCaption("add");
                break;
            case "subtract":
                info.printCaption("subtract");
                break;
            case "multiply":
                info.printCaption("multiply");
                break;
            case "divide":
                info.printCaption("divide");
                break;
        }

        value.collectInput(); // zebranie danych od użytkownika w klasie InputValueContainer

        logger.trace("Collecting input from user");
        switch (methodType) {
            case "add":
                Memory.memoryQuerySaveResult(value.getX() + value.getY());
                System.out.println("\n Addition result: " + Memory.getMemoryArrayValueAtIndex(0));
                break;
            case "subtract":
                Memory.memoryQuerySaveResult(value.getX() - value.getY());
                System.out.println("\n Subtraction result: " + Memory.getMemoryArrayValueAtIndex(0));
                break;
            case "multiply":
                Memory.memoryQuerySaveResult(value.getX() * value.getY());
                System.out.println("\n Multiplication result: " + Memory.getMemoryArrayValueAtIndex(0));
                break;
            case "divide":
                Memory.memoryQuerySaveResult(value.getX() / value.getY());

                double divideByZeroCheck = Memory.getLastCalculationValue();
                if (divideByZeroCheck == POSITIVE_INFINITY) {
                    System.out.println("\n Division did result in positive infinity, possibly because of dividing by zero." + "\n");
                } else {
                    System.out.println("\n Division result: " + Memory.getLastCalculationValue() + "\n");
                }

                break;
        }
    }
}
