package baekjoon.level5;

import java.util.Scanner;

public class no_11720 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        String a = scanner.next();

        int sum = 0;

        for(int i = 0; i < N; i++){

            sum += Integer.parseInt(String.valueOf(a.charAt(i)));
        }

        System.out.println(sum);
    }
}
