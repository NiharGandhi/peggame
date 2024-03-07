package Assignment_1.peggame;

import java.util.Scanner;

public class GameCLI {

    private PegGame pegGame;

    public GameCLI(PegGame pegGame) {
        this.pegGame = pegGame;
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Let's Start!");

        while (true) {
            System.out.println("Current Game Status: " + pegGame.getGameState());
            System.out.println(pegGame.getPossibleMoves());
            System.out.println("Enter your move as in, (move r1 c1 r2 c2) :");
            String input = scanner.next();

            if (input.equalsIgnoreCase("quit")) {
                System.out.println("Quitting Game");
                break;
            }
            
            try {
                System.out.println("Moving Trying");
                int fromRow = scanner.nextInt();
                int fromCol = scanner.nextInt();
                int toRow = scanner.nextInt();
                int toCol = scanner.nextInt();

                Move move = new Move(new Location(fromRow, fromCol), new Location(toRow, toCol));
                pegGame.makeMove(move);

            } catch (PegGameException e) {
                System.out.println("Invalid Move. Please try again.");
            }

            if (scanner.hasNextLine() && scanner.nextLine().equalsIgnoreCase("quit")) {
                System.out.println("Quitting Game!!!");
                break;
            }
            
        }

        scanner.close();
    }
    
}