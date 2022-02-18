class BookingsStore {
    private final map<Booking> bookings = {};

    function addBooking(Booking booking) returns int|error {
        int id = self.bookings.length() + 1;
        booking.id = self.bookings.length() + 1;
        self.bookings[id.toString()] = booking;

        return id;
    }

    function getBooking(int id) returns Booking|error {
        if !self.bookings.hasKey(id.toString()) {
            return error InvalidBookingID(string `Could not find entry for ${id}`);
        }
        Booking booking = self.bookings.get(id.toString());

        return booking;
    }
}

type InvalidBookingID error<map<anydata>>;

type Booking record {
    int id?;
    string hotelName;
    string bookingDate;
};
