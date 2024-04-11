import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to Tic-Tac-Toe");
        System.out.println("----------------------\n\n");
        String[] board = new String[9];
        for(int i = 0; i <9; i++) {
            board[i] = String.valueOf(i);
        }

        printBoard();

    }

    public static void printBoard() {
        System.out.println();
    }
}