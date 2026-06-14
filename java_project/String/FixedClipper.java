package String;

import java.util.Scanner;

public class FixedClipper {
    public static void main(String[] args) {
         Scanner sc = new Scanner(System.in);

        System.out.print("Enter the full string: ");
        String text = sc.nextLine();

        System.out.print("Enter the marker word to clip: ");
        String marker = sc.nextLine();

        if (text.contains(marker)) {
            int markerIndex = text.indexOf(marker);
            System.out.println(marker.length()+"----");
            System.out.println("Extracted: " + text.substring(markerIndex,markerIndex+ marker.length()));
        } else {
            System.out.println("Error: Marker not found.");
        }

        sc.close(); 
        
    }
}