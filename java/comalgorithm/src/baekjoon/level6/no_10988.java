package baekjoon.level6;

import java.util.Scanner;

public class no_10988 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String str = scanner.nextLine();
        int result = 1; // 기본값을 1로 설정 (팰린드롬인 경우)
        for (int i = 0; i < str.length() / 2; i++) {
            if (str.charAt(i) != str.charAt(str.length() - 1 - i)) {
                result = 0; // 팰린드롬이 아닌 경우 0으로 설정
                break; // 팰린드롬이 아니므로 더 이상 확인할 필요 없으므로 루프 종료
            }
        }

        System.out.println(result);
    }
}
