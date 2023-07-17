package baekjoon.level4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class no_1546 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(reader.readLine());

        double arr[] = new double[N];
        String[] inputs = reader.readLine().split(" ");

        for(int i = 0; i < N; i++){
            arr[i] = Double.parseDouble(inputs[i]);
        }

        Arrays.sort(arr);
        double max = arr[arr.length - 1];
        double sum = 0;

        for(int i = 0; i < N; i++){
            arr[i] = arr[i] / max * 100;
            sum += arr[i];
        }

        double average = sum / N;
        System.out.println(average);
    }
}
