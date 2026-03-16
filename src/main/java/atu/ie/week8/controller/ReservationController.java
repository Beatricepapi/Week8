package atu.ie.week8.controller;

import atu.ie.week8.model.Reservation;
import atu.ie.week8.service.ReservationService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reservations")
public class ReservationController {

    private final ReservationService reservationService;

    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    // POST /reservations
    @PostMapping
    public ResponseEntity<Reservation> createReservation(@Valid @RequestBody Reservation reservation) {
        Reservation saved = reservationService.createReservation(reservation);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    // GET /reservations
    @GetMapping
    public ResponseEntity<List<Reservation>> getAllReservations() {
        return ResponseEntity.ok(reservationService.getAllReservations());
    }

    // GET /reservations/{id}
    @GetMapping("/{id}")
    public ResponseEntity<Reservation> getReservationById(@PathVariable Long id) {
        return ResponseEntity.ok(reservationService.getReservationById(id));
    }

    // Part B endpoint
    // GET /reservations/equipment/{tag}
    @GetMapping("/equipment/{tag}")
    public ResponseEntity<List<Reservation>> getByEquipmentTag(@PathVariable String tag) {
        return ResponseEntity.ok(reservationService.getByEquipmentTag(tag));
    }

    @GetMapping("/student/{name}")
    public ResponseEntity<List<Reservation>> getByStudentName(@PathVariable String name) {
        return ResponseEntity.ok(reservationService.getReservationsByStudentName(name));
    }
}
