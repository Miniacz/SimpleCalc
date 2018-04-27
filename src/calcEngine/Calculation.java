/*
* Klasa obsługująca poszczególne kalkulacje / obliczenia
* */

package calcEngine;

public class Calculation {
    private InputValueContainer value = new InputValueContainer();

    // == metoda dla dodawania ==
    public float addXY(){
        float addXYout;

        System.out.println(
                "\n ============ ADD ============" +
                "\n adds two numbers given by user " +
                "\n ============================="
        );

        value.collectInput();
        addXYout = value.getX() + value.getY();
        return addXYout;
    }

    // == metoda dla odejmowania ==
    public float subtractXY(){
        float subtractXYout;

        System.out.println(
                "\n ============ SUBTRACT ============" +
                "\n subtracts two numbers given by user " +
                "\n =================================="
        );

        value.collectInput();
        subtractXYout = value.getX() - value.getY();
        return subtractXYout;
    }

    // == metoda dla mnożenia ==
    public float multiplyXY(){
        float multiplyXYout;

        System.out.println(
                "\n ============ MULTIPLY ============" +
                "\n multiplies two numbers given by user " +
                "\n =================================="
        );

        value.collectInput();
        multiplyXYout = value.getX() * value.getY();
        return multiplyXYout;
    }

    // == metoda dla dzielenia ==
    public float divideXY(){
        float divideXYout;

        System.out.println(
                "\n ============ DIVIDE ============" +
                "\n divides two numbers given by user " +
                "\n ================================"
        );

        value.collectInput();
        divideXYout = value.getX() / value.getY();
        return divideXYout;

    }
}
