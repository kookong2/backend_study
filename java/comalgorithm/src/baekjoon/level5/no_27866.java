package baekjoon.level5;

import java.util.Scanner;

public class no_27866 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] str = scanner.next().split("");
        int a = scanner.nextInt();

        System.out.println(str[a - 1]);
    }
}
