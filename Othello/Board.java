import java.util.*;

// The game board
public class Board {
    private char[][] board;

    //Read the board from a scanner
    public Board(Scanner scan) {
        board = new char[8][8];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                board[i][j] = scan.next().charAt(0);
            }
        }
    }

    //Write the board to std out
    public void display() {
        for (char[] row : this.board) {
            for (char col : row) {
                System.out.println(col);
            }
            System.out.println();
        }
    }

    //Update the board by flipping an entire line of pieces
    public void flipLine(Line line){
        //TODO Make This Method
    }
}
