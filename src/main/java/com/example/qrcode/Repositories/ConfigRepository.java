package com.example.qrcode.Repositories;

import com.example.qrcode.Entities.ConfigEntity;
import org.springframework.data.r2dbc.repository.R2dbcRepository;

public interface ConfigRepository extends R2dbcRepository<ConfigEntity, Long> {
}
