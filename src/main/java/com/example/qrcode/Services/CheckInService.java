package com.example.qrcode.Services;

import com.example.qrcode.Models.BaseResponse;
import com.example.qrcode.Models.CheckInDTO;
import reactor.core.publisher.Mono;

public interface CheckInService {
    Mono<BaseResponse> createCheckIn(CheckInDTO checkInDTO);
}
