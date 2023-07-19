package com.example.webflux.Controllers;

import com.example.webflux.Models.BaseResponse;
import com.example.webflux.Models.UserDTO;
import com.example.webflux.Services.UserImpl.UserServiceImpl;
import com.example.webflux.Services.UserService;
import graphql.ExecutionResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class UserControllers  {
    @Autowired
    private UserServiceImpl userServiceImpl;
    @Autowired
    private UserService userService;

    @QueryMapping
    public Mono<BaseResponse> findAllData(@RequestBody String query){
        ExecutionResult result =  userServiceImpl.getGraphQL().execute(query);
        if (result.isDataPresent()){
            return Mono.just(BaseResponse.builder()
                            .errorCode(0)
                            .message("Data found")
                            .data(result.getData())
                            .build());
        }else {
            return Mono.just(BaseResponse.builder()
                    .errorCode(1)
                    .message("Data not found")
                    .data(null)
                    .build());
        }
    }
    @SchemaMapping(typeName = "Mutation",field = "createUser")
    public Mono<BaseResponse> createUser(@Argument UserDTO user){
        return userService.createUser(user);
    }
}
