package baekjoon.level6;

import java.util.Scanner;

public class no_25206 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 학점 * 과목평점
        double aa = 0;
        // 총 학점
        double point = 0;

        for(int i = 0; i < 20; i ++){
            // 과목 이름
            String title = scanner.next();
            // 학점
            double grade = scanner.nextDouble();
            // 평점
            String a_grade = scanner.next();

            if(a_grade.equals("A+")){
                aa += grade * 4.5;
                point += grade;
            } else if (a_grade.equals("A0")) {
                aa += grade * 4.0;
                point += grade;
            } else if (a_grade.equals("B+")) {
                aa += grade * 3.5;
                point += grade;
            } else if (a_grade.equals("B0")) {
                aa += grade * 3.0;
                point += grade;
            } else if (a_grade.equals("C+")) {
                aa += grade * 2.5;
                point += grade;
            } else if (a_grade.equals("C0")) {
                aa += grade * 2.0;
                point += grade;
            } else if (a_grade.equals("D+")) {
                aa += grade * 1.5;
                point += grade;
            } else if (a_grade.equals("D0")) {
                aa += grade * 1.0;
                point += grade;
            } else if (a_grade.equals("F")) {
                aa += grade * 0.0;
                point += grade;
            }
        }
        System.out.printf("%.6f", aa / point);
    }
}
