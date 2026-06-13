public class PronicNumber {
    public static void main(String[] args) {
        int target = 20;
        int n = 0;
        while (n*(n+1)<target){
            n++;
            //System.out.println("---------"+n+ (n+1));
            //System.out.println("========="+n);
        }
        if (n*(n+1)==target){
            System.out.println(target+ " is a Pronic Number");
            System.out.println("The consecutive integers are: " + n + " and " + (n + 1));
        }
        else{
            System.out.println(target + " is not a Pronic Number");
            System.out.println("The consecutive integers are: " + n + " and " + (n + 1));

        }
    }
    
}
