package com.bynow.rei.system;

import com.bynow.rei.modular.system.dao.UserMapper;
import com.bynow.rei.base.BaseJunit;
import com.bynow.rei.modular.system.dao.UserMapper;
import org.junit.Test;

import javax.annotation.Resource;

/**
 * 用户测试
 *
 * @author fengshuonan
 * @date 2017-04-27 17:05
 */
public class UserTest extends BaseJunit {

    @Resource
    UserMapper userMapper;

    @Test
    public void userTest() throws Exception {

    }

}
