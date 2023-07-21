package baekjoon.level6;

import java.util.HashSet;
import java.util.Scanner;

public class no_1316 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int count = 0; // 그룹 단어 개수

        for (int i = 0; i < N; i++) {
            String s = scanner.next();
            HashSet<Character> check = new HashSet<>(); // 중복되는 문자 검사용 HashSet
            boolean tmp = true; // 그룹 단어인지에 대한 여부

            for (int j = 0; j < s.length(); j++) {
                char currentChar = s.charAt(j);
                if (check.contains(currentChar)) { // 이전에 사용한 적 있는 문자라면
                    if (currentChar != s.charAt(j - 1)) { // 이전 문자와 연속하지 않는다면
                        tmp = false;
                        break;
                    }
                } else { // 이전에 사용한 적 없는 문자라면
                    check.add(currentChar);
                }
            }

            if (tmp) // tmp값이 true일 경우
                count++; // 그룹 단어 개수 ++
        }

        System.out.println(count);
    }
}
