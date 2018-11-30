/**
 * The WorldPuzzle generator.
 * @author Kirill Barsukov
 * @version November 28, 2018
 * The simple word puzzle generator. It requires size (from 5 x 5 to 10 x 10).
 * Based on the size, the system will ask to input words. All words is kept in 2d array.
 * Every word stores in ordered rows in randomly order.
 * All the empty cells fill by random characters.
 */
import java.util.*;

public class WorldPuzzle {

    //constants
    static final private int MINIMUM_ROWS = 5;
    static final private int MAXIMUM_ROWS = 10;
    static final private int MINIMUM_COLUMNS = 5;
    static final private int MAXIMUM_COLUMNS = 10;

    static private Scanner input = new Scanner(System.in);
    static Random randomGenerator = new Random();

    //the first two dimensional array. Not clarified yet.
    static private char[][] mainArrayForWords;

    public static void main(String[] sync) {

        displayMessage();
        int sizeOfPuzzle = getFirstInformation();
        //System.out.println("Test" + numberOfRows);

        mainArrayForWords = new char[sizeOfPuzzle][sizeOfPuzzle]; //everything is working without it. Maybe delete
        fillWithNames(mainArrayForWords, sizeOfPuzzle);
        fillEmptyCells(mainArrayForWords, sizeOfPuzzle);
        displayWords(mainArrayForWords, sizeOfPuzzle);
    }

    private static void displayMessage() {

        System.out.println("-----------------------------------------------------------------------");
        System.out.println("-----Hello! I will help you to generate a simple world puzzle----------");
        System.out.println("-----I only need to know a size of the puzzle and words----------------");
        System.out.println("-----------------------------------------------------------------------");

    }//end of the displayHelloMessage method

    private static int getFirstInformation() {
        int sizeOfPuzzle;
        System.out.println("Choose the size of the puzzle");
        System.out.printf("It must be between %d x %d and %d x %d\n", MINIMUM_ROWS, MINIMUM_COLUMNS, MAXIMUM_ROWS, MAXIMUM_COLUMNS);

        do {
            //prompt for number of worked hours of the user
            sizeOfPuzzle = input.nextInt();
            //get the worked hours of the user

            if (sizeOfPuzzle < MINIMUM_ROWS || sizeOfPuzzle > MAXIMUM_ROWS)
                System.out.printf("INVALID INPUT!! The number of rows MUST be between %d and %d.\n", MINIMUM_ROWS, MAXIMUM_ROWS);

        } while (sizeOfPuzzle < MINIMUM_ROWS || sizeOfPuzzle > MAXIMUM_ROWS);
        input.nextLine(); //clear the buffer
        System.out.printf("Thank you! We will generate %d x %d size for the puzzle.\n",sizeOfPuzzle, sizeOfPuzzle);
        return sizeOfPuzzle;
    }//end of the getFirstInformation method

    private static void fillWithNames(char[][] mainArrayForWords, int sizeOfPuzzle) {

        String userWords, userUpperWords; //local variable

        for (int i = 0; i < sizeOfPuzzle; i++) {

            do {
                System.out.printf("Please input a word %d: ", i + 1);
                userWords = input.nextLine();
                userUpperWords = userWords.toUpperCase();
                if (userUpperWords.length() > sizeOfPuzzle) {
                    System.out.printf("INVALID INPUT!! The word more than size of line. A length of word  MUST be not more than %d\n", sizeOfPuzzle);
                }//end of it
            } while (userUpperWords.length() > sizeOfPuzzle);

            for (int a = 0; a < userUpperWords.length(); a++) {
                mainArrayForWords[i][a] = userUpperWords.charAt(a);
            }
        }//end of the for loop
    }//end of the fillWithNames method

    private static void displayWords(char [][] mainArrayForWords, int sizeOfPuzzle) {

        System.out.printf("--------A list of words in array %d x %d-------------\n", sizeOfPuzzle, sizeOfPuzzle);
        for (int i = 0; i < sizeOfPuzzle; i++) {
            for (int a = 0; a < sizeOfPuzzle; a++) {
                System.out.printf("%c ", mainArrayForWords[i][a]);
            }//for a
            System.out.println(); //display words line by line
        }//for i
    }

    private static void fillEmptyCells(char[][] mainArrayForWords, int sizeOfPuzzle)
    {
        char[] randomCharacters ={'A', 'U', 'C', 'M', 'E', 'S', 'R', 'Z', 'T', 'I', 'K', 'W', 'B', 'N', 'L', 'Q'};
        int randomNumber;
        int size = randomCharacters.length; //size is initialized to the number of characters in the list


        //iterate through all rows in the 2d array
        for(int i= 0; i < sizeOfPuzzle; i++){
            //iterate through all columns in each row
            for(int a= 0; a < sizeOfPuzzle; a++){
                //if the element is the null character, replace it with *
                if (mainArrayForWords[i][a] == '\u0000')
                    mainArrayForWords[i][a] = '*';
                    //int randomNumber = randomGenerator.nextInt(50) + 1;
            }//for a
        }//for i
    }//fillUnusedElements
}


