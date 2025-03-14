package BookingsEntity;

import jakarta.persistence.*;
import java.security.PrivateKey;
import java.util.Date;

@Entity
@Table(name = "Bookings")
public class Bookings {
    @Id
    @Column(nullable = false, unique = true)
    private String bookingID;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    private String userID;
    private String spaceID;
    private Date startTime;
    private Date endTime;
    private String status;

    private void SetBookingInformations(String bookingID,String userID,String spaceID,Date startTime,Date endTime,String status){
        this.bookingID = bookingID;
        this.userID= userID;
        this.spaceID=spaceID;
        this.startTime=startTime;
        this.endTime=endTime;
        this.status=status;

    }
    private void setBookingID(String bookingID){
        this.bookingID=bookingID;
    }

}
