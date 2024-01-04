package com.lwx.serviceDriverUser.generator;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.Collections;

/**
 * 自动生成代码工具类
 */
public class MysqlGenerator {
    public static void main(String[] args) {

        FastAutoGenerator.create("jdbc:mysql://localhost:3306/service-driver-user?serverTimezone=UTC&useUnicode=true&characterEncoding=utf-8",
                "root","root")
                .globalConfig(builder -> {
                    builder.author("lwx").fileOverride().outputDir("D:\\online_taxi\\online_taxi\\service-driver-user\\src\\main\\java");
                })
                .packageConfig(builder -> {
                    builder.parent("com.lwx.serviceDriverUser").pathInfo(Collections.singletonMap(OutputFile.mapperXml,
                            "D:\\online_taxi\\online_taxi\\service-driver-user\\src\\main\\java\\com\\lwx\\serviceDriverUser\\mapper"));
                })
                .strategyConfig(builder -> {
                    builder.addInclude("driver_user_work_status");

                })
                .templateEngine(new FreemarkerTemplateEngine())
                .execute();
    }
}
