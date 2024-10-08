package com.codurance.module1.preRequisites.WhatToTest.Booking.Application;

import com.codurance.module1.preRequisites.WhatToTest.Booking.Domain.Booking;
import com.codurance.module1.preRequisites.WhatToTest.Booking.Domain.BookingAvailability;
import com.codurance.module1.preRequisites.WhatToTest.Booking.Domain.BookingId;
import com.codurance.module1.preRequisites.WhatToTest.Booking.Domain.BookingRepository;

import java.util.List;

public class BookingService {
    private final BookingAvailability bookingAvailability;
    private final BookingRepository bookingRepository;

    BookingService(
        BookingAvailability bookingAvailability,
        BookingRepository bookingRepository
    ) {

        this.bookingAvailability = bookingAvailability;
        this.bookingRepository = bookingRepository;
    }

    public void createBooking(BookingRequest bookingRequest) throws Exception{
        bookingAvailability.verify(bookingRequest.bookingDates());
        bookingRepository.save(bookingRequest.createBooking());
    }

    public void cancelBooking(BookingId id) throws Exception {
        Booking booking = getBookingDetails(id);

        bookingAvailability.cancel(
            booking
        );

        bookingRepository.cancel(booking);
    }

    public Booking getBookingDetails(BookingId id) throws Exception {
        return bookingRepository.get(id);
    }

    public List<Booking> listBookings() throws Exception {
        return bookingRepository.all();
    }
}
