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
                        "\n ===================================================" +
                        "\n TURBO CALC 6000" + " by Miniacz" +
                        "\n ==================================================="
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
            case "mlt_obj_mem_initial_query":
                System.out.println(
                    "\n Do You want to save the result? Result will be stored in multiple object memory." +
                    "\n Please use numbers 1 or 2." +
                    "\n 1: Yes." +
                    "\n 2: No." + "\n"
                );
                break;
            case "mlt_obj_mem_location_query":
                System.out.println(
                    "\n At which memory index You would like to store the result?" +
                    "\n NOTE: Please use numbers 1 up to 4."
                );
                break;
            case "input_get_X":
                System.out.println(
                        "\n Do You want to use last result for the first number?" +
                        "\n 1: yes" +
                        "\n 2: no"
                );
                break;
            case "input_get_Y":
                System.out.println(
                        "\n Do You want to use last result for the second number?" +
                        "\n 1: yes" +
                        "\n 2: no"
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
