package Assignment_1.peggame;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadGame {
    public static char[][] readBoardFromFile(String filePath) throws FileNotFoundException {
        File file = new File(filePath);
        Scanner scanner = new Scanner(file);

        int size = scanner.nextInt();
        scanner.nextLine();

        char[][] board = new char[size][size];
        for (int row = 0; row < size; row++) {
            String line = scanner.nextLine();
            for (int column = 0; column < size; column++) {
                board[row][column] = line.charAt(column);
            }
        }

        scanner.close();
        return board;
    }
}
