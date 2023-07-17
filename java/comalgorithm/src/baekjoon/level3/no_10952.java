package baekjoon.level3;

import java.io.*;
import java.util.StringTokenizer;

public class no_10952 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        String str;

        int a = 1, b = 1;

        for(int i = 0; (str = reader.readLine()) != null; i++){

            st = new StringTokenizer(reader.readLine());

            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());

            if(a == 0 && b == 0) {
                break;
            }

            writer.write((a + b) + "\n");
        }
        writer.close();
    }
}
