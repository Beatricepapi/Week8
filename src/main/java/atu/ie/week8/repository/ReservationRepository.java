package atu.ie.week8.repository;

import atu.ie.week8.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {

    // Custom query method (Part B requirement)
    List<Reservation> findByEquipmentTag(String equipmentTag);
    List<Reservation> findByStudentName(String studentName);
}
