/*
* Klasa obsługująca poszczególne kalkulacje / obliczenia
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
    * Variables designed to contain calculation results
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
    
    //  metoda dla dodawania
    public void addXY() {
        System.out.println(
                "\n ============ ADD ============" +
                "\n adds two numbers given by user " +
                "\n ============================="
        );

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


    /*
    * Sekcja kodu zostawiona jako przykład starszej implementacji
    * Wcześniej pamięć była częścią klasy Calculation, ale z racji niepasującego typu operacji -
    * - zapis w pamięci nie jest kalkulacją - uznałem, że lepiej jest stworzyć nową klasę.
    * */

    /*
    * Memory handling
    * */

    private void memoryQuery(double memoryInput) {
        boolean queryOnOff = true;

        System.out.println(
                "\n Do You want to save the result?" +
                "\n Please use numbers 1 or 2." +
                "\n 1: Yes." +
                "\n 2: No." + "\n");

        while (queryOnOff) {
            double x = checkedInput.validateInput();
            if (x == 1) {
                memory = memoryInput;
                // System.out.println("\n Memory value changed to: " + this.getMemory());
                queryOnOff = false;
            } else if (x == 2) {
                // System.out.println("\n Memory value remained unchanged. Current value is: " + this.getMemory());
                queryOnOff = false;
            } else {
                System.out.println("\n You have entered an invalid number. Please use 1 or 2. \n");
            }
        }

    }
    
    /*
    * Memory getters and setters
    * */

    public double getMemory() {
        return memory;
    }

    private void setMemory(double memory) {
        this.memory = memory;
    }
}
