/**
 * The linear crossword generator.
 * @author Kirill Barsukov
 * @version November 28, 2018
 *
 */
import java.util.*;

public class linearCrossword {

    //constants
    static final private int MINIMUM_ROWS = 5;
    static final private int MAXIMUM_ROWS = 10;
    static final private int COLUMNS = 10;
    static private Scanner input = new Scanner(System.in);
    static Random random = new Random();

    //the first two dimensional array. Not clarified yet.
    static private char[][] mainArrayForWords;

    public static void main(String[] sync) {

        displayHelloMessage();
        int numberOfRows = getFirstInformation();
        //System.out.println("Test" + numberOfRows);

        mainArrayForWords = new char[numberOfRows][COLUMNS]; //everything is working without it. Maybe delete
        fillWithNames(mainArrayForWords, numberOfRows);
        displayWords(mainArrayForWords, numberOfRows);
    }

    private static void displayHelloMessage() {

        System.out.println("------------------------------------------------------------");
        System.out.println("----Hello! There is a simple linear crossword generator-----");
        System.out.println("------------------------------------------------------------");
        System.out.printf("The maximum length of columns is %d. However, you can chose the number of rows.\n", COLUMNS);

    }//end of the displayHelloMessage method

    private static int getFirstInformation() {
        int numberOfRows;
        System.out.println("How many rows do you need?");
        System.out.printf("It must be between %d and %d\n", MINIMUM_ROWS, MAXIMUM_ROWS);

        do {
            //prompt for number of worked hours of the user
            numberOfRows = input.nextInt();
            //get the worked hours of the user

            if (numberOfRows < MINIMUM_ROWS || numberOfRows > MAXIMUM_ROWS)
                System.out.printf("INVALID INPUT!! The number of rows MUST be between %d and %d\n", MINIMUM_ROWS, MAXIMUM_ROWS);

        } while (numberOfRows < MINIMUM_ROWS || numberOfRows > MAXIMUM_ROWS);
        return numberOfRows;
    }//end of the getFirstInformation method

    private static void fillWithNames(char[][] mainArrayForWords, int numberOfRows) {

        String userWords; //local variable
        for (int i = 0; i < numberOfRows; i++) {

            do {
                System.out.printf("Please input a word %d: ", i + 1);
                userWords = input.nextLine();

                if (userWords.length() > COLUMNS) {
                    System.out.printf("INVALID INPUT!! The word more than size of line. A length of word  MUST be not more than %d\n", COLUMNS);
                }//end of it
            } while (userWords.length() > COLUMNS);
            for (int a = 0; a < userWords.length(); a++) {
                mainArrayForWords[i][a] = userWords.charAt(a);
            }
        }//end of the for loop
    }//end of the fillWithNames method

    private static void displayWords(char [][] mainArrayForWords, int numberOfRows) {

        System.out.printf("--------A list of words in array %d x %d-------------\n", numberOfRows, COLUMNS);
        for (int i = 0; i < numberOfRows; i++) {

            for (int a = 0; a < COLUMNS; a++) {
                System.out.printf("%c ", mainArrayForWords[i][a]);
            }
            System.out.println();
        }
    }
}


