package DateTimeFormat;

import java.util.Calendar;

public class Calendar5 {
    public static void main(String[] args) {
        if(args.length != 2){
            System.out.println("Usage : Calendar5 2019 9");
            return;
        }

        int year = Integer.parseInt(args[0]);
        int month = Integer.parseInt(args[1]);
        int START_DAY_OF_WEEK = 0;
        int END_DAY = 0;

        Calendar sDay = Calendar.getInstance(); //시작일
        Calendar eDay = Calendar.getInstance(); // 끝일

        // 월의 경우 0 부터 11까지의 값을 가지므로 1을 빼 주어야 한다.
        // 예를들어, 2019년 11월 1일은 sDay.set(2019, 10, 1); 과 같이 해 주어야 한다.
        sDay.set(year, month -1, 1);
        eDay.set(year, month, 1);

        // 다음 날의 첫 날(12월 1일)에서 하루를 빼면 현재 달의 마지막 날(11월 30일)이 된다.
        eDay.add(Calendar.DATE, -1);

        // 첫 번째 요일이 무슨 요일인지 알아낸다.
        START_DAY_OF_WEEK = sDay.get(Calendar.DAY_OF_WEEK);

        // eDay에 지정된 날씨를 얻어온다.
        END_DAY = eDay.get(Calendar.DATE);

        System.out.println("      " + args[0] + "년 " + args[1] + "월");
        System.out.println(" SU MO TU WE TH FR SA");

        // 해당 월의 1일이 어느 요일인지에 따라서 공백을 출력한다.
        // 만일 1일이 수요일이라면 공백을 세 번 찍는다(일요일 부터 시작)
        for(int i = 1; i < START_DAY_OF_WEEK; i++){
            System.out.println("   ");
        }

        for (int i = 1, n = START_DAY_OF_WEEK; i <= END_DAY; i++, n++){
            System.out.println((i < 10) ? "  " + i : " " + i);
            if(n % 7 == 0)
                System.out.println();
        }
    }
}
