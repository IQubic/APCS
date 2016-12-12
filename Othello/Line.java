public class Line {
    private BoardPos start;
    private BoardPos end;
    private BoardPos direction;

    public Line(BoardPos tile, BoardPos direction) {
        this.start = tile;
        this.end = tile;
        this.direction = direction;
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
