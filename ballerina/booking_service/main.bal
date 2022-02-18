import ballerina/io;
import ballerina/http;

service on new http:Listener(8080) {
    function init() {
        io:println("Server Started");
    }

    BookingsStore store = new ();

    resource function get booking/[int id]()
        returns http:Ok|http:NotFound {
        Booking|error booking = self.store.getBooking(id);
        return booking is Booking ?
            <http:Ok>{body: booking.toJson()}
            : <http:NotFound>{};
    }

    resource function post booking(@http:Payload Booking booking)
        returns http:Created|http:BadRequest {
        int|error bookingResult = self.store.addBooking(booking);
        return bookingResult is int ?
            <http:Created>{
                headers: {
                    [http:LOCATION] : string `booking/${bookingResult}`
                }
            } : <http:BadRequest>{};
    }
}
