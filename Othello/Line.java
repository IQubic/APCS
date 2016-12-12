import java.util.ArrayList;

// This class represents a line of tiles
// A line excludes the start tile as
// That is where the last piece has been played
// And that piece doesn't need to be flipped
public class Line {
    private ArrayList<Tile> tiles;
    private Direction dir;

    public Line(Tile start, Direction dir) {
        this.tiles = new ArrayList<>();
        this.tiles.add(start.nextTile(dir));
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
