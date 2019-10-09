package no.zendera.FreightApplication.Config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import lombok.Getter;
import lombok.Setter;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

import java.lang.invoke.MethodHandles;
import java.sql.Connection;
import java.sql.SQLException;

@Component
@Configuration
@ConfigurationProperties("spring.datasource")
public class DatabaseConfig {

    private static org.slf4j.Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @NonNull @Getter @Setter
    private String url;

    @NonNull @Getter @Setter
    private String username;

    @NonNull @Getter @Setter
    private String password;

    private static HikariConfig dataSourceConfig = new HikariConfig();

    @Lazy
    @Autowired
    private HikariDataSource hikariDataSource;

    @Lazy
    @Autowired
    private Connection connection;

    @Bean
    public HikariDataSource dataSource() {
        dataSourceConfig.setJdbcUrl(url);
        dataSourceConfig.setUsername(username);
        dataSourceConfig.setPassword(password);

        logger.info("Database URL: {}", dataSourceConfig.getJdbcUrl());
        logger.info("Database User: {}", dataSourceConfig.getUsername());

        return new HikariDataSource(dataSourceConfig);
    }

    @Bean
    public Connection getConnection() throws SQLException {
        logger.info("Connected to: "+ this.hikariDataSource.getJdbcUrl());
        return this.hikariDataSource.getConnection();
    }
}