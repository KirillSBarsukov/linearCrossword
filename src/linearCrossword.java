/**
 * The linear crossword generator.
 * @author Kirill Barsukov
 * @version November 28, 2018
 *
 */
import java.util.*;

public class linearCrossword {


    //constants
    static final int COLUMNS = 10;
    static final int MINIMUM_ROWS = 5;
    static final int MAXIMUM_ROWS = 10;
    static Scanner input = new Scanner(System.in);
    static Random random = new Random();

    public static void main(String[] sync) {
        displayHelloMessage();
        getFirstInformation();

    }

    private static void displayHelloMessage() {

        System.out.println("------------------------------------------------------------");
        System.out.println("----Hello! There is a simple linear crossword generator-----");
        System.out.println("------------------------------------------------------------");
        System.out.printf("The maximum length of columns is %d. However, you can chose the number of rows.\n", COLUMNS);

    }//end of the displayHelloMessage method

    private static byte getFirstInformation() {
        byte numberOfRows;
        System.out.println("How many rows do you need?");
        System.out.printf("It must be between %d and %d\n", MINIMUM_ROWS, MAXIMUM_ROWS);

        do{
            //prompt for number of worked hours of the user
            numberOfRows = input.nextByte();
            //get the worked hours of the user

            if(numberOfRows < MINIMUM_ROWS || numberOfRows > MAXIMUM_ROWS)
                System.out.printf("INVALID INPUT!! The number of rows MUST be must be between %d and %d\n",MINIMUM_ROWS, MAXIMUM_ROWS);

        }while( numberOfRows < MINIMUM_ROWS || numberOfRows > MAXIMUM_ROWS);
        return numberOfRows;
    }//end of the getFirstInformation method

}
