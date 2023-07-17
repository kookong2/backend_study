package week12;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Vector;

public class BacktrackTSP {

    // 초기화한 bestSolution을 사용하기 위해 전역 변수로 사용
    static int bestSolution;

    static Vector<Character> bestPath;
    static Vector<Character> tour;
    public static void main(String[] args) {
        int[][] adjMat = {
                {0, 2, 7, 3, 10},
                {2, 0, 3, 5, 4},
                {7, 3, 0, 6, 1},
                {3, 5, 6, 0, 9},
                {10, 4, 1, 9 , 0},
        };

        tour = new Vector<>();
        tour.add('A');
        bestSolution = Integer.MAX_VALUE;
        bestPath = new Vector<Character>();
        System.out.println(back(adjMat, tour));

        Vector<Character> dummy = new Vector<>();
        dummy.add('A');
        dummy.add('B');
        dummy.add('C');
        dummy.add('E');
        dummy.add('D');

        System.out.println(isSun(dummy));
        System.out.println(compute(dummy, adjMat));
    }

    private static Vector<Character> back(int[][] adjMat, Vector<Character> tour) {
        System.out.println(tour);
        HashSet<Character> set = new HashSet<>();
        for(int i = 0; i < 5; i++) set.add((char)('A' + i ));
        if(isSun(tour)){
            //dummy.add('A');
            int totalCost = compute(tour, adjMat);
            if(totalCost < bestSolution){
                bestSolution = totalCost;
                // 경로를 저장하는 변수에 삽입
                bestPath = new Vector<>(tour);
            }
            tour.remove(tour.size() - 1);

        }else {
            Vector<Character> newTour = new Vector<>(tour);
            HashSet<Character> remainingVertices = find(set, newTour);

            for (Character v : remainingVertices) {
                Vector<Character> temp = new Vector<>(newTour);
                temp.add(v);
                if (compute(temp, adjMat) < bestSolution) {
                    back(adjMat, temp);
                }
            }
        }

        return bestPath;
    }

    private static HashSet<Character> find(HashSet<Character> set, Vector<Character> newTour){
        set.removeAll(newTour);
        return set;
    }

    private static int compute(Vector<Character> tour, int[][] adjMat) {
        int cost = 0;
        for (int i = 0; i < tour.size() - 1; i++) {
            char x = tour.get(i);
            char y = tour.get(i + 1);
            cost += adjMat[x - 'A'][y - 'A'];
        }

        return cost;
    }

    private static boolean isSun(Vector<Character> tour){

        HashSet<Character> set = new HashSet<>(tour);

        if(tour.size() != 5) return false;
        if(set.size() != 5) return false;

        return true;
    }
}
