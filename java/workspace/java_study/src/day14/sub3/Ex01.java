package day14.sub3;

import java.text.DecimalFormat;

public class Ex01 {
	public static void main(String[] args) {
		
		//String pattern = "0,000.0000000";
		//String pattern = "#,###.#######";	// 자릿수가 있으면 채우고 없으면 채우지 않음
		String pattern = "0000";
		
		DecimalFormat df = new DecimalFormat(pattern);
		
		//long num = 1000000000L;
		//double num = 1234.56789;
		long num = 20;
		
		String strNum1 = df.format(num);
		System.out.println(strNum1);
	}
}
