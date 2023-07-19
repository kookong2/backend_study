package baekjoon.level5;

import java.util.Scanner;

public class no_2675 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int T = scanner.nextInt();

        for(int i = 0; i < T; i++){
            int R = scanner.nextInt();
            String s = scanner.next();

            for(int j = 0; j < s.length(); j++){
                for(int k = 0; k < R; k++){
                    System.out.print(String.valueOf(s.charAt(j)));
                }
            }
            System.out.println();
        }
    }
}
