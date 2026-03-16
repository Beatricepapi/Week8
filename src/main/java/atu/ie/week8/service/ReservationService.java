package atu.ie.week8.service;

import atu.ie.week8.exeption.ReservationNotFoundException;
import atu.ie.week8.model.Reservation;
import atu.ie.week8.repository.ReservationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationService {

    private final ReservationRepository reservationRepository;

    public ReservationService(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    // CREATE
    public Reservation createReservation(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    // GET ALL
    public List<Reservation> getAllReservations() {
        return reservationRepository.findAll();
    }

    public List<Reservation> getReservationsByStudentName(String name) {
        return reservationRepository.findByStudentName(name);
    }

    // GET BY ID
    public Reservation getReservationById(Long id) {
        return reservationRepository.findById(id)
                .orElseThrow(() -> new ReservationNotFoundException("Reservation not found"));
    }

    // FIND BY EQUIPMENT TAG
    public List<Reservation> getByEquipmentTag(String tag) {
        return reservationRepository.findByEquipmentTag(tag);
    }

    // DELETE
    public void deleteReservation(Long id) {
        if (!reservationRepository.existsById(id)) {
            throw new ReservationNotFoundException("Reservation not found");
        }

        reservationRepository.deleteById(id);
    }
}
