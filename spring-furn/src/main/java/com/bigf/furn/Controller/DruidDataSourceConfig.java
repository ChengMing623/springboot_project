package com.bigf.furn.Controller;

import com.alibaba.druid.pool.DruidDataSource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
public class DruidDataSourceConfig {
    @Bean
    @ConfigurationProperties("spring.datasource")
    public DruidDataSource druidDataSource() {
        DruidDataSource druidDataSource = new DruidDataSource();
        //日志输出,查看是否注入
        log.info("数据源={}"+druidDataSource);
        return druidDataSource;
    }
}
