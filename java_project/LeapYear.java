public class LeapYear {

    public static boolean isLeapYear(int year){
        if (year% 400 == 0){
            return  true;
        }
        else if ( year % 100 == 0){
            return false;
        }
        else if ( year% 4== 0 ){
            return true;
        }
        else {
            return false;
        }
        
    }
    public static void main(String[]args){
        int ll = 2000;
        int hl = 2026;
        for (int i=ll; i<=hl; i++){
            if (isLeapYear(i)){
                System.out.println(i+ " is Leap Year");
            }
            else{
                System.out.println(i+ " is not a Leap Year");
            }
        }
            
        }
/* 
    public static void main(String[] args) {
        int ll = 2000;
        int hl = 2026;
    
        for (int i = ll; i <= hl; i++) {
            if (isLeapYear(i)) {
                System.out.println(i + " is a leap year");
            } else {
                System.out.println(i + " is not a leap year");
            }
        }
    }

    
    public static boolean isLeapYear(int year) {
        
        if (year % 400 == 0) {
            return true;
        } else if (year % 100 == 0) {
            return false;
        } else if (year % 4 == 0) {
            return true;
        } else {
            return false;
        }
    } */

    /* public static void main(String[] args) {
        int ll = 2000;
        int hl = 2026;
        for (int i= ll; i<=hl; i++){
            if (i%4==0){
                System.out.println(i+" is a leap year");
            }
            else if (i%400==0){
                System.out.println(i+ " is a leap year");
            }
            else if (i%100==0){
                System.out.println(i+ " is notb a leap year");
            }
        }
    } */
    
}
