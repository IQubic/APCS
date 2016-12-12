public enum Color {
    WHITE,
    BLACK,
    EMPTY;

    public static Color getColor(char piece) {
        if (piece == 'W') {
            return WHITE;
        } else if (piece == 'B') {
            return BLACK;
        } else {
            return EMPTY;
        }

    }

    @Override
    public String toString() {
        if (this.equals(WHITE)) {
            return "W";
        } else if (this.equals(BLACK)) {
            return "B";
        } else {
            return ".";
        }
 
    }

    public Color getOpposingColor() {
        if (this.equals(WHITE)) {
            return BLACK;
        } else if (this.equals(BLACK)) {
            return WHITE;
        } else {
            return EMPTY;
        }
    }
}
