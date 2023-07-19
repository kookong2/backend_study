package baekjoon.level6;

import java.util.Scanner;

public class no_1157 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 모든 문자 대문자로 변환
        String str = scanner.next().toUpperCase();

        // 26개의 알파벳 배열 할당
        int[] arr = new int[26];

        for(int i = 0; i < str.length(); i++){
            // 만약 A일 경우 A - A = 0이므로 arr[0]에 저장후 개수++
            arr[str.charAt(i) - 'A']++;
        }

        int max = 0;
        char answer = '?';
        // 26개의 알파벳 배열 순회하면서 최대 개수 세기
        for(int i = 0; i < arr.length; i++){
            if(max < arr[i]){
                max = arr[i];
                // 다시 A를 더해주면서 A ~ Z출력할 수 있도록 함
                answer = (char)(i + 'A');
            } else if(max == arr[i]){       // 순회했는데 max값이 중복될 경우
                answer = '?';
            }
        }
        System.out.println(answer);
    }
}
