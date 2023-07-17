package baekjoon.level4;

import java.util.HashSet;
import java.util.Scanner;

public class no_3052 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        HashSet<Integer> hashSet = new HashSet<>();
        int count = 0;

        for(int i = 0; i < 10; i++){
            hashSet.add(scanner.nextInt() % 42);
            // 입력받은 값의 나머지 값을 add메서드를 통해 HashSet에 저장
        }

        System.out.print(hashSet.size());
    }
}
