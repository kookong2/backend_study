package SimpleDateFormat;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class exam1 {
    public static void main(String[] args) {
        int year = 2020;

        for (int month = 1; month <= 12; month++) {
            Calendar calendar = Calendar.getInstance();
            // 날짜 초기화
            calendar.set(year, month - 1, 1);

            int count = 0;
            while (count < 2) {
                // 2번째 일요일이 될 경우 count를 ++
                if (calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
                    count++;
                    // 2번째 일요일 날짜 출력
                    if (count == 2) {
                        Date secondSunday = calendar.getTime();
                        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                        String formattedDate = dateFormat.format(secondSunday);
                        System.out.println(month + "월 두 번째 일요일: " + formattedDate);
                    }
                }
                // 다음 달로 넘어감
                calendar.add(Calendar.DAY_OF_MONTH, 1);
            }
        }
    }
}
