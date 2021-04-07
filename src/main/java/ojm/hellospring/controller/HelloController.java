package ojm.hellospring.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("hello")
    public String hello(Model model){
        System.out.println("ㅎㅎㅎㅎ");
        model.addAttribute("data","hello~~~~~~~!!");
        return "hellogg";
    }
}
