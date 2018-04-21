package com.bynow.rei.generator.action;


import com.bynow.rei.generator.action.config.ReiGeneratorConfig;

/**
 * 代码生成器,可以生成实体,dao,service,controller,html,js
 *
 * @author stylefeng
 * @Date 2017/5/21 12:38
 */
public class ReiCodeGenerator {

    public static void main(String[] args) {

        /**
         * Mybatis-Plus的代码生成器:
         *      mp的代码生成器可以生成实体,mapper,mapper对应的xml,service
         */
        ReiGeneratorConfig gunsGeneratorConfig = new ReiGeneratorConfig();
        gunsGeneratorConfig.doMpGeneration();

        /**
         * guns的生成器:
         *      guns的代码生成器可以生成controller,html页面,页面对应的js
         */
        gunsGeneratorConfig.doGunsGeneration();
    }

}