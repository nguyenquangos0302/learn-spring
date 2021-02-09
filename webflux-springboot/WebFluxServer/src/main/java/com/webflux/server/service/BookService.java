package com.webflux.server.service;

import com.webflux.server.entity.BookEntity;
import com.webflux.server.repository.IBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("BookMyShow/Service")
public class BookService {

    @Autowired
    private IBookRepository repository;

    @PostMapping("/bookingShow")
    public String bookShow(@RequestBody BookEntity bookRequest) {
        BookEntity response = repository.save(bookRequest);
        return "Hi " + response.getUsername() + " your Request for " + response.getShowname() + " on date "
                + response.getBookingtime() + "Booking successfully..";
    }

    @GetMapping("/getAllBooking")
    public List<BookEntity> getAllBooking() {
        return repository.findAll();
    }

    @GetMapping("/getBooking/{bookingId}")
    public BookEntity getBooking(@PathVariable Long bookingId) {
        return repository.findById(bookingId).get();
    }

    @DeleteMapping("/cancelBooking/{bookingId}")
    public String cancelBooking(@PathVariable Long bookingId) {
        repository.deleteById(bookingId);
        return "Booking cancelled with bookingId : " + bookingId;
    }

    @PutMapping("/updateBooking/{bookingId}")
    public BookEntity updateBooking(@RequestBody BookEntity updateBookRequest, @PathVariable Long bookingId) {
        BookEntity dbResponse = repository.findById(bookingId).get();
        dbResponse.setBookingtime(updateBookRequest.getBookingtime());
        dbResponse.setPrice(updateBookRequest.getPrice());
        dbResponse.setShowname(updateBookRequest.getShowname());
        dbResponse.setUsercount(updateBookRequest.getUsercount());
        repository.saveAndFlush(dbResponse);
        return dbResponse;
    }

}
