package com.example.qrcode.Services;

import com.example.qrcode.Models.BaseResponse;
import com.example.qrcode.Models.UserDTO;
import reactor.core.publisher.Mono;

public interface UserService {
    Mono<BaseResponse> createUser(UserDTO userDTO);
    Mono<BaseResponse> updateUser(UserDTO userDTO);
    Mono<BaseResponse> deleteUser(UserDTO userDTO);
}
