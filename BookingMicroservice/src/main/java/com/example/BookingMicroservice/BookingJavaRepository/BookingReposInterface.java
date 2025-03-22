package com.example.BookingMicroservice.BookingJavaRepository;

import com.example.BookingMicroservice.BookingsEntity.Bookings;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BookingReposInterface extends JpaRepository<Bookings,Integer> {
    @Query("SELECT MAX(b.id) FROM Bookings b")
    Integer findMaxId();
}
