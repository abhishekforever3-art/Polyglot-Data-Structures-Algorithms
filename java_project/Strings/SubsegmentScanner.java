package Strings;

public class SubsegmentScanner {
    public static void main(String[] args) {
        String s1 = "Abhishek";
        int k = 5;
        int totallength = s1.length();
        int Startindex = totallength - k;
        System.out.println("Scanning \"" + s1 + "\" with window size K = " + k + ":\n");

        if ( k>totallength || k <=0){
            System.out.println("Error: Invalid window length K.");
        }
        else{
            for (int i =0; i<Startindex; i++){
                String s2 = "";
                for (int j =0; j<k; j++){
                    s2 = s2+ s1.charAt(i+j);    
                    
                }
                System.out.println("Window at Index " + i + ": " + s2);
            }
        }
    }
}
