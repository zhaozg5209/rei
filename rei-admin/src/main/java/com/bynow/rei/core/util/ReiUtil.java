package com.bynow.rei.core.util;

import com.bynow.rei.core.shiro.ShiroKit;
import com.bynow.rei.modular.system.model.User;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author: bynow
 * @Description:
 * @Date: created in 10:46 2018/5/24
 */
public class ReiUtil {

    public static ReiUtil getInstance(){   return new ReiUtil();}

    //判断用户是否具有管理员角色
    public boolean checkUserIsAdmin(){
        List<Integer> list = ShiroKit.getUser().getRoleList();
        for (Integer id : list){
            if (id.toString().equals("1"))
                return true;
        }
        return false;
    }

    //当前登陆用户id
    public Integer getCurrentUserId(){
        return ShiroKit.getUser().getId();
    }

}
