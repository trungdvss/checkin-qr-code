package com.example.webflux.Models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@Builder
@NoArgsConstructor
@Data
public class UserDTO {
    private String username;
    private String password;
    private String fullName;
    private String birthDate;
    private Long rankId;
}
