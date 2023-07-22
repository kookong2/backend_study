package baekjoon.level8;

import java.util.Scanner;

import static java.lang.Math.pow;

public class no_2903 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();

        int n = 2;
        int result = 0;

        // 2 3 5 9 17

        // N = 1 -> n = 2 + 1
        // N = 2 -> n = 2 + 1 + 2
        // N = 3 -> n = 2 + 1 + 2 + 4
        // N = 4 -> n = 2 + 1 + 2 + 4 + 8

        for(int i = 1; i <= N; i++){
            n += pow(2, i - 1);
        }

        result = (2 * n - 1) + (n - 1) * (n - 1);

        System.out.println(result);
    }
}
