// - dodać obcinanie wyniku - jeśli wychodzi liczba całkowita, nie powinno wyświetlać przecinka i zera
// - sout skrócić - zamiast System.out.println("coś") do np.: print(coś)

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.InputMismatchException;

import static java.lang.Float.POSITIVE_INFINITY;

// klasa obsługująca sprawdzanie danych wprowadzonych przez użytkownika
class InputValidator {

    public float validateInput() {
        BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
        float readed = 0;
        boolean czyPoprawne = true;
        int tryCounter = 0;

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

// klasa służąca do ustawiania i pobieranai inputu
class InputValueContainer {
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

// klasa obsługująca poszczególne opcje menu
class MenuItem {
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

// klasa obsługująca główną pętlę menu
class MainMenu {

    private void displayMainMenu(){
        // main menu + plus info
        System.out.println(
                "\n \n" +
                        "Please pick menu option:" +
                        "\n 1 - adds two numbers" +
                        "\n 2 - subtracts two numbers" +
                        "\n 3 - multiplies two numbers" +
                        "\n 4 - divides two numbers" +
                        "\n 0 - quit" +
                        "\n \n");
    }

    public void initializeMainMenu() {
        // zmienna sterująca menu - sterowana przez użytkownika
        int menuControl;
        // zmienna wyłączająca menu
        boolean switchOnOff = true;

        // inicjalizacja obiektu menu
        MenuItem option = new MenuItem();
        this.displayMainMenu();

        while (switchOnOff){

            // obsługa wyjątku, gdzie użytkownik podaje niewłaściwe dane sterujące, inne niż 0-5
            try {
                Scanner read = new Scanner(System.in);
                menuControl = read.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("You have used invalid character(s). To control menu, You have to use 0,1,2,3,4 or 5.");
                // czyszczenie wartości dla zmiennej sterującej menu; inaczej pętla wykorzysta ostatnią wybraną wartość.
                menuControl = -1;
            }

            // główny element sterowania menu
            if (menuControl == 1){
                System.out.println("\n Addition result: " + option.addXY() + "\n");
                this.displayMainMenu();
            } else if (menuControl == 2) {
                System.out.println("\n Subtraction result: " + option.subtractXY() + "\n");
                this.displayMainMenu();
            } else if (menuControl == 3) {
                System.out.println("\n Multiplication result: " + option.multiplyXY() + "\n");
                this.displayMainMenu();
            } else if (menuControl == 4) {

                /*
                obsługa dzielenia przez zero
                zmienna divideByZeroCheck ma przechować wynik dzielenia, żeby sprawdzić, czy wychodzi nieskończoność.
                Jeśli tak, ma być podany alternatywny komunikat.
                */
                float divideByZeroCheck = option.divideXY();
                if (divideByZeroCheck == POSITIVE_INFINITY) {
                    System.out.println("\n Division did result in positive infinity, possibly because of dividing by zero." + "\n");
                } else {
                    System.out.println("\n Division result: " + divideByZeroCheck + "\n");
                }

                this.displayMainMenu();

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

// główny moduł programu
class Main {
    public static void main(String[] args) {

        // czysto estetyczne
        System.out.println(
                "\n ==================================================="
                + "\n TURBO CALC 6000" + " by Miniacz"
                + "\n ==================================================="
        );

        // inicjalizacja menu przez wywołanie odpowiedniej klasy
        MainMenu MenuObject = new MainMenu();
        MenuObject.initializeMainMenu();
    }
}