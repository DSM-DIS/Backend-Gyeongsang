package com.dsm.gyeongsang.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class DatabaseConfiguration {

    @Value("${DATABASE_DRIVER:com.mysql.cj.jdbc.Driver}")
    private String driverClassName = "";

    @Value("${DATABASE_URL:jdbc:mysql://localhost:3306/localdb_dis?useUnicode=true&characterEncoding=utf8&allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC}")
    private String url = "";

    @Value("${DATABASE_USERNAME:root}")
    private String username = "";

    @Value("${DATABASE_PASSWORD:1111}")
    private String password = "";

    @Bean
    public DataSource dataSource() {
        return DataSourceBuilder
                .create()
                .url(url)
                .driverClassName(driverClassName)
                .username(username)
                .password(password)
                .build();
    }
}
