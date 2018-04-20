package com.bynow.rei.admin.module.test;

import com.bynow.rei.core.module.service.test.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private TestService testService;

    @RequestMapping("/test")
    public Map<String,Object> test()  {

        Map<String,Object> map = new HashMap<>();
        map.put("map", testService.test());
        return  map;
    }
}
