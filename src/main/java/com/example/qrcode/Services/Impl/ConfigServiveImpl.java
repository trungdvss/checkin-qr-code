package com.example.qrcode.Services.Impl;

import com.example.qrcode.Entities.ConfigEntity;
import com.example.qrcode.Models.BaseResponse;
import com.example.qrcode.Models.ConfigDTO;
import com.example.qrcode.Repositories.ConfigRepository;
import com.example.qrcode.Services.ConfigService;
import com.example.qrcode.Utils.Contants;
import com.example.qrcode.Utils.DataUtils;
import com.example.qrcode.Utils.MessageUtils;
import org.apache.catalina.Contained;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import reactor.core.publisher.Mono;

public class ConfigServiveImpl implements ConfigService {
    @Autowired
    private ConfigRepository configRepository;
    @Override
    public Mono<BaseResponse> createConfig(ConfigDTO configDTO) {
        if (DataUtils.isNullOrEmpty(configDTO.getName())){
            return Mono.just(BaseResponse.builder().errorCode(1).message(MessageUtils.getMessageWithValue(Contants.IS_REQUIRE,"name")).build());
        }
        if (DataUtils.isNullOrEmpty(configDTO.getValue())){
            return Mono.just(BaseResponse.builder().errorCode(1).message(MessageUtils.getMessageWithValue(Contants.IS_REQUIRE,"value")).build());
        }
        ConfigEntity configEntity = new ConfigEntity();
        BeanUtils.copyProperties(configEntity,configDTO);
        return configRepository.save(configEntity).map(user->{
            if (DataUtils.isNullOrEmpty(user)){
                return BaseResponse.builder().errorCode(1).message("Create config fail").build();
            }else {
                return BaseResponse.builder().errorCode(1).message("Create config success").data(user).build();
            }
        });
    }

    @Override
    public Mono<BaseResponse> updateConfig(ConfigDTO configDTO) {
        if (DataUtils.isNullOrEmpty(configDTO.getName())){
            return Mono.just(BaseResponse.builder().errorCode(1).message(MessageUtils.getMessageWithValue(Contants.IS_REQUIRE,"name")).build());
        }
        if (DataUtils.isNullOrEmpty(configDTO.getValue())){
            return Mono.just(BaseResponse.builder().errorCode(1).message(MessageUtils.getMessageWithValue(Contants.IS_REQUIRE,"value")).build());
        }
        ConfigEntity configEntity = new ConfigEntity();
        BeanUtils.copyProperties(configEntity,configDTO);
        return configRepository.save(configEntity).map(user->{
            if (DataUtils.isNullOrEmpty(user)){
                return BaseResponse.builder().errorCode(1).message("Update config fail").build();
            }else {
                return BaseResponse.builder().errorCode(1).message("Update config success").data(user).build();
            }
        });
    }
}
