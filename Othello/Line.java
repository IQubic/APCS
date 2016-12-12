import java.util.ArrayList;

// This class represents a line of tiles
public class Line {
    private ArrayList<Tile> tiles;
    private Direction dir;

    public Line(Tile start, Direction dir) {
        this.tiles = new ArrayList<>();
        this.tiles.add(start);
        this.dir = dir;
    }

    public void extendLine() {
        Tile lastTile = this.tiles.get(this.tiles.size() - 1);
        this.tiles.add(lastTile.nextTile(this.dir));
    }

    public ArrayList<Tile> getTiles() {
        return tiles;
    }
}
