/*
* Klasa obsługująca poszczególne kalkulacje / obliczenia
* */

/*TO DO
* Złączyć metodę dodawania i odejmowania (można to zrobić)
* W programowaniu powinno się unikać powielenia kodu -
* nie powinno być sytuacji, gdy powtarza się kod,
* lub jest dosłownie kopia linii ze zmianą jednego znaku
* to oznacza, że można to złączyć w prostszą logikę
* */

package calcEngine;

import java.lang.reflect.Array;
import java.util.Arrays;

import static java.lang.Float.POSITIVE_INFINITY; // zaimportowana stała nieskończona dla floata

public class Calculation {

    private InputValueContainer value = new InputValueContainer();
    private InputValidator checkedInput = new InputValidator();

    // Zmienna, która ma działać jak pamięć podręczna kalkulatora - obecnie zbędna
    private double memory = 0;

    /*
    * Variables designed to contain calculation results - zmienne do usunięcia - patrz
    * */

    private double addResult = 0;
    private double subResult = 0;
    private double mltResult = 0;
    private double divResult = 0;

    /*
    * Getters and setters for calculation results
    * */

    private double getAddResult() {
        return addResult;
    }

    public void setAddResult(double addResult) {
        this.addResult = addResult;
    }


    private double getSubXYResult() {
        return subResult;
    }

    public void setSubXYResult(double subResult) {
        this.subResult = subResult;
    }


    private double getMltResult() {
        return mltResult;
    }

    public void setMltResult(double mltResult) {
        this.mltResult = mltResult;
    }


    private double getDivResult() {
        return divResult;
    }

    public void setDivResult(double divResult) {
        this.divResult = divResult;
    }

    /*
    * Calculation methods
    * */

    // zbiorcza metoda dla dodawania / odejmowania

    public void add_subXY(int type) {

        switch (type) {
            case 1:
                System.out.println(
                        "\n ============ ADD ============" +
                        "\n adds two numbers given by user " +
                        "\n ============================="
                );
                break;
            case 2:
                System.out.println(
                        "\n ============ SUBTRACT ============" +
                        "\n subtracts two numbers given by user " +
                        "\n =================================="
                );
        }

        value.collectInput();

        switch (type) {
            case 1:
                Memory.memoryQuery(value.getX() + value.getY());
                System.out.println("\n Addition result: " + Memory.getMemoryValue());
                break;
            case 2:
                Memory.memoryQuery(value.getX() - value.getY());
                System.out.println("\n Subtraction result: " + Memory.getMemoryValue());
        }

    }

    //  metoda dla dodawania
    public void addXY() {

        System.out.println(
                "\n ============ ADD ============" +
                "\n adds two numbers given by user " +
                "\n ============================="
        );

        // można usunąć addResult na rzecz Memory.memoryQuery(value.getX()+value.getY())
        value.collectInput();
        addResult = value.getX() + value.getY();
        System.out.println("\n Addition result: " + this.getAddResult());

        Memory.memoryQuery(addResult);

    }

    //  metoda dla odejmowania 
    public void subtractXY(){

        System.out.println(
                "\n ============ SUBTRACT ============" +
                "\n subtracts two numbers given by user " +
                "\n =================================="
        );

        value.collectInput();
        subResult = value.getX() - value.getY();
        System.out.println("\n Subtraction result: " + this.getSubXYResult());

        Memory.memoryQuery(subResult);
    }

    //  metoda dla mnożenia 
    public void multiplyXY(){

        System.out.println(
                "\n ============ MULTIPLY ============" +
                "\n multiplies two numbers given by user " +
                "\n =================================="
        );

        value.collectInput();
        mltResult = value.getX() * value.getY();
        System.out.println("\n Multiply result: " + this.getMltResult());

        Memory.memoryQuery(mltResult);

    }

    //  metoda dla dzielenia 
    public void divideXY(){

        System.out.println(
                "\n ============ DIVIDE ============" +
                "\n divides two numbers given by user " +
                "\n ================================"
        );

        value.collectInput();
        divResult = value.getX() / value.getY();
        double divideByZeroCheck = this.getDivResult();
        if (divideByZeroCheck == POSITIVE_INFINITY) {
                System.out.println("\n Division did result in positive infinity, possibly because of dividing by zero." + "\n");
            } else {
                System.out.println("\n Division result: " + divideByZeroCheck + "\n");
            }

        Memory.memoryQuery(divResult);
    }

}
