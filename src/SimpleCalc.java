/*
* Główny moduł programu
* */

/* TO DO
- dodać obcinanie wyniku - jeśli wychodzi liczba całkowita, nie powinno wyświetlać przecinka i zera
*/

import calcEngine.*; // import paczki z klasami dla obsługi wszystkich elementów kalkulatora

class Main {
    public static void main(String[] args) {

        InfoPrinter info = new InfoPrinter(); // inicjalizacja obiektu wyświetlającego informacje
        MainMenu MenuObject = new MainMenu(); // inicjalizacja obiektu menu

        info.printCaption("main title"); // czysto estetyczne
        MenuObject.initializeMainMenu();
    }
}