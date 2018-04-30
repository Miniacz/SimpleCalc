/*
 * Memory handling class
 * */

package calcEngine;

public class Memory {
    private InputValidator checkedInput = new InputValidator();

    private static double memory = 0;

    // Pobiera jako argument wartość, która ma być wprowadzona do pamięci podręcznej kalkulatora
    public void memoryQuery(double memoryInput) {
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

    public static double getMemory() {
        return memory;
    }

    private void setMemory(double memory) {
        this.memory = memory;
    }
}
