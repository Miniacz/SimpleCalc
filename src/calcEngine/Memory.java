/*
 * Memory handling class
 * */

package calcEngine;

// import klas log4j
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

// klasa z elementami statycznymi, żeby można było się do nich odnieść z różnych miejsc programu
public class Memory {

    // załączenie loggera do aplikacji
    private static final Logger logger = LogManager.getLogger(Memory.class);

    private static InputValidator checkedInput = new InputValidator();
    private static InfoPrinter info = new InfoPrinter();

    // tablica pamięci, która ma przechować zakres danych do późniejszego użycia
    private static double[] memoryArray = {
            0, // index: 0 miejsce zarezerwowane dla ostatniego wyniku działania
            0, // index: 1 miejsce dostępne dla użytkownika
            0, // index: 2 miejsce dostępne dla użytkownika
            0, // index: 3 miejsce dostępne dla użytkownika
            0  // index: 4 miejsce dostępne dla użytkownika
    };

    /*
    * Getters and setters
    * */

    // g/s dla zakresu wartości w pamięci
    public static double getLastCalculationValue() {
        return Memory.getMemoryArrayValueAtIndex(0);
    }

    public static double getMemoryArrayValueAtIndex(int arrayIndex) {
        return memoryArray[arrayIndex];
    }

    public static void setMemoryArrayAtIndex(double memoryInputValue, int arrayIndex) {
        Memory.memoryArray[arrayIndex] = memoryInputValue;
    }

    /*
    * Memory access methods
    * */

    // Pobiera jako argument wartość, która ma być wprowadzona do pamięci podręcznej kalkulatora, dla pojedyczej wartości (memoryContainer)
    public static void memoryQuerySaveResult (double memoryInput) {
        boolean queryOnOff = true; // przełącznik zapytania: true - zapytanie działa, false - zapytanie zostaje zatrzymane,

        logger.info("Memory array at index 0 set to 0.");
        Memory.setMemoryArrayAtIndex(memoryInput, 0); // ustawienie wyniku działania na zarezerowanym miejscu w tablicy pamięci kalkulatora, zanim uzytkownik będzie o cokolwiek zapytany

        info.printCaption("mlt_obj_mem_initial_query");

        while (queryOnOff) {
            double x = checkedInput.validateInput(); // zebranie wyboru użytkownika; typ danych double jest użyty dlatego, że w metodzie jest użyty double
            if (x == 1) {
                Memory.memoryQueryStoreValueInArray(memoryInput);
                queryOnOff = false; // zamknięcie zapytania, po wprowadzeniu poprawnych danych do pamięci
            } else if (x == 2) {
                queryOnOff = false; // zamknięcie zapytania, gdy użytkownik wybierze 2
            } else {
                logger.error("User used invalid data type to navigate memory query.");
                System.out.println("\n You have entered an invalid number. Please use 1 or 2. \n");
            }
        }

    }

    // metoda zawierająca zapytanie do użytkownika, czy i gdzie w tablicy pamięci umieścić wynik działania
    public static void memoryQueryStoreValueInArray(double memoryArrayInput) {
        boolean queryOnOff = true; // przełącznik zapytania: true - zapytanie działa, false - zapytanie zostaje zatrzymane,

        info.printCaption("mlt_obj_mem_location_query");

        while (queryOnOff) {
            logger.trace("Entering multiple memory management.");
            double index = checkedInput.validateInput();
            if (index == 1) {
                logger.trace("Memory array at index 1 set to" + memoryArrayInput);
                Memory.setMemoryArrayAtIndex(memoryArrayInput, 1);
                queryOnOff = false; // zamknięcie zapytania, po wprowadzeniu poprawnych danych do pamięci
            } else if (index == 2) {
                logger.trace("Memory array at index 2 set to" + memoryArrayInput);
                Memory.setMemoryArrayAtIndex(memoryArrayInput, 2);
                queryOnOff = false; // zamknięcie zapytania, po wprowadzeniu poprawnych danych do pamięci
            } else if (index == 3) {
                logger.trace("Memory array at index 3 set to" + memoryArrayInput);
                Memory.setMemoryArrayAtIndex(memoryArrayInput, 3);
                queryOnOff = false; // zamknięcie zapytania, po wprowadzeniu poprawnych danych do pamięci
            } else if (index == 4) {
                logger.trace("Memory array at index 4 set to " + memoryArrayInput);
                Memory.setMemoryArrayAtIndex(memoryArrayInput, 4);
                queryOnOff = false; // zamknięcie zapytania, po wprowadzeniu poprawnych danych do pamięci
            } else {
                logger.error("User tried to divide by zero.");
                System.out.println("\n You have entered an invalid number. Please use 1 up to 4. \n");
            }
        }
    }

    // metoda wyświetlająca całą zawartość tablicy pamięci
    public static void memoryArrayDisplay() {

        // pierwszy element tablicy jest zdefiniowany osobno, bo użytkownik ma być poinformowany, do czego służy ten element
        System.out.println("\n" +
                "Memory value at index: 0" + " is: " + memoryArray[0] + " // LAST OPERATION VALUE"
        );

        // pętla wyświetlająca wszystkie elementy tablicy
        for (int i = 1; i < memoryArray.length; i++) {
            System.out.println("Memory value at index: " + i + " is: " + memoryArray[i]);
        }
    }
}
