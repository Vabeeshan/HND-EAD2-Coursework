package com.example.BookingMicroservice.BookingsEntity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "bookings") // lowercase table name (best practice)
public class Bookings {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Primary key (auto-generated)
    private long id;

    @Column(name = "bookingID",nullable = false, unique = true)
    private String bookingID; // Unique but NOT a primary key

    @Column(name = "userID",nullable = false)
    private String userID;

    @Column(name = "spaceID",nullable = false)
    private String spaceID;

    @Column(name = "startTime",nullable = false)
    private LocalDateTime startTime;

    @Column(name = "endTime",nullable = false)
    private LocalDateTime endTime;

    @Column(name = "status",nullable = false)
    private String status;

    //  No-args constructor
    public Bookings() {
        this.startTime = LocalDateTime.now(); // Default to now
        this.endTime = LocalDateTime.now().plusHours(1); // Default 1 hour later
        this.status = "PENDING"; // Default status
    }

    //  Constructor with all fields
    public Bookings(String bookingID, String userID, String spaceID, LocalDateTime startTime, LocalDateTime endTime, String status) {
        this.bookingID = bookingID;
        this.userID = userID;
        this.spaceID = spaceID;
        this.startTime = startTime;
        this.endTime = endTime;
        this.status = status;
    }

    //  Getters & Setters
    public long getId() {
        return id;
    }

    public String getBookingID() {
        return bookingID;
    }

    public void setBookingID(String bookingID) {
        this.bookingID = bookingID;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getSpaceID() {
        return spaceID;
    }

    public void setSpaceID(String spaceID) {
        this.spaceID = spaceID;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
