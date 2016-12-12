// This class represents a line of tiles
public class Line {
    private Tile start;
    private Tile end;
    private Direction dir;

    public Line(Tile tile, Direction dir) {
        this.start = tile;
        this.end = tile;
        this.dir = dir;
    }

    public void extendLine(Direction dir) {
        this.end = this.dir.nextTile(end);
    }

    public Tile getStart() {
        return this.start;
    }

    public Tile getEnd() {
        return this.end;
    }

    public Direction getDirection() {
        return this.dir;
    }
}
