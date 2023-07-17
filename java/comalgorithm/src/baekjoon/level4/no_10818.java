package baekjoon.level4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class no_10818 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(reader.readLine());

        ArrayList<Integer> arr = new ArrayList<>();
        String[] inputs = reader.readLine().split(" ");

        for(int i = 0; i < N; i++){
            arr.add(Integer.parseInt(inputs[i]));
        }

        Collections.sort(arr);

        System.out.println(arr.get(0) + " " + arr.get(arr.size() - 1));
    }
}
