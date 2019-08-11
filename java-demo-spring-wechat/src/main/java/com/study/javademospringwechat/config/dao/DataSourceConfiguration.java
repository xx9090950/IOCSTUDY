package com.study.javademospringwechat.config.dao;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.beans.PropertyVetoException;

@Configuration
//配置mybits mapper的扫描路径
@MapperScan("com.study.javademospringwechat.dao")
public class DataSourceConfiguration {
    @Value("${jdbcDriver}")
    private String jdbcDriver;
    @Value("${jdbcUrl}")
    private String jdbcUrl;
    @Value("${jdbcUser}")
    private String jdbcUser;
    @Value("${jdbcPassword}")
    private String jdbcPassword;

    @Bean("DataSource")
    public ComboPooledDataSource createDataSource() throws PropertyVetoException {
        //创建连接池对象
        ComboPooledDataSource dataSource=new ComboPooledDataSource();
        dataSource.setDriverClass(jdbcDriver);
        dataSource.setJdbcUrl(jdbcUrl);
        dataSource.setUser(jdbcUser);
        dataSource.setPassword(jdbcPassword);
        dataSource.setAutoCommitOnClose(false);
        return dataSource;
    }
}
