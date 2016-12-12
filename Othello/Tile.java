// This class holds the position of a tile on the board
public class Tile {
    private int row;
    private int col;

    public Tile(int row, int col) {
        this.row = row;
        this.col = col;
    }

    // Gets the next Tile along in a given direction
    public Tile nextTile(Direction dir) {
        return new Tile(this.row + dir.getRowDir(), this.col + dir.getColDir());
    }

    public int getRow() {
        return this.row;
    }

    public int getCol() {
        return this.col;
    }
}
