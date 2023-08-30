package com.example.qrcode.Entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Builder
@Table(name = "users")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserEntity extends AbtractEntity {
    @Id
    private String id;
    @Column(name = "username")
    private String username;
    private String password;
    @Column(name = "so_dien_thoai")
    private String soDienThoai;
    private String email;
    private String role;
    @Column(name = "ten")
    private String fullName;
}
