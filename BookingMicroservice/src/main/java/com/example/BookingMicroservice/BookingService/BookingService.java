package com.example.BookingMicroservice.BookingService;

import com.example.BookingMicroservice.BookingJavaRepository.BookingReposInterface;
import com.example.BookingMicroservice.BookingsEntity.Bookings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookingService {
    @Autowired
    private final BookingReposInterface bookingRepository;

    public BookingService(BookingReposInterface bookingRepository){
        this.bookingRepository = bookingRepository;
    }

    public  Bookings saveBooking(Bookings bookings) {
        return bookingRepository.save(bookings);
    }

    public List<Bookings> viewBookings() {
        return bookingRepository.findAll();
    }

    public Bookings updateBooking(int id, Bookings updatedBooking) {
        Optional<Bookings> existingBookingOptional = bookingRepository.findById(id);

        if (existingBookingOptional.isPresent()) {
            Bookings existingBooking = existingBookingOptional.get();

            // Update fields if they are not null
            if (updatedBooking.getBookingID() != null) {
                existingBooking.setBookingID(updatedBooking.getBookingID());
            }
            if (updatedBooking.getUserID() != null) {
                existingBooking.setUserID(updatedBooking.getUserID());
            }
            if (updatedBooking.getSpaceID() != null) {
                existingBooking.setSpaceID(updatedBooking.getSpaceID());
            }
            if (updatedBooking.getStartTime() != null) {
                existingBooking.setStartTime(updatedBooking.getStartTime());
            }
            if (updatedBooking.getEndTime() != null) {
                existingBooking.setEndTime(updatedBooking.getEndTime());
            }
            if (updatedBooking.getStatus() != null) {
                existingBooking.setStatus(updatedBooking.getStatus());
            }

            return bookingRepository.save(existingBooking);
        } else {
            throw new RuntimeException("Booking not found with ID: " + id);
        }
    }

    public boolean deleteBooking(int id) {
        if (bookingRepository.existsById(id)) {
            bookingRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public String generateNextBookingId() {
        Integer maxId = bookingRepository.findMaxId(); // Fetch the max id from DB
        int nextId = (maxId != null) ? maxId + 1 : 1; // If null, start from 1
        return "BK_" + nextId;
    }
}
