/*
* Klasa zastępująca sout - jako element dodatkowego zadania lel
* */

package calcEngine;

public class InfoPrinter {

    public void print(String x) {
        System.out.println(x);
    }

    public void printCaption(String captionType) {

        switch (captionType) {
            case "main title":
                System.out.println(
                        "\n ============ ADD ============" +
                                "\n adds two numbers given by user " +
                                "\n ============================="
                );
                break;
            case "add":
                System.out.println(
                        "\n ============ ADD ============" +
                        "\n adds two numbers given by user " +
                        "\n ============================="
                );
                break;
            case "subtract":
                System.out.println(
                        "\n ============ SUBTRACT ============" +
                        "\n subtracts two numbers given by user " +
                        "\n =================================="
                );
                break;
            case "multiply":
                System.out.println(
                        "\n ============ MULTIPLY ============" +
                        "\n multiplies two numbers given by user " +
                        "\n =================================="
                );
                break;
            case "divide":
                System.out.println(
                        "\n ============ DIVIDE ============" +
                        "\n divides two numbers given by user " +
                        "\n ================================"
                );
                break;
        }
    }

    public void displayMainMenu(){

        // main menu + plus info
        System.out.println(
                "\n \n" +
                        "Please pick menu option:" +
                        "\n 1 - adds two numbers" +
                        "\n 2 - subtracts two numbers" +
                        "\n 3 - multiplies two numbers" +
                        "\n 4 - divides two numbers" +
                        "\n 5 - display all elements of multiple object memory" +
                        "\n 0 - quit" +
                        "\n \n");
    }
}
