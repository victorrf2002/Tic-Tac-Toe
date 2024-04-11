import java.util.Scanner;
public class Main {
    static String[] board = new String[9];

    public static void main(String[] args) {
        System.out.println("Welcome to Tic-Tac-Toe");
        System.out.println("----------------------\n\n");


        //  Populating the board array
        for(int i = 0; i <9; i++) {
            board[i] = String.valueOf(i);
        }

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
}