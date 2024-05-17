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

        gameplay();
    }

    //  This method checks for a winner by comparing the current board with all possibilities of a win.
    public static boolean checkWin() {
        String pattern = null;

        for(int i = 0; i < 8; i++) {
            switch(i) {
                case 0:
                    pattern = board[0] + board[1] + board[2];
                    break;
                case 1:
                    pattern = board[3] + board[4] + board[5];
                    break;
                case 2:
                    pattern = board[6] + board[7] + board[8];
                    break;
                case 3:
                    pattern = board[0] + board[3] + board[6];
                    break;
                case 4:
                    pattern = board[1] + board[4] + board[7];
                    break;
                case 5:
                    pattern = board[2] + board[5] + board[8];
                    break;
                case 6:
                    pattern = board[0] + board[4] + board[8];
                    break;
                case 7:
                    pattern = board[2] + board[4] + board[6];
                    break;
            }
            if (pattern.equals("XXX")) {
                System.out.println("Congrats! You won!");
                return true;
            }

            if (pattern.equals("OOO")) {
                System.out.println("Game over, you lose.");
                return true;
            }
        }
        return false;
    }

    //  Gameplay loop
    public static void gameplay() {
        while(!checkWin()) {
            System.out.println("Player move:");
            userTurn(userChoice());

            System.out.println("Bot move:");
            botTurn(botChoice());
        }
    }

    //  Asks user for input
    public static int userChoice() {
        Scanner sc = new Scanner(System.in);
        int userChoice = sc.nextInt();
        return userChoice;
    }

    //  Generates computer's random choice
    public static int botChoice() {
        Random rand = new Random();
        int botChoice = rand.nextInt(10);
        return botChoice;
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
        Scanner sc = new Scanner(System.in);
        while(!userValidity(userChoice)) {
            System.out.println("Not a valid square. Please try again.");
            userChoice = sc.nextInt();
        }
        board[userChoice - 1] = "X";
        printBoard();
    }

    // Method that plugs in O over the square the bot randomly chose
    private static void botTurn(int botChoice) {
        Random rand = new Random();
        int low = 1;
        int high = 9;
        while(!botValidity(botChoice)) {
            botChoice = rand.nextInt(high-low) + low;
        }

        board[botChoice - 1] = "O";
        printBoard();
    }

    //  Method that checks if user choice is valid
    private static boolean userValidity(int userChoice) {
        if (userChoice != 1 && userChoice != 2 && userChoice != 3 && userChoice != 4 && userChoice != 5 &&
                userChoice != 6 && userChoice != 7 && userChoice != 8 && userChoice != 9) {
            return false;
        }
        if (board[userChoice-1].equals("0") || board[userChoice-1].equals("X")) {
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