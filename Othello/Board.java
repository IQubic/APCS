import java.util.*;

public class Board{
    private char[][] board;

    public Board(Scanner scan) {
        board = new char[8][8];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                board[i][j] = scan.next().charAt(0);
            }
        }
    }

    public void display() {
        for (char[] row : this.board) {
            for (char col : row) {
                System.out.println(col);
            }
            System.out.println();
        }
    }

    public void flipLine(Line line){
        BoardPos tileToFlip = line.getStart();
    }
}
