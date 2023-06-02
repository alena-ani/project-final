package com.javarush.jira.common.config;

import com.zaxxer.hikari.HikariDataSource;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@EnableJpaRepositories(basePackages = {"com.javarush.jira"})
@EnableTransactionManagement
@RequiredArgsConstructor
public class DataSourceConfig {

    private final Environment environment;

    @Bean
    @Profile("prod")
    public DataSource dataSource() {
        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setJdbcUrl(environment.getProperty("spring.datasource.url", ""));
        dataSource.setUsername(environment.getProperty("spring.datasource.username", ""));
        dataSource.setPassword(environment.getProperty("spring.datasource.password", ""));
        return dataSource;
    }

    @Bean
    @Profile("test")
    public DataSource testDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(environment.getProperty("spring.datasource.driverClassName", "org.h2.Driver"));
        dataSource.setUrl(environment.getProperty("spring.datasource.url", "jdbc:h2:mem:jira-test-db"));
        dataSource.setUsername(environment.getProperty("spring.datasource.username", "sa"));
        dataSource.setPassword(environment.getProperty("spring.datasource.password", "password"));
        return dataSource;
    }
}
