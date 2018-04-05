import java.util.Scanner;

public class SimpleCalc {
    public static void main(String[] args) {
        System.out.println("\n");

        // testowa klasa menu
        class MenuItem {

            private void displayElement(){
                // test display - if works, display text
                System.out.println("\n" + "element called properly");
            }
        }

        // testowa deklaracja i inicjalizacja instancji klas
        MenuItem FirstOne = new MenuItem();
        Scanner read = new Scanner(System.in);

        int mainMenuBreak = 0;

        while (mainMenuBreak == 1){
                // inicjalizacja inputu
                System.out.println("Please enter value:" + "\n");
                int inputOne = read.nextInt();

                if (inputOne > 0) {
                    FirstOne.displayElement();
                } else {
                    mainMenuBreak = 1;
                }
            }

    }
}
