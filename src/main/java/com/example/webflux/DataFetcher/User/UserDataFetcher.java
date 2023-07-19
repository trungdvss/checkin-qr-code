package com.example.webflux.DataFetcher.User;

import com.example.webflux.Entities.User;
import com.example.webflux.Repositories.UserRepository;
import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
public class UserDataFetcher implements DataFetcher<Mono<User>> {
    @Autowired
    private UserRepository userRepository;
    @Override
    public Mono<User> get(DataFetchingEnvironment environment) throws Exception {
        Object id = environment.getArgument("id");
        return userRepository.findById((Long) id);
    }
}
