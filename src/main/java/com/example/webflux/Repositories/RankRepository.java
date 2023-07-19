package com.example.webflux.Repositories;

import com.example.webflux.Entities.Rank;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RankRepository extends R2dbcRepository<Rank, Long> {
}
