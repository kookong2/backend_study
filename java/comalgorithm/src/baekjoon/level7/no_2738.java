package baekjoon.level7;

import java.util.Scanner;

public class no_2738 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int M = scanner.nextInt();

        int[][] arr = new int[N][M];

        for(int i = 0; i < 2; i++){
            for(int j = 0; j < N; j++){
                for(int k = 0; k < M; k++){
                    arr[j][k] += scanner.nextInt();
                }
            }
        }

        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
