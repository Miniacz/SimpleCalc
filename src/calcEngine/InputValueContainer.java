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
        getUserInputForX();
        getUserInputForY();
    }

    public void getUserInputForX(){
        boolean queryOnOff = true; // przełącznik zapytania: true - zapytanie działa, false - zapytanie zostaje zatrzymane,

        System.out.println(
                "\n Do You want to use last result for the first number?" +
                "\n 1: yes" +
                "\n 2: no"
        );

        while (queryOnOff) {
            double userChoice = checkedInput.validateInput(); // zmienna przechowująca dane użytkownika

            if (userChoice == 1) {
                this.x = Memory.getMemoryArrayValueAtIndex(0);
                System.out.println("\n Used result of last computation as input for the first number. Used value: " + Memory.getMemoryArrayValueAtIndex(0));
                queryOnOff = false; // zamknięcie zapytania, po użyciu ostatniego wyniku
            } else if (userChoice == 2) {
                System.out.println("\n Enter first number: \n");
                this.setX();
                queryOnOff = false; // zamknięcie zapytania, po wprowadzeniu poprawnych danych do pamięci
            } else {
                System.out.println("\n You have given invalid input. Please use 1 or 2"); // powtórzenie zapytania, gdy użytkownik poda nieprawidłowe dane
            }
        }

    }

    public void getUserInputForY(){
        boolean queryOnOff = true; // przełącznik zapytania: true - zapytanie działa, false - zapytanie zostaje zatrzymane,

        System.out.println(
                "\n Do You want to use last result for the second number?" +
                "\n 1: yes" +
                "\n 2: no"
        );

        while (queryOnOff) {
            double userChoice = checkedInput.validateInput(); // zmienna przechowująca dane użytkownika

            if (userChoice == 1) {
                this.y = Memory.getMemoryArrayValueAtIndex(0);
                System.out.println("\n Used result of last computation as input for the second number. Used value: " + Memory.getMemoryArrayValueAtIndex(0));
                queryOnOff = false; // zamknięcie zapytania, po użyciu ostatniego wyniku
            } else if (userChoice == 2) {
                System.out.println("\n Enter second number: \n");
                this.setY();
                queryOnOff = false; // zamknięcie zapytania, po wprowadzeniu poprawnych danych do pamięci
            } else {
                System.out.println("\n You have given invalid input. Please use 1 or 2"); // powtórzenie zapytania, gdy użytkownik poda nieprawidłowe dane
            }
        }
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
