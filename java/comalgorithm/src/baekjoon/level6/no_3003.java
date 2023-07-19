package baekjoon.level6;

import java.util.Scanner;

public class no_3003 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] comp = {1, 1, 2, 2, 2, 8};
        int[] input = new int[6];

        for (int i = 0; i < comp.length; i++){
            input[i] = scanner.nextInt();
            System.out.print(comp[i] - input[i] + " ");
        }
    }
}
