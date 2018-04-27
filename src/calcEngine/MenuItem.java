/*
* klasa obsługująca poszczególne opcje menu
* */

/* TO DO
- przerobić na klasę obliczeniową
*/

package calcEngine;

public class MenuItem {

    private InputValueContainer value1 = new InputValueContainer();
    private InputValueContainer value2 = new InputValueContainer();

    // == metoda dla dodawania ==
    public float addXY(){
        float addXYout;

        System.out.println(
                "\n ============ ADD ============" +
                        "\n adds two numbers given by user " +
                        "\n ============================="
        );

        value1.setX();
        value2.setY();
        addXYout = value1.getX() + value2.getY();
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

        value1.setX();
        value2.setY();
        subtractXYout = value1.getX() - value2.getY();
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

        value1.setX();
        value2.setY();
        multiplyXYout = value1.getX() * value2.getY();
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

        value1.setX();
        value2.setY();
        divideXYout = value1.getX() / value2.getY();
        return divideXYout;

    }
}
