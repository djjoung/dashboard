package chargingstation;

// import org.springframework.data.repository.CrudRepository;
// import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DashBoardRepository extends JpaRepository<DashBoard, Long> {

    List<DashBoard> findByOrderId(Long orderId);
}