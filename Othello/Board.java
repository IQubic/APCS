import java.util.Scanner;

// The game board
public class Board {
    private char[][] board;

    // Read the board from a scanner
    public Board(Scanner scan) {
        board = new char[8][8];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                board[i][j] = scan.next().charAt(0);
            }
        }
    }

    // Write the board to std out
    public void display() {
        for (char[] row : this.board) {
            for (char col : row) {
                System.out.println(col);
            }
            System.out.println();
        }
    }

    // Makes a move if possible
    // Returns True if a move has successfully been made
    // Returns False if no move can be made
    public boolean makeMove(Tile pos, char player) {
        // TODO Write this method
        return true;
    }

    // Update the board by flipping an entire line of pieces
    private void flipLine(Line line){
        for (Tile tileToFlip : line.getTiles()) {
            this.flipTile(tileToFlip);
        }
    }

    // Flip a single tile
    private void flipTile(Tile tile) {
        if (this.getTileContents(tile) == 'W') {
            this.setTileContents(tile, 'B');
        } else if (this.getTileContents(tile) == 'B') {
            this.setTileContents(tile, 'W');
        }
    }

    // Getting the char at a certain tile
    private char getTileContents(Tile tile) {
        return this.board[tile.getRow()][tile.getCol()];
    }

    // Setting the char at a certain tile
    private void setTileContents(Tile tile, char piece) {
        this.board[tile.getRow()][tile.getCol()] = piece;
    }
}
