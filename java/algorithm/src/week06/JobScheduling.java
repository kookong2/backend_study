package week06;

import java.util.ArrayList;
import java.util.Comparator;

public class JobScheduling {
    public static void main(String[] args) {
        // 1. 문제 정의 (데이터 생성) -> 클래스 구현
        ArrayList<Task> L = new ArrayList<>();
        L.add(new Task(7, 8));
        L.add(new Task(3, 7));
        L.add(new Task(1, 5));
        L.add(new Task(5, 9));
        L.add(new Task(0, 2));
        L.add(new Task(6, 8));
        L.add(new Task(1, 6));
        System.out.println(L);

        // 2. 정렬
        L.sort(Comparator.comparingInt(o -> o.s));

        ArrayList<Machine> M = new ArrayList<>();

        System.out.println("시간시간에 따라 정렬중..");
        System.out.println(L);

        // 3. while
        while (!L.isEmpty()) {
            Task t = L.remove(0);

            Machine m = findAvailableMachine(t, M);
            if (m == null) {
                m = new Machine();
                M.add(m);
            }
            m.e = t.e;
            m.tasks.add(t);
        }

        System.out.println(M);
    }

    private static Machine findAvailableMachine(Task t, ArrayList<Machine> m) {
        for (Machine machine : m) {
            if (machine.e <= t.s) {
                return machine;
            }
        }
        return null;
    }
}

class Task {
    int id;
    int s; // 시작 시간
    int e; // 끝나는 시간
    static int x = 0;

    @Override
    public String toString() {
        return String.format("#%d (%d, %d)", id, s, e);
    }

    public Task(int s, int e) {
        this.id = x++;
        this.s = s;
        this.e = e;
    }
}

class Machine {
    int id; // 기계번호
    int e; // 끝나는 시간
    ArrayList<Task> tasks;

    public Machine() {
        this.id = id;
        this.e = 0;
        tasks = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "Machine{" +
                "id=" + id +
                ", e=" + e +
                ", tasks=" + tasks +
                '}';
    }
}