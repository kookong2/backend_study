package homework;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class MeetingRoomAssignment {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		// 맨 처음 회의실 N개를 scanner로 입력받음
		int N = scanner.nextInt();
		
		ArrayList<Task> L = new ArrayList<>();
		
		int i = 0;
		
		// 회의실 개수만큼 시작시간과 끝난시간에 scanner를 통해 ArrayList L 에 입력해줌
		while(i < N) {
			int s = scanner.nextInt();
			int e = scanner.nextInt();
			Task task = new Task(s, e);
			L.add(task);
			i++;
		}
		System.out.println(L);
		
		// 끝난시간 순으로 정렬했다. 끝난시간이 서로 같을 때, 시작시간이 먼저인 순으로
		// 짜져야 하는데, 다행이 시작시간이 먼저인 순서대로 정렬해준다.
		L.sort(Comparator.comparingInt(o -> o.e));
		System.out.println("끝난 시간에 따라 정렬중...");
		System.out.println(L);
		System.out.println("가장 많이 회의 할 수 있는 시간대");
		
		// 회의 가능한 회의 개수
		int count = 0;
		// 맨 처음 시작할 끝난시간
		int end_time = 0;
		
		// 가장 빠른 끝난시간(end_time)부터 시작해서 그 다음으로 빠른 끝난 시간대(e)
		// 의 시작 시간(s)을 비교하고, (end_time < s)일 경우 end_time에 e 가 들어가고
		// count ++
		for(Task task : L) {
			if(end_time <= task.s) {
				// 만들어진 회의 개수만 출력하면 심심하니까
				// 만들어진 회의도 출력하도록 함
				System.out.print(task);
				end_time = task.e;
				count++;
			}
		}
		
		// 짜잔
		System.out.printf("\n만들어지는 회의 개수는 %d 개\n",count);
		
		
	}
}

// 시작 시간과 끝난 시간, 2개의 인자를 갖는 외부 클래스 만듦
class Task{
	int id;
	int s;	// 시작 시간
	int e;	// 끝난 시간
	static int x = 0;
	
	public Task(int s, int e) {
		this.id = x++;
		this.s = s;
		this.e = e;
	}
	
	@Override
    public String toString() {
        return String.format(" #%d(%d, %d)", id, s, e);
    }
	
}
