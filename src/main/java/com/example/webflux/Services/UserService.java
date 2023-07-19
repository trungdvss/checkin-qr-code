package com.example.webflux.Services;

import com.example.webflux.Models.BaseResponse;
import com.example.webflux.Models.UserDTO;
import reactor.core.publisher.Mono;

public interface UserService {
    Mono<BaseResponse> createUser(UserDTO user);
}
