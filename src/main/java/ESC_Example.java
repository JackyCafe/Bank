import java.util.Scanner;

public class ESC_Example {
    public static void main(String[] args) {
        while (true){
            Scanner scanner = new Scanner(System.in);
            String key = scanner.next();
            System.out.println(key);
//            if (key=="27"){
//                System.out.println("You press a Esc");
//                System.out.println("Bye");
//            }
        }

    }
}
