package com.example.qrcode.Repositories;

import com.example.qrcode.Entities.UserEntity;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import reactor.core.publisher.Flux;

import java.util.UUID;

public interface UserRepository extends R2dbcRepository<UserEntity, UUID> {
    @Query("SELECT * FROM qr_code.users where username = :username")
    Flux<UserEntity> findUserEntityByUsername(String username);
    @Query("SELECT * FROM qr_code.users where id = :id")
    Flux<UserEntity> findUserEntityById(String id);
}
