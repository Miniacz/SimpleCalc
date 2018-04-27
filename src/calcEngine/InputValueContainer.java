/*
* Klasa służąca do ustawiania i pobierana inputu
* */

package calcEngine;

public class InputValueContainer {
    private InputValidator checkedInputX = new InputValidator();
    private float x;
    private float y;

    public void collectInput() {
        System.out.println("\n Enter first number: \n");
        this.setX();
        System.out.println("\n Enter second number: \n");
        this.setY();
    }

    public float getX() {
        return x;
    }

    private void setX() {
        this.x = checkedInputX.validateInput();
    }

    public float getY() {
        return y;
    }

    private void setY() {
        this.y = checkedInputX.validateInput();
    }
}
