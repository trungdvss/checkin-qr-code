package com.example.qrcode.Entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import java.time.LocalDateTime;
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class AbtractEntity {
    @Column(name = "create_user")
    private String createUser;
    @Column(name = "update_user")
    private String updateUser;
    @Column(name = "update_datetime")
    private LocalDateTime updateDateTime;
    @Column(name = "create_datetime")
    private LocalDateTime createDateTime;
}
