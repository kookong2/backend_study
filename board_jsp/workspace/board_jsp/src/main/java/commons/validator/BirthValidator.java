package commons.validator;

import java.time.LocalDate;

import models.member.BirthValidationException;

public interface BirthValidator {
	/**
	
	 * 1. 년도가 4자리가 맞는지 체크 
	 * 2. 일자가 1일보다 크고, 31일보다 작은지 체크
	 * 3. 2월에는 28일까지만 존재하는지 체크  
	 */
	
	/**
	 *  * 1. 년도가 4자리가 맞는지 체크 
	 * @param yy
	 * @return
	 */
	default String checkBirthYY(String yy) {
		if(yy != null || !yy.isBlank()) {
			if(yy.length()!=4) {
				throw new BirthValidationException("년도를 4자로 입력해주세요.");
			}
		}
		return yy;
	}
	
	/**
	 * 
	 * 2. 일자가 1일보다 크고, 31일보다 작은지 체크
	 * 만약, 크다면 예외처리
	 * @param dd
	 * @return
	 */
	default String checkBirthDD(String mm,String dd) {
		String msg = "일자가 올바르지 않습니다. 다시 입력해주세요.";
		if (mm == null || dd == null) {
			throw new BirthValidationException(msg);
		}
		int month = Integer.parseInt(mm);
		int day = Integer.parseInt(dd);
		LocalDate date = LocalDate.now()
								.withMonth(month)
								.withDayOfMonth(1);
		
		LocalDate lastDate = date.plusMonths(1).minusDays(1);
		int lastDay = lastDate.getDayOfMonth();

		if (day < 1 || day > lastDay) {
			throw new BirthValidationException(msg);
		}
		
		return dd;
		
		/**
		if(dd!=null || !dd.isBlank()) {
		
			int Intdd=Integer.parseInt(dd);
			if(Intdd<1 || Intdd >31) {
				throw new BirthValidationException("일자가 올바르지 않습니다. 다시 입력해주세요.");
			}
			if(mm=="2" && Intdd>28) {
				Intdd=28;
			}
			dd=Integer.toString(Intdd);
		}
		return dd;
		*/
	}
}
