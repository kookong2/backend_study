package org.koreait.tests.admins;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;

@SpringBootTest
@AutoConfigureMockMvc
public class AdminPageTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("관리자 계정으로 / admin 정상 접속 여부")
    public void adminPageAccessTest1() throws Exception {

        mockMvc.perform(get("/admin"))
                .andDo(print())
                .andExpect(status().isOk());

    }
}
