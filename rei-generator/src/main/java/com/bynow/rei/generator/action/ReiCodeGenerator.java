package com.bynow.rei.generator.action;


import com.bynow.rei.generator.action.config.ReiGeneratorConfig;

/**
 * 代码生成器,可以生成实体,dao,service,controller,html,js
 *
 * @author bynow
 * @Date 2017/5/21 12:38
 */
public class ReiCodeGenerator {

    public static void main(String[] args) {

        /**
         * Mybatis-Plus的代码生成器:
         *      mp的代码生成器可以生成实体,mapper,mapper对应的xml,service
         */
        ReiGeneratorConfig reiGeneratorConfig = new ReiGeneratorConfig();
        reiGeneratorConfig.doMpGeneration();

        /**
         * rei的生成器:
         *      rei的代码生成器可以生成controller,html页面,页面对应的js
         */
        reiGeneratorConfig.doreiGeneration();
    }

}