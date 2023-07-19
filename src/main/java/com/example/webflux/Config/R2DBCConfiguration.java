package com.example.webflux.Config;

import org.mariadb.r2dbc.MariadbConnectionConfiguration;
import org.mariadb.r2dbc.MariadbConnectionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.r2dbc.config.AbstractR2dbcConfiguration;
import org.springframework.data.r2dbc.config.EnableR2dbcAuditing;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;

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
    @Override
    public MariadbConnectionFactory connectionFactory(){
        return new MariadbConnectionFactory(MariadbConnectionConfiguration.builder()
                .host(host)
                .port(Integer.parseInt(port))
                .username(username)
                .password(password)
                .build());
    }
}
