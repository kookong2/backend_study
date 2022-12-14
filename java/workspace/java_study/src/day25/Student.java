package day25;

public class Student implements Comparable<Student>{
	private String name;
	private int classNo;
	private int totalScore;
	
	
	
	
	public Student(String name, int classNo, int totalScore) {
		
		this.name = name;
		this.classNo = classNo;
		this.totalScore = totalScore;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", classNo=" + classNo + ", totalScore=" + totalScore + "]";
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getClassNo() {
		return classNo;
	}
	public void setClassNo(int classNo) {
		this.classNo = classNo;
	}
	public int getTotalScore() {
		return totalScore;
	}
	public void setTotalScore(int totalScore) {
		this.totalScore = totalScore;
	}

	@Override
	public int compareTo(Student o) {
	
		
		return totalScore - o.getTotalScore(); 	// 오름차순
	}
	
	
}
