/*
* Klasa służąca do ustawiania i pobierana inputu
* */

package calcEngine;

public class InputValueContainer {
    private InputValidator checkedInput = new InputValidator();
    private double x;
    private double y;

    /*
     * Input handling section
     * */

    public void collectInput() {
        System.out.println("\n Enter first number: \n");
        this.setX();
        System.out.println("\n Enter second number: \n");
        this.setY();
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
