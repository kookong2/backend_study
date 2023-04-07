package org.koreait.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloController {
	
	@GetMapping("/hello")
	public String hello(@RequestParam(name="nm", required=false, defaultValue="이름...") String name, Model model) {
		
		// Model 파라미터는 컨트롤러의 처리 결과를 뷰에 전달할 때 사용
		// "name"이라는 모델 속성에 값을 설정. name 파라미터의 값을 연결한 문자열을 값으로 설정.
		
		// 파라미터로 전달받은 Model 객체의 addAttribute()메서드는 뷰에 전달할 데이터를 지정하기 위해 사용
		// addAttribute()메서드의 첫 번째 파라미터는 데이터를 식별하는 데 사용되는 속성 이름,
		//		두 번째 파라미터는 속성 이름에 해당하는 값.
		//		-> 뷰 코드는 이 속성의 이름을 사용해서 컨트롤러가 전달한 데이터에 접근
		model.addAttribute("name", name);
		
		// 컨트롤러의 처리 결과를 보여줄 뷰 이름으로 "hello"를 사용
		return "hello";
	}
}
