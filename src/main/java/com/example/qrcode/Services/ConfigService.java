package com.example.qrcode.Services;

import com.example.qrcode.Models.BaseResponse;
import com.example.qrcode.Models.ConfigDTO;
import reactor.core.publisher.Mono;

public interface ConfigService {
    Mono<BaseResponse> createConfig(ConfigDTO configDTO);
    Mono<BaseResponse> updateConfig(ConfigDTO configDTO);
}
