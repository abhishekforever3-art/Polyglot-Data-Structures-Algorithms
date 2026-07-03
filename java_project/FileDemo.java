

import java.nio.file.*;

public class FileDemo {
    public static void main(String[] args) {
        Path path = Path.of("Data.csv");
        //System.out.println(Files.exists(path));
        System.out.println(Files.exists(path));
    }
    
}
