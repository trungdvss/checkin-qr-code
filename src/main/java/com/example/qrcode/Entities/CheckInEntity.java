package com.example.qrcode.Entities;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "check_in")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class CheckInEntity extends AbtractEntity{
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    @Column(name = "check_in")
    private Boolean checkIn;
    @Column(name = "username")
    private String username;
    @Column(name = "date_check_in")
    private LocalDateTime dateCheckIn;
}
