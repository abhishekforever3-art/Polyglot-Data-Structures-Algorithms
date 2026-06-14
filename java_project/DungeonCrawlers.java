import java.util.Scanner;

public class DungeonCrawlers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = 8;
        int cols = 8;
        char[][] map = new char[rows][cols];

        int playerRow = 1;
        int playerCol = 1;

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                map[r][c] = '.';
            }
        }

        for (int c = 0; c < cols; c++) {
            map[0][c] = '#';        
            map[rows - 1][c] = '#'; 
        }
        for (int r = 0; r < rows; r++) {
            map[r][0] = '#';        
            map[r][cols - 1] = '#'; 
        }

        map[3][2] = '#'; 
        map[3][3] = '#';
        map[2][5] = 'G'; 
        map[6][6] = 'E'; 

        int goldCount = 0;
        boolean gameRunning = true;

        System.out.println("WELCOME TO THE DUNGEON! Find the Gold (G) and reach the Exit (E).");
        System.out.println("Use W (Up), A (Left), S (Down), D (Right) to move.");

        while (gameRunning) {
            map[playerRow][playerCol] = 'P';

            System.out.println("\nGold Collected: " + goldCount);
            for (int r = 0; r < rows; r++) {
                for (int c = 0; c < cols; c++) {
                    System.out.print(map[r][c] + " ");
                }
                System.out.println();
            }

            System.out.print("Enter move (W/A/S/D or Q to quit): ");
            char move = scanner.next().toUpperCase().charAt(0);

            if (move == 'Q') {
                System.out.println("You abandoned the quest! Game Over.");
                break;
            }

            int nextRow = playerRow;
            int nextCol = playerCol;

            if (move == 'W') nextRow--;      
            else if (move == 'S') nextRow++; 
            else if (move == 'A') nextCol--; 
            else if (move == 'D') nextCol++; 

            if (map[nextRow][nextCol] == '#') {
                System.out.println("Ouch! You bumped into a wall!");
            } else {
                map[playerRow][playerCol] = '.';

                playerRow = nextRow;
                playerCol = nextCol;

                if (map[playerRow][playerCol] == 'G') {
                    goldCount++;
                    System.out.println("✨ You found Gold! ✨");
                }
                
                if (map[playerRow][playerCol] == 'E') {
                    System.out.println("\n🎉 CONGRATULATIONS! You escaped with " + goldCount + " gold piece(s)!");
                    gameRunning = false;
                }
            }
        }
        scanner.close();
    }
}