import java.util.Scanner;

public class SimpleCalc {
    public static void main(String[] args) {
        System.out.println("Hello World!");

        // testowa klasa menu
        class MenuItem {

            private void displayElement(){
                System.out.println("element called properly");
            }
        }

        // testowa deklaracja i inicjalizacja instancji klas
        MenuItem FirstOne = new MenuItem();
        Scanner read = new Scanner(System.in);

        // inicjalizacja inputu
        int input_one = read.nextInt();

        if (input_one > 0){
            FirstOne.displayElement();
        }

    }
}
