package day15;

import java.text.*;

public class Ex02 {
	public static void main(String[] args) {
		
//		double[] limits = {60, 70, 80, 90};
//		String[] patterns = {"D", "C", "B", "A"};
//		
//		int[] scores = { 100, 95, 92, 88, 50, 62};
//		ChoiceFormat cf = new ChoiceFormat(limits, patterns);
		
		String patterns = "60#D|70#C|80#B|90#A";
		
		int[] scores = { 100, 95, 92, 88, 50, 62};
		ChoiceFormat cf = new ChoiceFormat(patterns);
		
		for(int score:scores) {
			String grade = cf.format(score);
			System.out.println(score + " : " + grade);
		}
	}
}
