public class BoardPos {
    private int row;
    private int col;

    public BoardPos(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public void nextPos(BoardPos direction) {
        this.row += direction.row;
        this.col += direction.col;
    }

    public int getRow() {
        return this.row;
    }

    public int getCol() {
        return this.col;
    }
}
