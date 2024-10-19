package by.baraznov.proxyserver;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/api")
public class ControllerTest {

    @ResponseBody
    @GetMapping("/sayHello")
    public String sayHello(){
        return "Hello world";
    }
}

