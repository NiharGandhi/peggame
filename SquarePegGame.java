package Assignment_1.peggame;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class SquarePegGame implements PegGame {
    private char[][] board;

    public SquarePegGame(String filePath) throws IOException {
        board = ReadGame.readBoardFromFile(filePath);
    }

    @Override
    public Collection<Move> getPossibleMoves() {
        List<Move> possibleMoves = new ArrayList<Move>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
            if (board[i][j] == 'o') {
                if (i - 2 >= 0 && board[i - 1][j] == 'o' && board[i - 2][j] == '.') {
                    possibleMoves.add(new Move(new Location(i, j), new Location(i - 2, j)));
                }
                if (i + 2 < board.length && board[i + 1][j] == 'o' && board[i + 2][j] == '.') {
                    possibleMoves.add(new Move(new Location(i, j), new Location(i + 2, j)));
                }
                if (j - 2 >= 0 && board[i][j - 1] == 'o' && board[i][j - 2] == '.') {
                    possibleMoves.add(new Move(new Location(i, j), new Location(i, j -2)));
                }
                if (j + 2 < board[i].length && board[i][j + 1] == 'o' && board[i][j + 2] == '.') {
                    possibleMoves.add(new Move(new Location(i, j), new Location(i, j + 2)));
                    }
        
                // Check diagonal moves
                if (i - 2 >= 0 && j - 2 >= 0 && board[i - 1][j - 1] == 'o' && board[i - 2][j - 2] == '.') {
                    possibleMoves.add(new Move(new Location(i, j), new Location(i - 2, j - 2)));
                }
                if (i - 2 >= 0 && j + 2 < board[i].length && board[i - 1][j + 1] == 'o' && board[i - 2][j + 2] == '.') {
                    possibleMoves.add(new Move(new Location(i, j), new Location(i - 2, j + 2)));
                }
                if (i + 2 < board.length && j - 2 >= 0 && board[i + 1][j - 1] == 'o' && board[i + 2][j - 2] == '.') {
                    possibleMoves.add(new Move(new Location(i, j), new Location(i + 2, j - 2)));
                }
                if (i + 2 < board.length && j + 2 < board[i].length && board[i + 1][j + 1] == 'o' && board[i + 2][j + 2] == '.') {
                    possibleMoves.add(new Move(new Location(i, j), new Location(i + 2, j + 2)));
                }
            }
        }
    }
    return possibleMoves;
}

    @Override
    public GameState getGameState() {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return GameState.NOT_STARTED;
        } else if (getPossibleMoves().isEmpty()) {
            int numOfPegs = 0;
            for (char[] row : board) {
                for (char box : row) {
                    if (box == 'o') {
                        numOfPegs++;
                    }
                }
            }
            if (numOfPegs == 1) {
                return GameState.WON;
            } else {
                return GameState.STALEMATE;
            } 
        } else {
            return GameState.IN_PROGRESS;
        }
    }

    @Override
    public void makeMove(Move move) throws PegGameException {
        Location from = move.getFrom();
        Location to = move.getTo();

        if (!getPossibleMoves().contains(move)) {
            throw new PegGameException("Invalid Move! TRY AGAIN :<");
        }

        board[from.getRow()][from.getCol()] = '.';
        board[(from.getRow() + to.getRow())/2][(from.getCol() + to.getCol())/2] = '.';
        board[to.getRow()][to.getCol()] = 'o';

        for (char[] row : board) {
            for (char box : row) {
                System.out.print(box + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        try {
            SquarePegGame game = new SquarePegGame("Assignment_1/peggame/game.txt");
            System.out.println("Possible Move: " + game.getPossibleMoves());
            GameCLI gameCLI = new GameCLI(game);
            gameCLI.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}