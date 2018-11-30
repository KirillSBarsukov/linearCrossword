/*
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
    static final private int MINIMUM_SIZE = 5;
    static final private int MAXIMUM_SIZE = 10;

    //declare Scanner to get information from user and Random to generate random numbers
    static private Scanner input = new Scanner(System.in);
    static private Random random = new Random();

    //the first two dimensional array. Not clarified yet. Still something wrong with it. Can I make it local??
    static private char[][] mainArrayForWords;

    public static void main(String[] sync) {
        //displayMessage method
        displayMessage();
        //Displays size of the puzzle. For example, 5 x 5, 7 x 7 or 10 x 10
        int sizeOfPuzzle = getFirstInformation();
        mainArrayForWords = new char[sizeOfPuzzle][sizeOfPuzzle]; //everything is working without it. Maybe delete
        //fillWithNames method get input from user and store it in 2d array mainArrayForWords[][]
        fillWithNames(mainArrayForWords, sizeOfPuzzle);
        displayPuzzle(mainArrayForWords, sizeOfPuzzle);
        //fillEmptyCells
        fillEmptyCells(mainArrayForWords, sizeOfPuzzle);
        //display the puzzle
        displayPuzzle(mainArrayForWords, sizeOfPuzzle);
    }

    /**
     * The method displayMessage() shows first message and explains the purpose of the program.
     */
    private static void displayMessage() {

        System.out.println("-----------------------------------------------------------");
        System.out.println("-----This program creates a simple word puzzle-------------");
        System.out.println("-----------------------------------------------------------");

    }//end of the displayHelloMessage method


    /**
     * @return size of the puzzle. For example, 5x5, 7x7. It is always a square.
     */
    private static int getFirstInformation() {
        int sizeOfPuzzle;
        System.out.printf("What is the size of the puzzle you would like to create (>=%d and <= %d)\n", MINIMUM_SIZE, MAXIMUM_SIZE);

        do {
            //prompt for number of worked hours of the user
            sizeOfPuzzle = input.nextInt();
            //get the worked hours of the user

            if (sizeOfPuzzle < MINIMUM_SIZE || sizeOfPuzzle > MAXIMUM_SIZE)
                System.out.printf("******Invalid size, MUST be >= %d and <= %d.\n", MINIMUM_SIZE, MAXIMUM_SIZE);
        } while (sizeOfPuzzle < MINIMUM_SIZE || sizeOfPuzzle > MAXIMUM_SIZE);
        input.nextLine(); //clear the buffer
        System.out.printf("Thank you! We will generate %d x %d size for the puzzle.\n", sizeOfPuzzle, sizeOfPuzzle);
        System.out.println("------------------------------------------------------------");
        System.out.printf("--Enter %d words, each word no more than %d characters long--\n", sizeOfPuzzle, sizeOfPuzzle);
        System.out.println("------------------------------------------------------------");
        return sizeOfPuzzle;
    }//end of the getFirstInformation method

    /**
     * @param mainArrayForWords the main array to store words
     * @param sizeOfPuzzle the number of rows and columns since it is a square array
     */
    private static void fillWithNames(char[][] mainArrayForWords, int sizeOfPuzzle) {

        String userWords, userUpperWords; //local variable
        int randomCharacter;
        for (int i = 0; i < sizeOfPuzzle; i++) {

            do {
                System.out.printf("Please enter word %d to add to the puzzle: ", i + 1);
                userWords = input.nextLine();
                userUpperWords = userWords.toUpperCase();
                if (userUpperWords.length() > sizeOfPuzzle) {
                    System.out.printf("*****Word cannot fit in the puzzle. It MUST be <= %d characters in length\n", sizeOfPuzzle);
                }//end of it
            } while (userUpperWords.length() > sizeOfPuzzle);

            randomCharacter = random.nextInt(sizeOfPuzzle - userUpperWords.length());

            for (int a = 0; a < userUpperWords.length(); a++) {

                //a+1 system moves every word from 0 position to 1 position

                mainArrayForWords[i][a + randomCharacter] = userUpperWords.charAt(a);
            }
        }//end of the for loop
    }//end of the fillWithNames method

    /**
     * @param mainArrayForWords the main array to store words
     * @param sizeOfPuzzle      the number of rows and columns since it is a square array
     */
    private static void displayPuzzle(char[][] mainArrayForWords, int sizeOfPuzzle) {

        System.out.println("-------------The words to search  -----------");
        for (int i = 0; i < sizeOfPuzzle; i++) {
            for (int a = 0; a < sizeOfPuzzle; a++) {
                System.out.printf("%c ", mainArrayForWords[i][a]);
            }//for a
            System.out.println(); //display words line by line
        }//for i
    }//end of the displayPuzzle method

    /**
     * The method take characters from pre-declared array and fill them empty cells in 2d array mainArrayForWords[][]
     *
     * @param mainArrayForWords the main array to store words
     * @param sizeOfPuzzle      the number of rows and columns since it is a square array
     */
    private static void fillEmptyCells(char[][] mainArrayForWords, int sizeOfPuzzle) {
        char[] randomCharacters = {'A', 'U', 'C', 'M', 'E', 'S', 'R', 'Z', 'T', 'I', 'K', 'W', 'B', 'N', 'L', 'Q'};
        int randomCharacter;
        int size = randomCharacters.length; //size is initialized to the number of characters in the list

        //iterate through all rows in the 2d array
        for (int i = 0; i < sizeOfPuzzle; i++) {
            //iterate through all columns in each row
            for (int a = 0; a < sizeOfPuzzle; a++) {
                randomCharacter = random.nextInt(size);//gets a random number in the range 0 to (size-1)
                //if the element is the null character, replace it with random character from local array randomCharacters[]
                if (mainArrayForWords[i][a] == '\u0000') {
                    mainArrayForWords[i][a] = randomCharacters[randomCharacter];
                }//if
            }//for a
        }//for i
    }//end of the fillEmptyCells method

}