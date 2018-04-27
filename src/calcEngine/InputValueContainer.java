/*
* klasa służąca do ustawiania i pobierana inputu
* */

package calcEngine;

public class InputValueContainer {
    private InputValidator checkedInputX = new InputValidator();
    private InputValidator checkedInputY = new InputValidator();
    private float x;
    private float y;

    public float getX() {
        return x;
    }

    public void setX() {
        System.out.println("\n Enter first number: \n");
        this.x = checkedInputX.validateInput();
    }

    public float getY() {
        return y;
    }

    public void setY() {
        System.out.println("\n Enter second number: \n");
        this.y = checkedInputY.validateInput();
    }
}
