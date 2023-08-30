package com.example.qrcode.Services.Impl;

import com.example.qrcode.Entities.UserEntity;
import com.example.qrcode.Models.BaseResponse;
import com.example.qrcode.Models.UserDTO;
import com.example.qrcode.Repositories.UserRepository;
import com.example.qrcode.Services.UserService;
import com.example.qrcode.Utils.Contants;
import com.example.qrcode.Utils.DataUtils;
import com.example.qrcode.Utils.MessageUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import reactor.core.publisher.Mono;

import java.util.Objects;
import java.util.UUID;

public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public Mono<BaseResponse> createUser(UserDTO userDTO) {
        UserEntity userEntity = new UserEntity();
        BeanUtils.copyProperties(userDTO,userEntity);
        userEntity.setId(UUID.randomUUID().toString());
        return userRepository.findUserEntityByUsername(userDTO.getUsername()).collectList().flatMap(user->{
           if (user.isEmpty()){
               return userRepository.save(userEntity);
           }else {
               return Mono.error(new IllegalArgumentException(MessageUtils.getMessageWithValue(Contants.ALREADY_EXISTS,userDTO.getUsername())));
           }
        }).map(userEntity1 -> {
            if (!Objects.nonNull(userEntity1)) {
                return BaseResponse.builder().errorCode(1).message("Create user fail").build();
            }
            return BaseResponse.builder().errorCode(0).message("Create user success").data(userEntity1).build();
        });
    }

    @Override
    public Mono<BaseResponse> updateUser(UserDTO userDTO) {
        if (DataUtils.isNullOrEmpty(userDTO.getUsername())){
            return Mono. just(BaseResponse.builder().errorCode(1).message(MessageUtils.getMessageWithValue(Contants.IS_REQUIRE,"Username")).build());
        }
        return userRepository.findUserEntityByUsername(userDTO.getUsername()).collectList().flatMap(userEntities -> {
            if (userEntities.isEmpty()){
                return Mono.just(BaseResponse.builder().errorCode(1).message(MessageUtils.getMessageWithValue(Contants.NOT_FOUND,"Username"+userDTO.getUsername())).build());
            }
            UserEntity userEntity = new UserEntity();
            BeanUtils.copyProperties(userEntity,userDTO);
            return userRepository.save(userEntity);
        }).map(userUpdate->{
            if (!Objects.nonNull(userUpdate)) {
                return BaseResponse.builder().errorCode(1).message("Update user fail").build();
            }
            return BaseResponse.builder().errorCode(0).message("Update user success").data(userUpdate).build();
        });
    }

    @Override
    public Mono<BaseResponse> deleteUser(UserDTO userDTO) {
        UserEntity userEntity = new UserEntity();
        BeanUtils.copyProperties(userEntity,userDTO);
        return userRepository.delete(userEntity).map(user->{
            return BaseResponse.builder().errorCode(0).message("Remove user success").build();
        });
    }
}
