package day13.sub2;

public class Ex04 {
	public static void main(String[] args) {
		StringBuffer sb = new StringBuffer(500);
		sb.append("I love");
		System.out.println(System.identityHashCode(sb));
		
		sb.append(" java");
		System.out.println(System.identityHashCode(sb));
		
		sb.append(" ABC");
		System.out.println(System.identityHashCode(sb));
		
		String str = sb.toString();
		System.out.println(System.identityHashCode(str));
		System.out.println(str);
	}
}
