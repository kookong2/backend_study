package baekjoon.level3;

import java.io.*;
import java.util.StringTokenizer;

public class no_15552 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(reader.readLine());
        int sum = 0;

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(reader.readLine());
            writer.write((Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken())) + "\n");
        }
        writer.close();
    }
}
