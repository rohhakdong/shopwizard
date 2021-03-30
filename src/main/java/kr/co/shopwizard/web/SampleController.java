package kr.co.shopwizard.web;

import kr.co.shopwizard.web.dto.SampleResponseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleController {
    @GetMapping("/hello")
    public String hello() {
        return "Hello World";
    }

    @GetMapping("/hello/dto")
    public SampleResponseDto helloDto(@RequestParam("name") String name, @RequestParam("amount") int amount) {
        return new SampleResponseDto(name, amount);
    }
}
