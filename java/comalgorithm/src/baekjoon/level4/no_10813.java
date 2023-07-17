package baekjoon.level4;

import java.util.Scanner;

public class no_10813 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int M = scanner.nextInt();

        int [] arr = new int [N];

        for(int i = 0; i < N; i++){
            arr[i] = i + 1;
        }

        for(int i = 0; i < M; i++){
            int I = scanner.nextInt();
            int J = scanner.nextInt();

            int tmp = arr[I - 1];
            arr[I - 1] = arr[J - 1];
            arr[I - 1] = tmp;
        }

        for(int i = 0; i < N; i++){
            System.out.print(arr[i] + " ");
        }
    }
}
