package baekjoon.level3;

import java.io.*;

public class no_2438 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(reader.readLine());

        for(int i = n; i >= 1; i--){
            for(int j = i - 1; j > 0; j--){
                writer.write(" ");
            }
            for(int j = 0; j < (n + 1) - i; j++)
                writer.write("*");
            writer.write("\n");
        }
        writer.close();
    }
}



