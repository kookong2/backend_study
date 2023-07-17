package baekjoon.level2;

import java.util.Scanner;

public class no_2525 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int H = scanner.nextInt();
        int M = scanner.nextInt();
        int ready = scanner.nextInt();

        if(M + ready >= 60){
            H = (H + (M + ready) / 60 ) % 24;
            M = (M + ready) % 60;
        }else
            M += ready;

        System.out.println( H + " " + M);
    }

}
