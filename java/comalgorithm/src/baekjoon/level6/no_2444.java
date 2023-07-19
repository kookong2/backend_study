package baekjoon.level6;

import java.util.Scanner;

public class no_2444 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();

        for(int i = 1; i <= N ; i++) {
            for(int j = 0; j < N-i; j++)
                System.out.print(" ");
            for(int j = 0; j < i*2-1; j++)
                System.out.print("*");
            System.out.println();
        }

        for(int i = N - 1; i >= 0; i--){
            for (int j = 0; j < N - i; j++){
                System.out.print(" ");
            }
            for(int j = 0; j < 2 * i - 1; j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
