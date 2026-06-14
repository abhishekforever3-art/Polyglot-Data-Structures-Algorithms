import java.util.Scanner;

public class DungeonCrawler {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); //  Right!

        // --- MILESTONE 1: SETTING UP THE WORLD & PLAYER ---
        int rows = 8;
        int cols = 8;
        char[][] map = new char[rows][cols];

        // Player starting coordinates
        int playerRow = 1;
        int playerCol = 1;

        // --- MILESTONE 2: SEEDING THE GRID (MAP CREATION) ---
        // Fill the map with empty floor dots '.'
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                map[r][c] = '.';
            }
        }

        // Place hardcoded obstacles/walls '#'
        for (int c = 0; c < cols; c++) {
            map[0][c] = '#';        // Top outer wall
            map[rows - 1][c] = '#'; // Bottom outer wall
        }
        for (int r = 0; r < rows; r++) {
            map[r][0] = '#';        // Left outer wall
            map[r][cols - 1] = '#'; // Right outer wall
        }

        // Place an internal wall, a Gold item 'G', and an Exit door 'E'
        map[3][2] = '#'; 
        map[3][3] = '#';
        map[2][5] = 'G'; // Treasure!
        map[6][6] = 'E'; // The exit to win the game

        // Game states
        int goldCount = 0;
        boolean gameRunning = true;

        System.out.println("WELCOME TO THE DUNGEON! Find the Gold (G) and reach the Exit (E).");
        System.out.println("Use W (Up), A (Left), S (Down), D (Right) to move.");

        // --- MILESTONE 4: THE MAIN GAME LOOP ---
        while (gameRunning) {
            
            // Place player dynamically on the map matrix
            map[playerRow][playerCol] = 'P';

            // --- MILESTONE 1 (PRINTING): Display the Map ---
            System.out.println("\nGold Collected: " + goldCount);
            for (int r = 0; r < rows; r++) {
                for (int c = 0; c < cols; c++) {
                    System.out.print(map[r][c] + " ");
                }
                System.out.println();
            }

            // Get player input
            System.out.print("Enter move (W/A/S/D or Q to quit): ");
            char move = scanner.next().toUpperCase().charAt(0);

            if (move == 'Q') {
                System.out.println("You abandoned the quest! Game Over.");
                break;
            }

            // --- MILESTONE 3: COMPUTE FUTURE MOVEMENT ---
            // Calculate where the player *wants* to go based on conditions
            int nextRow = playerRow;
            int nextCol = playerCol;

            if (move == 'W') nextRow--;      // Move Up (subtract row index)
            else if (move == 'S') nextRow++; // Move Down (add row index)
            else if (move == 'A') nextCol--; // Move Left (subtract column index)
            else if (move == 'D') nextCol++; // Move Right (add column index)

            // --- MILESTONE 3A: BOUNDARY & COLLISION CHECKS ---
            // Check if the target position is a wall
            if (map[nextRow][nextCol] == '#') {
                System.out.println("Ouch! You bumped into a wall!");
                // Do nothing else - nextRow and nextCol are ignored, player staying put
            } else {
                // Remove player from old position on the map before moving
                map[playerRow][playerCol] = '.';

                // Update actual position variables
                playerRow = nextRow;
                playerCol = nextCol;

                // --- MILESTONE 3B: INTERACTION LOGIC ---
                // Check if player stepped on Gold
                if (map[playerRow][playerCol] == 'G') {
                    goldCount++;
                    System.out.println("✨ You found Gold! ✨");
                }
                
                // Check if player stepped on the Exit
                if (map[playerRow][playerCol] == 'E') {
                    System.out.println("\n🎉 CONGRATULATIONS! You escaped with " + goldCount + " gold piece(s)!");
                    gameRunning = false;
                }
            }
        }
        scanner.close();
    }
}