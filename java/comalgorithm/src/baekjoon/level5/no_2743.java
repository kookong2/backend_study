package baekjoon.level5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class no_2743 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String str = reader.readLine();

        // String 클래스에 있는 length()를 이용
        System.out.println(str.length());
    }
}
