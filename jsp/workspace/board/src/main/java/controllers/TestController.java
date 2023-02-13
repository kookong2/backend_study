package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class TestController {
	@GetMapping("/test")
	public String testUrl(Model model) {
		

			
		return "test";
	}
}
