package com.example.qrcode.Config;

import io.r2dbc.pool.ConnectionPool;
import io.r2dbc.pool.ConnectionPoolConfiguration;
import io.r2dbc.spi.ConnectionFactory;
import org.mariadb.r2dbc.MariadbConnectionConfiguration;
import org.mariadb.r2dbc.MariadbConnectionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.r2dbc.config.AbstractR2dbcConfiguration;
import org.springframework.data.r2dbc.config.EnableR2dbcAuditing;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;

import java.time.Duration;

@Configuration
@EnableR2dbcAuditing
@EnableR2dbcRepositories(basePackages = {"com.example.webflux.Repositories"})
public class R2DBCConfiguration extends AbstractR2dbcConfiguration {
    @Value("${mariadb.host}")
    private String host;
    @Value("${mariadb.port}")
    private String port;
    @Value("${mariadb.username}")
    private String username;
    @Value("${mariadb.password}")
    private String password;
    @Value("${mariadb.database}")
    private String database;
    @Bean
    @Override
    public ConnectionFactory connectionFactory(){
        ConnectionFactory connectionFactory = new MariadbConnectionFactory(MariadbConnectionConfiguration.builder()
                .host(host)
                .port(Integer.parseInt(port))
                .username(username)
                .password(password)
                .database(database)
                .build());
        ConnectionPoolConfiguration configurationPoolConfiguration = ConnectionPoolConfiguration.builder()
                .connectionFactory(connectionFactory)
                .initialSize(2)
                .maxLifeTime(Duration.ofSeconds(1800))
                .maxIdleTime(Duration.ofSeconds(1800)).build();
        return new ConnectionPool(configurationPoolConfiguration);
    }
}
