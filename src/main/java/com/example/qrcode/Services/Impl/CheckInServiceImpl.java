package com.example.qrcode.Services.Impl;

import com.example.qrcode.Entities.CheckInEntity;
import com.example.qrcode.Models.BaseResponse;
import com.example.qrcode.Models.CheckInDTO;
import com.example.qrcode.Repositories.CheckInRepository;
import com.example.qrcode.Repositories.UserRepository;
import com.example.qrcode.Services.CheckInService;
import com.example.qrcode.Utils.Contants;
import com.example.qrcode.Utils.MessageUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;
import java.util.Objects;

public class CheckInServiceImpl implements CheckInService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private CheckInRepository checkInRepository;
    @Override
    public Mono<BaseResponse> createCheckIn(CheckInDTO checkInDTO) {
        return userRepository.findUserEntityById(checkInDTO.getIdUser()).collectList().flatMap(userEntity -> {
            if (userEntity.isEmpty()) {
                return Mono.error(new IllegalArgumentException(MessageUtils.getMessageWithValue(Contants.USER_NOT_FOUND, checkInDTO.getIdUser())));
            }
            CheckInEntity checkInEntity = new CheckInEntity();
            checkInEntity.setCheckIn(checkInDTO.getCheckIn());
            checkInEntity.setUsername(checkInDTO.getUsername());
            checkInEntity.setDateCheckIn(LocalDateTime.now());
            return checkInRepository.save(checkInEntity).map(result->{
                if (Objects.nonNull(result)) {
                    return BaseResponse.builder()
                            .errorCode(0)
                            .message("check in success")
                            .data(result).build();
                } else {
                    return BaseResponse.builder()
                            .errorCode(1)
                            .message("check in fail")
                            .build();
                }
            });
        });
    }
}
