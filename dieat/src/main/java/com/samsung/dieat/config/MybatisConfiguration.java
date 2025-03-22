package com.samsung.dieat.config;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan(basePackages = "com.samsung.dieat", annotationClass = Mapper.class)
public class MybatisConfiguration {
}