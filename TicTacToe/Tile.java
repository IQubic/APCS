public class Tile {
    private int x;
    private int y;
    private Symbol symbol;

    public Tile(int x, int y) {
        this(x, y, Symbol.EMPTY);
    }

    public Tile(int x, int y, int tile) {
        this.x = x;
        this.y = y;
        this.tile = tile;
    }

    public void translate(int x, int y) {
        this.x += x;
        this.y += y;
    }

    public void translate(Tile direction) {
        this.x += direction.getX();
        this.y += direction.getY();
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public void setSymbol(Symbol symbol) {
        this.symbol = symbol;
    }

    public int getSymbol() {
        return this.symbol;
    }
}
