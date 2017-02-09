public class Row {
    private Symbol[] symbols;
    private Tile curTile;
    private Tile direction;

    public row(Board board, Tile curTile, Tile direction) {
        this.Symbol = new Symbol[board.getSize()];
        this.curTile = curTile;
        this.direction = direction;
        this.fillRow(board);
    }

    private void fillRow(Board board) {
        for (int i = 0; i < symbols.length; i++) {
            symbols[i] = board.getTile(curTile).getSymbol();
            curTile.translate(direction);
        }
    }

    public boolean isSameSymbol() {
        for (int i = 0; i < symbols.length; i++) {
            for (int j = i; j < symbols.length; j++) {
                if (symbols[i] != symbols[j]) {
                    return false;
                }
            }
        }
        return true;
    }
}
