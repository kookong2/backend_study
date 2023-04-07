package org.koreait;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;

@SpringBootTest
@AutoConfigureMockMvc
@TestPropertySource(locations="classpath:application-test.properties")
class Exam03ApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Test
	@DisplayName("컨트롤러 테스트")
	void contextLoads() throws Exception {
		String body = mockMvc.perform(get("/board/list"))
					.andDo(print())
					.andExpect(status().isOk())
					.andExpect(header().exists("Content-Type"))
					.andReturn()
					.getResponse()
					.getContentAsString();

		assertTrue(body.contains("목록"));
	}

	@Test
	@DisplayName("로그인 컨트롤러 테스트 - 로그인 계정이 다른 경우")
	public void loginTest() throws Exception {
		mockMvc.perform(post("/member/login")
						.param("userId", "user02")
						.param("userPw", "123456"))
				.andDo(print())
				.andExpect(status().isBadRequest());
	}

}
