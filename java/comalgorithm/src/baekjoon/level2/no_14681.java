package baekjoon.level2;

import java.util.Scanner;

public class no_14681 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double x = scanner.nextDouble();
        double y = scanner.nextDouble();

        if(x > 0 && y > 0){
            System.out.println("1");
        } else if (x > 0 && y < 0) {
            System.out.println("4");
        } else if (x < 0 && y > 0) {
            System.out.println("2");
        } else
            System.out.println("3");
    }
}
