package baekjoon.level3;

import java.util.Scanner;

public class no_25314 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        for(int i = 0; i < n / 4; i++){
            System.out.print("long ");
        }
        System.out.print("int");
    }
}
