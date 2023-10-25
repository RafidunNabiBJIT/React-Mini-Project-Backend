package com.mini.project.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder  // Add this annotation
@Entity
@Table(name = "reservation")
public class ReservationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "book_id")
    private BookEntity book;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

    private LocalDateTime reservationTime;

    @Column(name = "is_reserved", columnDefinition = "BOOLEAN DEFAULT false")
    private boolean isReserved = false;
    @Column(name = "is_cancelled", columnDefinition = "BOOLEAN DEFAULT false")
    private boolean isCancelled;
    private String notify;
}
