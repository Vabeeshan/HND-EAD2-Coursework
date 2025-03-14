package BookingJavaRepository;

import BookingsEntity.Bookings;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingReposInterface extends JpaRepository<Bookings,Integer> {

}
