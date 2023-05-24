package com.roozen.alcss;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.config.converts.MySqlTypeConvert;
import com.baomidou.mybatisplus.generator.config.querys.MySqlQuery;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import com.baomidou.mybatisplus.generator.fill.Column;
import com.baomidou.mybatisplus.generator.keywords.MySqlKeyWordsHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Mapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestComponent;
import org.springframework.core.env.Environment;

import java.util.Collections;

/**
 * @author Roozen
 * @version 1.0
 */
@Slf4j
@TestComponent
@SpringBootTest
class TestCodeGenerator {
    @Value("${spring.datasource.url}")
    private String url;
    @Value("${spring.datasource.username}")
    private String username;
    @Value("${spring.datasource.password}")
    private String password;
    @Value("${user.dir}/src/main/java")
    private String codeOutputDir;
    @Value("${user.dir}/src/main/resources/mapper")
    private String xmlOutputDir;

    @Autowired
    private Environment environment;

    @Test
    void generator() {

        System.out.println(url);
        System.out.println(environment);

        DataSourceConfig.Builder dataSourceConfigBuilder = new DataSourceConfig.Builder(url, username, password)
                .dbQuery(new MySqlQuery())
                .schema("alcss")
                .typeConvert(new MySqlTypeConvert())
                .keyWordsHandler(new MySqlKeyWordsHandler());

        FastAutoGenerator.create(dataSourceConfigBuilder)
                .globalConfig(builder -> {
                    builder
                            .author("<a href=\"https://roozen.top\">Roozen</a>")
                            .enableSpringdoc()
                            .outputDir(codeOutputDir)
                            .disableOpenDir();
                })
                .packageConfig(builder -> {
                    builder
                            .parent("com.roozen.alcss")
                            .pathInfo(Collections.singletonMap(OutputFile.xml, xmlOutputDir)); // 设置mapperXml生成路径
                })
                .strategyConfig(builder -> {
                    builder
                            .addExclude("user")
                            .entityBuilder()
                            .enableFileOverride()
                            .logicDeleteColumnName("is_deleted")
                            .logicDeletePropertyName("deleted")
                            .enableLombok()
                            .enableChainModel()
                            .enableRemoveIsPrefix()
                            .enableTableFieldAnnotation()
                            .addTableFills(new Column("gmt_create", FieldFill.INSERT))
                            .addTableFills(new Column("gmt_modified", FieldFill.INSERT_UPDATE))
                            .idType(IdType.AUTO)
                            .build()

                            .controllerBuilder()
                            .enableFileOverride()
                            .enableRestStyle()
                            .build()

                            .mapperBuilder()
                            .enableFileOverride()
                            .mapperAnnotation(Mapper.class)
                            .enableBaseResultMap()
                            .build()

                            .serviceBuilder()
                            .enableFileOverride()
                            .build();
                })
                .templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
                .execute();
    }
}
