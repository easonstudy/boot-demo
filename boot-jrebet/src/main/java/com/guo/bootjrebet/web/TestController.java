package com.guo.bootjrebet.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/api")
public class TestController {

    @GetMapping("/m1")
    public String m1() {
        return "aa";
    }

    @GetMapping("/m2")
    public String m2() {
        return "ee";
    }
}
