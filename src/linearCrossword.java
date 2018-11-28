/**
 * The linear crossword generator.
 * @author Kirill Barsukov
 * @version November 28, 2018
 *
 */
import java.util.*;

public class linearCrossword {

    static Scanner input = new Scanner(System.in);
    static Random random = new Random();
    //constants
    static final int ROWS = 10;
    static final int MINIMUM_COLUMNS = 5;
    static final int MAXIMUM_COLUMNS = 10;

    public static void main(String[] sync) {
        displayHelloMessage();
        getFirstInformation();

    }

    private static void displayHelloMessage() {

        System.out.println("------------------------------------------------------------");
        System.out.println("----Hello! There is a simple linear crossword generator-----");
        System.out.println("------------------------------------------------------------");
        System.out.printf("The maximum length of rows is %d. However, you can chose the number of columns.\n", ROWS);

    }//end of the displayHelloMessage method

    private static void getFirstInformation() {

        System.out.println("How many columns do you need?");
        System.out.printf("It must be between %d and %d", MINIMUM_COLUMNS, MAXIMUM_COLUMNS);

    }//end of the getFirstInformation method

}
