package com.example.qrcode.Models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Builder
@NoArgsConstructor
@Data
public class UserDTO {
    private String username;
    private String password;
    private String fullName;
    private String soDienThoai;
    private String email;
    private String role;
}
