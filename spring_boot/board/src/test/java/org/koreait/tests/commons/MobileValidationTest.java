package org.koreait.tests.commons;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.koreait.commons.validators.MobileValidator;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class MobileValidationTest {

    private MobileValidator validator;

    @BeforeEach
    public void init() {
        validator = new MobileValidator() {};
    }
    @Test
    @DisplayName("휴대전화번호 검증 테스트 - 맞는 번호")
    public void mobileNumTest() {
        String mobile = "010-1234-1234";

        assertEquals(true, validator.checkMobile(mobile));
    }

    @Test
    @DisplayName("휴대전화번호 검증 테스트 - 맞지 않는 번호")
    public void mobileNumTest2() {
        String[] mobiles = { "0010-1234-123400", "101234-1234", "1234-1234" };
        for (String mobile : mobiles) {
            assertEquals(false, validator.checkMobile(mobile));
        }

    }
}
