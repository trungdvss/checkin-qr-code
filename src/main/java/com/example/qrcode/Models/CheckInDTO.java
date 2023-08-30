package com.example.qrcode.Models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class CheckInDTO {
    private String idUser;
    private String username;
    private Boolean checkIn;
    private LocalDateTime dateCheckIn;
}
