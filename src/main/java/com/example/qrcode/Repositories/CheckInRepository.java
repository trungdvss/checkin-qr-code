package com.example.qrcode.Repositories;

import com.example.qrcode.Entities.CheckInEntity;
import org.springframework.data.r2dbc.repository.R2dbcRepository;

public interface CheckInRepository extends R2dbcRepository<CheckInEntity, Long> {
}
