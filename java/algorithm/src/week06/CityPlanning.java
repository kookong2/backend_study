package week06;

import java.util.*;

public class CityPlanning {
	public static void main(String[] args) {
        HashSet<Integer> u = new HashSet<Integer>();
        for(int i = 0; i < 10; i++) {
            u.add((i + 1));
        }
        ArrayList<MySet<Integer>> f = new ArrayList<>();

        f.add(new MySet<>(1, 2, 3, 8)); f.add(new MySet<>(1, 2, 3, 4, 8));
        f.add(new MySet<>(1, 2, 3, 4)); f.add(new MySet<>(2, 3, 4, 5, 7, 8));
        f.add(new MySet<>(4, 5, 6, 7)); f.add(new MySet<>(5, 6, 7, 9, 10));
        f.add(new MySet<>(4, 5, 6, 7)); f.add(new MySet<>(1, 2, 4, 8));
        f.add(new MySet<>(6, 9)); f.add(new MySet<>(6, 10));

        ArrayList<MySet<Integer>> c = new ArrayList<>();
        while(!u.isEmpty()){
            MySet<Integer> s = func(u, f); // u의 원소르 가장 많이 포함하는 f의 원소(s_i) 찾기
            /**
            s.forEach(u::remove);
            for(Integer q : u) {
            	u.remove(q);
            }
            */
            
            u.removeAll(s); //updating U
            f.remove(s);
            c.add(s);
        }

        System.out.println(c);

    }

    private static int func2(HashSet<Integer> u, MySet<Integer> s) {
        int n = 0;
        for(int i : s) {
            if(u.contains(i)) {
                n += 1;
            }
        }
        return n;
    }
    private static MySet<Integer> func(HashSet<Integer> u, ArrayList<MySet<Integer>> f) {
        int max = 0;
        MySet y = null;

        int k = 0;
        for (MySet x : f) {
            int i = func2(u, x);
            if (max < i) {
                max = i;
                y = x;
            }
        }

        return y;
    }
}

//Lombok

class MySet<E> extends ArrayList<E> {
    @SafeVarargs
    public MySet(E... vector) {
        addAll(Arrays.asList(vector));
    }

}