import java.util.Scanner;
import java.util.Random;
public class Main {
    static String[] board = new String[9];

    public static void main(String[] args) {
        System.out.println("Welcome to Tic-Tac-Toe");
        System.out.println("----------------------\n");
        System.out.println("Choose a square: \n");

        //  Populating the board array
        for(int i = 0; i < 9; i++) {
            board[i] = String.valueOf(i+1);
        }

        printBoard();

        Scanner sc = new Scanner(System.in);
        int userChoice = sc.nextInt();

        userTurn(userChoice);
        System.out.println("Player move: ");
        printBoard();

        Random rand = new Random();
        System.out.println("Bot move: ");
        int botChoice = rand.nextInt(10);

        botTurn(botChoice);
        printBoard();






    }

    //  Method that prints the Tic-Tac-Toe game board
    public static void printBoard() {
        System.out.println("  " + board[0] + "  |  " + board[1] + "  |  " + board[2] );
        System.out.println("- - -" + "|" + "- - -" + "|" + "- - -");
        System.out.println("  " + board[3] + "  |  " + board[4] + "  |  " + board[5] );
        System.out.println("- - -" + "|" + "- - -" + "|" + "- - -");
        System.out.println("  " + board[6] + "  |  " + board[7] + "  |  " + board[8] );
    }

    //  Method that plugs in X over the square the user chose
    private static void userTurn(int userChoice) {
        if(!userValidity(userChoice))
            System.out.println("Error, not a valid square.");
        else
            board[userChoice - 1] = "X";
    }

    // Method that plugs in O over the square the bot randomly chose
    private static void botTurn(int botChoice) {
        if(!botValidity(botChoice))
            System.out.println("Error");
        else
            board[botChoice - 1] = "O";
    }

    //  Method that checks if user choice is valid
    private static boolean userValidity(int userChoice) {
        if (userChoice != 1 && userChoice != 2 && userChoice != 3 && userChoice != 4 && userChoice != 5 &&
                userChoice != 6 && userChoice != 7 && userChoice != 8 && userChoice != 9) {
            return false;
        }
        else
            return true;
    }

    //  Method that checks if bot choice is valid
    private static boolean botValidity(int botChoice) {
        if(board[botChoice-1].equals("X") || board[botChoice-1].equals("O")) {
            return false;
        }
        else
            return true;
    }
}