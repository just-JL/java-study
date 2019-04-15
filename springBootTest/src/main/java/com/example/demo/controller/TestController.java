package com.example.demo.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author:jiliang
 * @Date:2019/3/22
 * @Time:9:13
 */
@RestController
@RequestMapping("control")
public class TestController {
    @RequestMapping("/test")
    public String test(){
        System.out.println("hi");
        return "hi";
    }
}
