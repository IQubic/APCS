public enum Symbol {
    X('x'),
    O('o'),
    BLANK('.');

    private char symbol;

    private Symbol(char symbol) {
        this.symbol = symbol;
    }

    public char getChar() {
        return this.symbol;
    }
}
