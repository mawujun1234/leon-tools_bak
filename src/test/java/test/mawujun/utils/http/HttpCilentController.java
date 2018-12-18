package test.mawujun.utils.http;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HttpCilentController {
	@RequestMapping("/")
    String home() {
        return "Hello World!";
    }
}
