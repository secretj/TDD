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

@RunWith(SpringRunner.class)	/*JUnit�� ����� ������ �ܿ� �ٸ� �����ڸ� �����Ų��.
 								���⼱ SpringRunner�� ����
 								��, ������ ��Ʈ �׽�Ʈ�� JUnit������ ������ ����*/
@WebMvcTest(controllers = HelloController.class)
 												
public class HelloControllerTest {

    @Autowired
    private MockMvc mvc;  // �� API�� �׽�Ʈ�� �� ��� HTTP METHOD�� ���� API �׽�Ʈ�� �� ����

    @Test
    public void hello_return() throws Exception {
        String hello = "hello";

        mvc.perform(get("/hello"))					//   /hello �ּҷ� GET ��û
                .andExpect(status().isOk())			// 	HTTP Header�� Status�� ����
                .andExpect(content().string(hello));// ���� ������ ������ ����, hello�� ���ϵǴ� ��
    }
}