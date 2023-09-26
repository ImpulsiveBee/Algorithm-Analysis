import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        int result = 0;
        Scanner scanner = new Scanner(System.in);

        while(scanner.hasNextInt()){
            int num = scanner.nextInt();
            if(num > 0)
                result += num * num;
        }

        System.out.println(result);
    }
}