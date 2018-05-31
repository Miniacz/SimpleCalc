/*
 * Główny moduł programu
 * */

/* TO DO
- dodać obcinanie wyniku - jeśli wychodzi liczba całkowita, nie powinno wyświetlać przecinka i zera
*/

import calcEngine.*; // import paczki z klasami dla obsługi wszystkich elementów kalkulatora
// import klas log4j
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

class Main {
    public static void main(String[] args) {

        // załączenie loggera do aplikacji
        Logger logger = LogManager.getLogger(Main.class); // inicjalizacja loggera
        InfoPrinter info = new InfoPrinter(); // inicjalizacja obiektu wyświetlającego informacje
        MainMenu MenuObject = new MainMenu(); // inicjalizacja obiektu menu

        logger.trace("Application starts.");
        info.printCaption("main title"); // czysto estetyczne
        MenuObject.initializeMainMenu();
    }
}