package test.mawujun.utils.http;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = HttpClientUtilsApplication.class,webEnvironment=WebEnvironment.RANDOM_PORT)
//@WebAppConfiguration
public class HttpClientutilsUtilsTest {
	@LocalServerPort
	private int port;
	@Test
    public void testHome() throws Exception {
     
    }
}
