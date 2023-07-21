package baekjoon.level6;

import java.util.Scanner;

public class no_2941 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String src [] = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};

        String st = scanner.nextLine();

        for(int i = 0; i < src.length; i++){
            if(st.contains(src[i]))
                st = st.replace(src[i], "!");
        }
        System.out.println(st.length());
    }
}
