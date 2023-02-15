package commons;

import java.util.Objects;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class CommonRequestWrapper extends HttpServletRequestWrapper {

	public CommonRequestWrapper(HttpServletRequest request) {
		super(request);

		String method = request.getMethod().toUpperCase();
		if (method.equals("POST")) {
			try {
				// POST일 때 한글깨짐 방지 처리
				request.setCharacterEncoding("UTF-8");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public Cookie[] getCookies() {

		Cookie[] cookies = super.getCookies();
		try {
			for (Cookie cookie : cookies) {
				String value;
				value = AES256.decrypt(cookie.getValue());
				cookie.setValue(value);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cookies;
	}

	/**
	 * 쿠키 개별 조회
	 * 
	 * @param name
	 * 
	 */
	public String getCookie(String name) {
		name = String.valueOf(Objects.hash(name));

		for (Cookie cookie : getCookies()) {
			if (cookie.getName().equals(name)) {
				return cookie.getValue();
			}
		}
		return null;
	}

}