package infrastructure.inputadapter;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PricesAPI {

    @GetMapping("/helloWorld")
    public String HelloWorld() {
        return "Hello World";
    }
}
