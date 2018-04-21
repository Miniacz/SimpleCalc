// - dodać obcinanie wyniku - jeśli wychodzi liczba całkowita, nie powinno wyświetlać przecinka i zera
// - formatowanie całości (wodotryski i czyszczenie ekranu)
// - metody dodawania i odejmowania - przyjrzeć się im
// - gettery i settery dla klas
// - sout skrócić - zamiast System.out.println("coś") do np.: print(coś)

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.InputMismatchException;

// klasa obsługująca sprawdzanie danych wprowadzonych przez użytkownika
class InputValidator {
    private BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
    private float readed = 0;
    private boolean czyPoprawne = true;
    private int tryCounter = 0;

    public float validateInput() {

        while (czyPoprawne) {

            //obsługa wyjątków
            try {
                readed = Float.parseFloat(userInput.readLine());
                // zamknięcie pętli po poprawnym wyniku
                czyPoprawne = false;
            } catch (NumberFormatException n) {
                System.out.println("Invalid data type. Please use numbers.");
                ++tryCounter;
                if (tryCounter == 3) {
                    czyPoprawne = false;
                    System.out.println("\n After 3 unsuccessful trials of getting user input, program stopped asking. \n");
                }
            } catch (IOException e) {
                System.out.println("Error");
            }

        }

        return readed;
    }
}

// klasa obsługująca poszczególne opcje menu
class MenuItem {
    private InputValidator checkedInput = new InputValidator();
    private Scanner read = new Scanner(System.in);

    public void displayMainMenu(){
        // main menu + plus info
        System.out.println("\n \n" + "Please pick menu option:" +
                "\n 1 - adds two numbers" +
                "\n 2 - subtracts two numbers" +
                "\n 3 - multiplies two numbers" +
                "\n 4 - divides two numbers" +
                "\n 0 - quit" + "\n \n");
    }

    // ===== metoda testowa =====
    //private void displayMenuItem(){
    //    System.out.println("\n Menu option picked.\n");
    //}

    // ===== metody właściwe =====

    // == metoda dla dodawania ==
    public float addXY(){
        System.out.println(
                "\n ============ ADD ============"
                        + "\n adds two numbers given by user "
                        + "\n ============================="
        );
        float addXYout;
        System.out.println("\n Enter first number: \n");
        float x = checkedInput.validateInput();
        System.out.println("\n Enter second number: \n");
        float y = checkedInput.validateInput();
        //System.out.println("\n Result: \n");
        addXYout = x + y;
        return addXYout;
    }

    // == metoda dla odejmowania ==
    public float subtractXY(){
        System.out.println(
                "\n ============ SUBTRACT ============"
                        + "\n subtracts two numbers given by user "
                        + "\n =================================="
        );
        float subtractXYout;
        System.out.println("\n Enter first number: \n");
        float x = checkedInput.validateInput();
        System.out.println("\n Enter second number: \n");
        float y = checkedInput.validateInput();
        //System.out.println("\n Result: \n");
        subtractXYout = x - y;
        return subtractXYout;
    }

    // == metoda dla mnożenia ==
    public float multiplyXY(){
        System.out.println(
                "\n ============ MULTIPLY ============"
                        + "\n multiplies two numbers given by user "
                        + "\n =================================="
        );
        float multiplyXYout;
        System.out.println("\n Enter first number: \n");
        float x = checkedInput.validateInput();
        System.out.println("\n Enter second number: \n");
        float y = checkedInput.validateInput();
        //System.out.println("\n Result: \n");
        multiplyXYout = x * y;
        return multiplyXYout;
    }

    // == metoda dla dzielenia ==
    public float divideXY(){
        System.out.println(
                "\n ============ DIVIDE ============"
                        + "\n divides two numbers given by user "
                        + "\n ================================"
        );
        float divideXYout = 0;
        System.out.println("\n Enter first number: \n");
        float x = checkedInput.validateInput();
        System.out.println("\n Enter second number: \n");
        float y = checkedInput.validateInput();
        divideXYout = x / y;
        return divideXYout;

    }
}

// klasa główna
class Main {
    public static void main(String[] args) {

        // inicjalizacja obiektu menu
        MenuItem option = new MenuItem();

        // czysto estetyczne
        System.out.println(
                "\n ==================================================="
                + "\n TURBO CALC 6000" + " by Miniacz"
                + "\n ==================================================="
        );

        // pierwsze wywołanie menu
        option.displayMainMenu();

        // zmienna sterująca menu - sterowana przez użytkownika
        int menuControl = -1;
        boolean switchOnOff = true;

        // główna pętla menu - ma powtarzać menu, dopóki użytkownik nie będzie chciał skończyć programu
        while (switchOnOff){

            // obsługa wyjątku, gdzie użytkownik podaje niewłaściwe dane sterujące, inne niż 0-5
            try {
                    Scanner read = new Scanner(System.in);
                    menuControl = read.nextInt();
                } catch (InputMismatchException e) {
                    System.out.println("You have used invalid character(s). To control menu, You have to use 0,1,2,3,4 or 5.");
                }

            if (menuControl == 1){
                    System.out.println("\n Addition result: " + option.addXY() + "\n");
                    option.displayMainMenu();
                } else if (menuControl == 2) {
                    System.out.println("\n Subtraction result: " + option.subtractXY() + "\n");
                    option.displayMainMenu();
                } else if (menuControl == 3) {
                    System.out.println("\n Multiplication result: " + option.multiplyXY() + "\n");
                    option.displayMainMenu();
                } else if (menuControl == 4) {
                // wyłapanie dzielenia przez 0
                    try {
                        System.out.println("\n Division result: " + option.divideXY() + "\n");
                        option.displayMainMenu();
                    } catch (ArithmeticException e) {
                        System.out.println("Please keep in mind, that dividing by zero is not allowed in math. Result forced in zero.");
                    }
                } else if (menuControl > 4) {
                    System.out.println("\n ERROR - Wrong value picked. You're in main menu." + "\n Please enter value between 0 up to 5" + "\n");
                }

            if (menuControl == 0){
                System.out.println("\n" + "Bye!" + "\n");
                switchOnOff = false;
            }

        }

    }
}