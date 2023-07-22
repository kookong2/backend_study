package baekjoon.level8;

import java.util.Scanner;

public class no_2720 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();

        for(int i = 0; i < N; i++){
            int c = scanner.nextInt();

            int quarter = c / 25;
            c %= 25;

            int dime = c / 10;
            c %= 10;

            int nickel = c / 5;
            c %= 5;

            int penny = c;

            System.out.println(quarter + " " + dime + " " + nickel + " " + penny);
        }
    }
}
