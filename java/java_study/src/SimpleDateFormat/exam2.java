package SimpleDateFormat;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class exam2 {
    public static void main(String[] args) {
        String pattern = "yyyy/MM/dd";
        DateFormat df = new SimpleDateFormat(pattern);
        Scanner scanner = new Scanner(System.in);

        Date inDate = null;
        boolean isValidDate = false;

        System.out.println("날짜를 " + pattern + "의 형태로 입력해주세요.(입력예:2017/05/11)");
        while (!isValidDate){
            try {
                // parse는 문자열 source를 날짜Date 인스턴스로 변환
                inDate = df.parse(scanner.nextLine());
                isValidDate = true;
            } catch (Exception e) {
                System.out.println("날짜를 " + pattern + "의 형태로 입력해주세요.(입력예:2017/05/11)");
            }
        } // while

        if(inDate != null){
            Calendar cal = Calendar.getInstance();
            cal.setTime(inDate);
            SimpleDateFormat dayOfWeek = new SimpleDateFormat("E");
            String dayOfWeekStr = dayOfWeek.format(inDate);
            System.out.print("입력하신 날짜는 " + dayOfWeekStr + "요일입니다.");
        }

    }
}
