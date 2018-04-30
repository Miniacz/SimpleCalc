/*
* Główny moduł programu
* */

/* TO DO
- dodać obcinanie wyniku - jeśli wychodzi liczba całkowita, nie powinno wyświetlać przecinka i zera
*/

import calcEngine.*; // import paczki z klasami dla obsługi wszystkich elementów kalkulatora

class Main {
    public static void main(String[] args) {

        InfoPrinter obj = new InfoPrinter();

        // czysto estetyczne
        obj.print(
                "\n ==================================================="
                + "\n TURBO CALC 6000" + " by Miniacz"
                + "\n ==================================================="
        );

        // inicjalizacja menu przez wywołanie odpowiedniej klasy
        MainMenu MenuObject = new MainMenu();
        MenuObject.initializeMainMenu();
    }
}