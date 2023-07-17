package baekjoon.level4;

import java.util.Scanner;

public class no_10811 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int M = scanner.nextInt();

        int[] arr = new int[N];

        // 바구니 번호 부여
        for(int i = 0; i < arr.length; i++){
            arr[i] = i + 1;
        }

        for(int i = 0; i < M; i++){
            int I = scanner.nextInt();
            int J = scanner.nextInt();

            // 역순으로 바꾸기
            for(int j = I - 1, k = J - 1; j < k; j++, k--){
                int tmp = arr[j];
                arr[j] = arr[k];
                arr[k] = tmp;
            }
        }

        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }
    }
}
