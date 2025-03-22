package com.example.BookingMicroservice.BookingController;

import com.example.BookingMicroservice.BookingService.BookingService;
import com.example.BookingMicroservice.BookingsEntity.Bookings;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/booking")
public class BookingController {
    private final BookingService bookservice;

    public BookingController(BookingService bookservice){
        this.bookservice = bookservice;
    }

    // POST mapping to insert booking details
    @PostMapping("/saveBookings")
    public ResponseEntity<Bookings> saveBookings(@RequestBody Bookings bookings){
        Bookings savedBooking = bookservice.saveBooking(bookings);
        return ResponseEntity.ok(savedBooking);
    }

    // GET mapping to retrieve booking details
    @GetMapping("/viewBookings")
    public ResponseEntity<List<Bookings>> getBookingDetails() {
        List<Bookings> allBookings = bookservice.viewBookings();
        return ResponseEntity.ok(allBookings);
    }

    @PutMapping("updateBooking/{id}")
    public ResponseEntity<Bookings> updateBooking(@PathVariable int id, @RequestBody Bookings updatedBooking) {
        try {
            Bookings updated = bookservice.updateBooking(id, updatedBooking);
            return ResponseEntity.ok(updated);
        }
        catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // DELETE request to delete a booking by ID
    @DeleteMapping("/deleteBooking/{id}")
    public ResponseEntity<String> deleteBooking(@PathVariable int id) {
        boolean isDeleted = bookservice.deleteBooking(id);
        if (isDeleted) {
            return ResponseEntity.ok("Booking with ID " + id + " has been deleted successfully.");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/generateBookingId")
    public ResponseEntity<String> generateBookingId() {
        String newBookingId = bookservice.generateNextBookingId();
        return ResponseEntity.ok(newBookingId);
    }
}
