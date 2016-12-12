import java.util.Scanner;

// The game board
public class Board {
    private Color[][] board;
    private Color curPlayer;

    // Read the board from a scanner
    public Board(Scanner scan) {
        board = new Color[8][8];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                board[i][j] = Color.getColor(scan.next().charAt(0));
            }
        }
        this.curPlayer = Color.getColor(scan.next().charAt(0));
    }

    // Write the board to std out
    public void display() {
        for (Color[] row : this.board) {
            for (Color col : row) {
                System.out.println(col);
            }
            System.out.println();
        }
    }

    // Makes a move and flips the correct lines
    public void makeMove(Tile pos) {
        // TODO Write this method
    }

    // Update the board by flipping an entire line of pieces
    private void flipLine(Line line) {
        for (Tile tileToFlip : line.getTiles()) {
            this.flipTile(tileToFlip);
        }
    }

    // Flip a single tile
    private void flipTile(Tile tile) {
        this.setTileContents(tile, this.getTileContents(tile).getOpposingColor());
    }

    // TODO Write this method
    // Checks if something is a valid move or not
    public boolean isAValidMove(Tile pos) {
        return true;
    }

    // Getting the color at a certain tile
    private Color getTileContents(Tile tile) {
        return this.board[tile.getRow()][tile.getCol()];
    }

    // Setting the color at a certain tile
    private void setTileContents(Tile tile, Color piece) {
        this.board[tile.getRow()][tile.getCol()] = piece;
    }
}
