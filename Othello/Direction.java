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

    public BoardPos nextTile(BoardPos curTile) {
        return new BoardPos(curTile.getRow() + rowDir, curTile.getCol() + colDir);
    }
}
