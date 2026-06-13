package Array.TwoDArray;

public class PeakElements {
    public static void main(String[] args) {


        int[][] a = {
            {10, 20, 15},
            {14, 17, 12},
            {21,  8, 13}
        };

        System.out.println("Original Grid Matrix:");
        for (int row = 0; row < a.length; row++) {
            for (int col = 0; col < a[row].length; col++) {
                System.out.print(a[row][col] + "\t");
            }
            System.out.println();
        }
        System.out.println("-----------------------------------");

        boolean peakFound = false;

        // SCAN EVERY CELL IN THE GRID
        for (int row = 0; row < a.length; row++) {
            for (int col = 0; col < a[row].length; col++) {
                
                int current = a[row][col];
                boolean isPeak = true;

                // 1. CHECK TOP NEIGHBOR: Only check if row > 0
                if (row > 0 && current < a[row - 1][col]) {
                    isPeak = false;
                }

                // 2. CHECK BOTTOM NEIGHBOR: Only check if row < total rows - 1
                if (row < a.length - 1 && current < a[row + 1][col]) {
                    isPeak = false;
                }

                // 3. CHECK LEFT NEIGHBOR: Only check if col > 0
                if (col > 0 && current < a[row][col - 1]) {
                    isPeak = false;
                }

                // 4. CHECK RIGHT NEIGHBOR: Only check if col < total columns - 1
                if (col < a[row].length - 1 && current < a[row][col + 1]) {
                    isPeak = false;
                }

                // VERDICT FOR CURRENT CELL
                if (isPeak) {
                    System.out.println("Peak Element Discovered!");
                    System.out.println("Value: " + current + " at coordinate pair: [" + row + ", " + col + "]");
                    peakFound = true;
                    break; // Exit the column loop
        }
            }
            if (peakFound) {
                break; // Exit the row loop early
            }
        }
    }
}


