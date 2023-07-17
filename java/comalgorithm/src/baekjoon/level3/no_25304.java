package baekjoon.level3;

import java.util.Scanner;

public class no_25304 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        long x = scanner.nextLong();
        int n = scanner.nextInt();
        long total = 0;

        for(int i = 0; i < n; i++){
            long a = scanner.nextLong();
            int b = scanner.nextInt();

            long prize = a * b;
            total += prize;
        }

        if(total == x){
            System.out.println("Yes");
        }else
            System.out.println("No");
    }
}
