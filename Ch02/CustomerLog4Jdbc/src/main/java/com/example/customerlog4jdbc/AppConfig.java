package com.example.customerlog4jdbc;

import net.sf.log4jdbc.Log4jdbcProxyDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

@Configuration
public class AppConfig {
    @Autowired
    DataSourceProperties dataSourceProperties;
    DataSource dataSource;

    private void setDataSource() {
        if (this.dataSource == null) {
            DataSourceBuilder factory = DataSourceBuilder
                    .create(this.dataSourceProperties.getClassLoader())
                    .url(this.dataSourceProperties.getUrl())
                    .username(this.dataSourceProperties.getUsername())
                    .password(this.dataSourceProperties.getPassword());
            this.dataSource = factory.build();
        }
    }

    @Bean
    DataSource realDataSource() {
        setDataSource();
        return this.dataSource;
    }

    @Bean
    @Primary
    DataSource dataSource() {
        setDataSource();
        return new Log4jdbcProxyDataSource(this.dataSource);
    }
}
