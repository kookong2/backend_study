package baekjoon.level5;

import java.util.Scanner;

public class no_1152 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String s = scanner.nextLine();

        // 앞 뒤 공백 제거
        s = s.trim();

        // 공백이 있을 때마다 단어 개수 추가
        String[] words = s.split(" ");
        int count = 0;

        // 공백만 있을 경우 제외하기
        for(String word : words){
            if(!word.isEmpty()){
                count++;
            }
        }

        System.out.println(count);
    }
}
