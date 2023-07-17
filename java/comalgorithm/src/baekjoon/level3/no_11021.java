package baekjoon.level3;

import java.io.*;
import java.util.StringTokenizer;

public class no_11021 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(reader.readLine());

        for(int i = 1; i <= T; i++){
            st = new StringTokenizer(reader.readLine());

            writer.write("Case #" + i + ": " + (Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken())) + "\n");
        }
        writer.close();
    }
}


