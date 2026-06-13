//import java.util.Scanner;

public class GameOfLife {
    public static void main(String[] args) throws InterruptedException {
        // --- MILESTONE 1: SETTING UP THE WORLD ---
        // Define the dimensions of our grid
        int rows = 15;
        int cols = 15;

        // Create the two 2D arrays (Current state and Next state)
        int[][] currentGen = new int[rows][cols];
        int[][] nextGen = new int[rows][cols];

        // --- MILESTONE 2: SEEDING THE GRID (INITIAL STATE) ---
        // We will plant a famous moving pattern called a "Glider"
        // It requires 5 living cells arranged like a small spaceship
        currentGen[1][2] = 1;
        currentGen[2][3] = 1;
        currentGen[3][1] = 1;
        currentGen[3][2] = 1;
        currentGen[3][3] = 1;

        // --- MILESTONE 4: THE MAIN GAME LOOP ---
        // This loop runs continuously, simulating generation after generation
        int generation = 0;
        while (generation < 50) { // Runs for 50 generations (change to true for infinite)
            
            // Clear the terminal screen (ANSI escape code to make it look smooth)
            System.out.print("\033[H\033[2J");
            System.out.flush();
            System.out.println("--- Conway's Game of Life: Generation " + generation + " ---");

            // --- MILESTONE 1 (PRINTING): Display the current generation ---
            for (int r = 0; r < rows; r++) {
                for (int c = 0; c < cols; c++) {
                    if (currentGen[r][c] == 1) {
                        System.out.print("* "); // * represents a Living Cell
                    } else {
                        System.out.print(". "); // . represents a Dead Cell
                    }
                }
                System.out.println(); // Move to the next row
            }

            // --- MILESTONE 3: COMPUTE THE NEXT GENERATION ---
            // Loop through every single cell in our 2D grid
            for (int r = 0; r < rows; r++) {
                for (int c = 0; c < cols; c++) {
                    
                    // --- MILESTONE 3A: THE NEIGHBOR COUNTER & BOUNDARY CHECK ---
                    int aliveNeighbors = 0;

                    // Scan the 3x3 neighborhood around cell [r][c]
                    for (int i = -1; i <= 1; i++) {
                        for (int j = -1; j <= 1; j++) {
                            
                            // Skip checking the center cell itself! We only want neighbors.
                            if (i == 0 && j == 0) {
                                continue;
                            }

                            int neighborRow = r + i;
                            int neighborCol = c + j;

                            // The Guardrail: Ensure neighbor coordinates are INSIDE the grid boundaries
                            if (neighborRow >= 0 && neighborRow < rows && neighborCol >= 0 && neighborCol < cols) {
                                // If the neighbor is alive, increment our count
                                if (currentGen[neighborRow][neighborCol] == 1) {
                                    aliveNeighbors++;
                                }
                            }
                        }
                    }

                    // --- MILESTONE 3B: APPLY CONWAY'S 4 RULES ---
                    if (currentGen[r][c] == 1) {
                        // Rules for Living Cells
                        if (aliveNeighbors < 2) {
                            nextGen[r][c] = 0; // Rule 1: Underpopulation (Dies)
                        } else if (aliveNeighbors == 2 || aliveNeighbors == 3) {
                            nextGen[r][c] = 1; // Rule 2: Survival (Lives)
                        } else {
                            nextGen[r][c] = 0; // Rule 3: Overpopulation (Dies)
                        }
                    } else {
                        // Rules for Dead Cells
                        if (aliveNeighbors == 3) {
                            nextGen[r][c] = 1; // Rule 4: Reproduction (Becomes Alive)
                        } else {
                            nextGen[r][c] = 0; // Stays dead
                        }
                    }
                }
            }

            // --- MILESTONE 4 (STATE TRANSFER): Copy nextGen into currentGen ---
            for (int r = 0; r < rows; r++) {
                for (int c = 0; c < cols; c++) {
                    currentGen[r][c] = nextGen[r][c];
                }
            }

            generation++;

            // --- MILESTONE 4 (TIMER): Slow down execution so your eyes can follow it ---
            Thread.sleep(300); // Pauses the program for 300 milliseconds per tick
        }
    }
}