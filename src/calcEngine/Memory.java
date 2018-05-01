/*
 * Memory handling class
 * */

package calcEngine;

// klasa zdefiniowana jako abstrakcyjna, żeby nie tworzyć kolejnych instancji klasy, tylko stworzyć ją na wzór modułu pamięci (pojedynczego), dostępnego dla każdego elementu układu.
public abstract class Memory {

    private static InputValidator checkedInput = new InputValidator();

    // zmienna, która ma przechować zakres danych do późniejszego użycia
    public static double[] memoryArray = {
            0,
            0,
            0,
            0,
            0
    };

    // zmienna
    private static double memoryContainer = 0;

    /*
    * Getters and setters
    * */

    // g/s dla zakresu wartości w pamięci
    public static double[] getMemoryArray(int index) {
        return memoryArray;
    }

    public static void setMemoryArray(double[] memoryArray) {
        Memory.memoryArray = memoryArray;
    }


    // g/s dla pojednyczej wartości w pamięci
    public static double getMemoryValue() {
        return memoryContainer;
    }

    public static void setMemoryValue(double memoryChange) {
        memoryContainer = memoryChange;
    }

    /*
    * Memory access methods
    * */

    // Pobiera jako argument wartość, która ma być wprowadzona do pamięci podręcznej kalkulatora, dla pojedyczej wartości (memoryContainer)
    public static void memoryQuery(double memoryInput) {
        // true - query works / is On, false - query stops working / is Off
        boolean queryOnOff = true;

        System.out.println(
                "\n Do You want to save the result?" +
                "\n Please use numbers 1 or 2." +
                "\n 1: Yes." +
                "\n 2: No." + "\n");

        while (queryOnOff) {
            double x = checkedInput.validateInput();
            if (x == 1) {
                memoryContainer = memoryInput;
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


}
