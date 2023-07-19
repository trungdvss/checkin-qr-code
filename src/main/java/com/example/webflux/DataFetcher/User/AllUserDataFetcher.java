package com.example.webflux.DataFetcher.User;

import com.example.webflux.Entities.User;
import com.example.webflux.Repositories.UserRepository;
import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.util.List;

@Component
public class AllUserDataFetcher implements DataFetcher<Mono<List<User>>> {
    @Autowired
    private UserRepository userRepository;

    @Override
    public Mono<List<User>> get(DataFetchingEnvironment environment) throws Exception {
        return userRepository.findAll().collectList();
    }
}
