import java.util.Scanner;

public class TicTacToe {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Board board = new Board();

        board.print();
        boolean gameGoing = true;
        while (gameGoing) {
            boolean moveSuccessful = false;

            System.out.println(board.getPlayer() + " to play");
            System.out.println("Where will you play?");
            int row = in.nextInt();
            int col = in.nextInt();
            moveSuccessful = board.makeMove(row, col);
            if (!moveSuccessful) {
                System.out.println("Move not allowed");
                board.print();
            } else {
                board.print();

                char winner = board.getWinner();
                if (winner != ' ') {
                    gameGoing = false;
                    switch (winner) {
                        case 'X': System.out.println("X Has Won");
                                  break;
                        case 'O': System.out.println("O Has Won");
                                  break;
                        case '.': System.out.println("Tie Game");
                                  break;
                    }
                }
            }
        }
    }
}
