package com.example.learnmybatis.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/test")
public class FirstController {

    @RequestMapping("/xxx")
    public Map<String,Object> checkVersion() {

        Map<String,Object> result = new HashMap<String,Object>();
        result.put("statusCode", 300);
        result.put("errorMsg", "错误信息");
        result.put("data", "xxxxxx");
        return result;
    }

}
