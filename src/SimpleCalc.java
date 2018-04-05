// - dodanie więcej opcji menu
// - dodać wyjątki - obsługa InputMismatchException
// - opracować metody dla obługi poszczególnych opcji
// - formatowanie całości (wodotryski i czyszczenie ekranu)

import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        System.out.println("Please pick menu option:" + "\n 1 - picks option (does nothing else)" + "\n 0 - quits" + "\n");

        int menuControl = 1;

        // klasa obsługująca poszczególne opcje
        class MenuItem {

            private void displayMenuItem(){
                System.out.println("\n Menu option picked.\n");
            }
        }

        // klasa, która obługuje poszczególne metody matematyczne dla opcji kalkulatora
         class calcCompute {

            // metoda dla dodawania
           int addXY(int x, int y){
               int addXYsum;
               addXYsum = x + y;
               return addXYsum;
           }
         }

        MenuItem option1 = new MenuItem();

        // główna pętla menu - ma powtarzać menu, dopóki użytkownik nie będzie chciał skończyć programu
        while (menuControl > 0){
            Scanner read = new Scanner(System.in);
            menuControl = read.nextInt();

            if (menuControl == 1){
                option1.displayMenuItem();
            } else if (menuControl > 1) {
                System.out.println("\n ERROR - Wrong value picked." + "\nPlease enter value 1 or 0" + "\n");
            }

            if (menuControl == 0){
                System.out.println("\n" + "Bye!" + "\n");
            }

        }

    }
}