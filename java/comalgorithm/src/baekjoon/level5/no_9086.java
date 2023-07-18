package baekjoon.level5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class no_9086 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < n; i++){
            String str = reader.readLine();
            sb.append(str.charAt(0));
            sb.append(str.charAt(str.length() - 1) + "\n");
        }
        System.out.print(sb);
    }
}
