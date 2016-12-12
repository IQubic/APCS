public class Line {
    private BoardPos start;
    private BoardPos end;
    private Direction dir;

    public Line(BoardPos tile, Direction dir) {
        this.start = tile;
        this.end = tile;
        this.dir = dir;
    }

    public void extendLine(Direction dir) {
        this.end = this.dir.nextTile(end);
    }

    public BoardPos getStart() {
        return this.start;
    }

    public BoardPos getEnd() {
        return this.end;
    }

    public BoardPos getDirection() {
        return this.direction;
    }
}
