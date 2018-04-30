/*
* Klasa służąca do ustawiania i pobierana inputu
* */

package calcEngine;

public class InputValueContainer {
    private InputValidator checkedInput = new InputValidator();
    private double x;
    private double y;
    private double memory = 0;


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

    /*
    * Memory handling section
    * */

    // Pobiera jako argument wartość, która ma być wprowadzona do pamięci podręcznej kalkulatora
    public void memoryQuery(double memoryInput) {
        boolean queryOnOff = true;

        System.out.println(
                "\n Do You want to save the result?" +
                        "\n Please use numbers 1 or 2." +
                        "\n 1: Yes." +
                        "\n 2: No." + "\n");

        while (queryOnOff) {
            this.x = checkedInput.validateInput();
            if (x == 1) {
                this.memory = memoryInput;
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

    public double getMemory() {
        return memory;
    }

    private void setMemory(double memory) {
        this.memory = memory;
    }
}
