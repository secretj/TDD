package test.tdd.controller;


import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)	/*JUnit에 내장된 실행자 외에 다른 실행자를 실행시킨다.
 								여기선 SpringRunner를 실행
 								즉, 스프링 부트 테스트와 JUnit사이의 연결자 역할*/
@WebMvcTest(controllers = HelloController.class)
 												
public class HelloControllerTest {

    @Autowired
    private MockMvc mvc;  // 웹 API를 테스트할 때 사용 HTTP METHOD에 대해 API 테스트할 수 있음

    @Test
    public void hello_return() throws Exception {
        String hello = "hello";

        mvc.perform(get("/hello"))					//   /hello 주소로 GET 요청
                .andExpect(status().isOk())			// 	HTTP Header의 Status를 검증
                .andExpect(content().string(hello));// 응답 본문의 내용을 검증, hello가 리턴되는 지
    }
}