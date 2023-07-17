package baekjoon.level4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class no_10807 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(reader.readLine());

        ArrayList<Integer> arr = new ArrayList<>();

        String[] inputs = reader.readLine().split(" ");

        for(int i = 0; i < N; i++){
            arr.add(Integer.parseInt(inputs[i]));
        }

        int v = Integer.parseInt(reader.readLine());
        int count = Collections.frequency(arr, v);
        System.out.println(count);
    }
}
