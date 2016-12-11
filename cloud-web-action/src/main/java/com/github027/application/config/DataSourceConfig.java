package com.github027.application.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.github027.application.property.Config;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
public class DataSourceConfig {
	
	@Autowired
	private Config config;

    @Bean
    @Primary
    public DataSource hikariDataSource()
    {
        final HikariDataSource hikariDS = new HikariDataSource();
        hikariDS.setDriverClassName(config.getDatasourceDriverClassName());
        hikariDS.setJdbcUrl(config.getDatasourceUrl());
        hikariDS.setUsername(config.getDatasourceUsername());
        hikariDS.setPassword(config.getDatasourcePassword());

        return hikariDS;
    }

}
