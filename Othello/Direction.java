// This enum lists all the directions
public enum Direction {
    NW(-1, -1),
    N(0, -1),
    NE(1, -1),
    W(-1, 0),
    E(1, 0),
    SW(-1, 1),
    S(0, 1),
    SE(1, 1);

    private final int rowDir;
    private final int colDir;
    private Direction(int rowDir, int colDir) {
        this.rowDir = rowDir;
        this.colDir = colDir;
    }

    // Returns the next tile along in a line
    public Tile nextTile(Tile curTile) {
        return new Tile(curTile.getRow() + rowDir, curTile.getCol() + colDir);
    }
}
