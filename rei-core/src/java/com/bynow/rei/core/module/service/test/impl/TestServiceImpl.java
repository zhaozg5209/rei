package com.bynow.rei.core.module.service.test.impl;

import com.bynow.rei.core.module.dao.test.TestMapper;
import com.bynow.rei.core.module.entity.test.Test;
import com.bynow.rei.core.module.service.test.TestService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TestServiceImpl implements TestService {

    @Resource
    private TestMapper mapper;

    @Override
    public List<Test> test() {
        return mapper.testSelect();
    }
}
