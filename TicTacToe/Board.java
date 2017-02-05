public class Board {
    private char[][] board;
    private char player;
    private int turnsTaken;

    public  Board() {
        this.board = new char[][] {{'.', '.', '.'},
                                    {'.', '.', '.'},
                                    {'.', '.', '.'}};
        this.player = 'X';
        this.turnsTaken = 0;
    }

    public boolean makeMove(int row, int col) {
        if (row > 2 || row < 0 || col > 2 || col < 0) {
            return false;
        } else if (this.board[row][col] != '.') {
            return false;
        } else {
            this.turnsTaken++;
            this.board[row][col] = this.player;
            this.changePlayer();
            return true;
        }
    }

    public void print() {
        System.out.println("  0 1 2");
        for (int i = 0; i < 3; i++) {
            System.out.print(i + " ");
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public char getWinner() {
        if (this.turnsTaken == 9) {
            return '.';
        }

        for (char[] row : this.board) {
            if (row[0] == row[1] && row[1] == row[2] && row[1] != '.') {
                return row[0];
            }
        }

        for (int i = 0; i < 3; i++) {
            if (board[0][i] == board[1][i] && board[1][i] == board[2][i] && board[0][i] != '.') {
                return board[i][0];
            }
        }

        if (board[0][0] == board[1][1] && board[1][1] == board[2][2] && board[0][0] != '.') {
            return board[0][0];
        } else if (board[0][2] == board[1][1] && board[1][1] == board[2][0] && board[0][2] != '.') {
            return board[0][2];
        }

        return ' ';
    }

    private void changePlayer() {
        if (this.player == 'X') {
            this.player = 'O';
        } else {
            this.player = 'X';
        }
    }

    public char getPlayer() {
        return this.player;
    }

}
