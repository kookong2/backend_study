package week13;

import java.util.*;

public class GeneticAlgorithm {
    public static void main(String[] args) {

        int[] x = {1, 29, 3, 10};

        for(int i = 0; i < 10000; i++){
            // evaluation
            int[] f = fit(x);
            // selection
            int[] sx= select(x, f);
            // crossover
            int[] ngx = crossover(sx);
            // mutation
            x = mutate(ngx);
        }

        int max = fit(x[0]);
        int y = x[0];
        for(int i = 1; i < x.length; i++){
            if(max < fit(x[i])) {
                max = fit(x[i]);
                y = x[i];
            }
        }

        System.out.printf("%d => %d\n",y , max);
    }

    private static int[] mutate(int[] ngx) {
        // 각각의 후보해들 => 돌연변이화
        int[] x = ngx.clone();
        Random random = new Random();
        for(int i = 0; i < ngx.length; i++){
            if(random.nextFloat() < 0.1f){
                String tmp = String.format("%5s", Integer.toBinaryString(ngx[i]))
                        .replaceAll(" ","0");
                int index = random.nextInt(tmp.length());

                char[] binary = tmp.toCharArray();
                binary[i] = (binary[i] == '0') ? '1' : '0';
                x[i] = Integer.parseInt(new String(binary), 2);
            }
        }
        return x;
    }

    private static int[] crossover(int[] sx) {
        LinkedList<Integer> queue = new LinkedList<>();
        ArrayList<Integer> tmp = new ArrayList<>();
        for(int i = 0; i < sx.length; i++) queue.add(sx[i]);

        while(!queue.isEmpty()) {
            // 2개의 인자 빼서
            int a = queue.remove();
            int b = queue.remove();

            // 각각 2진수 숫자의 문자열로 만들고
            String sa = String.format("%5s\n", Integer.toBinaryString(a)).replaceAll(" ", "0");;
            String sb = String.format("%5s\n", Integer.toBinaryString(b)).replaceAll(" ", "0");;

            // 크로스 해서 인자를 엮음
            String ca = sa.substring(0, 2) + sb.substring(2, 5);
            String cb = sb.substring(0, 2) + sa.substring(2, 5);

            // 엮어진 문자열을 다시 정수형 문자로 바꿈
            tmp.add(Integer.parseInt(ca, 2));
            tmp.add(Integer.parseInt(cb, 2));
        }

        int[] cx = new int[sx.length];
        for(int i = 0; i < tmp.size(); i++) cx[i] = tmp.get(i);

        return cx;
    }

    private static int[] select(int[] x, int[] f) {
        int[] sx = new int[x.length];

        int[] cumulative = new int[x.length];
        int c = 0;
        for(int i = 0; i < x.length; i++) {
            c += f[i];
            cumulative[i] = c;
        }
        Random r = new Random();
        for(int i  = 0; i < x.length; i++) {
            int tmp = r.nextInt(c);
            for(int j = 0; j < 4; j++) {
                if(tmp - cumulative[j] < 0) {
                    sx[i] = x[j];
                    //System.out.println(sx[i]);
                    break;
                }
            }
        }
        return sx;
    }

    public static int fit(int x){
        return -x * x + 38 * x + 80;
    }
    public static int[] fit(int[]x){
        int[] f = new int[x.length];
        for(int i = 0; i < x.length; i++){
            f[i] = fit(x[i]);
        }
        return f;
    }
}
