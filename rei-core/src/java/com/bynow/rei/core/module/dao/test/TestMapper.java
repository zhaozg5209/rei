package com.bynow.rei.core.module.dao.test;

import com.bynow.rei.core.module.entity.test.Test;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TestMapper {
    List<Test> testSelect();
}
