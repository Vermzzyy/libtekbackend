package com.appdevg6.miamiheat.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appdevg6.miamiheat.entity.BoothEntity;
import com.appdevg6.miamiheat.entity.ReservationEntity;
import com.appdevg6.miamiheat.entity.UserEntity;
import com.appdevg6.miamiheat.repository.BoothRepository;
import com.appdevg6.miamiheat.repository.ReservationRepository;
import com.appdevg6.miamiheat.repository.UserRepository;

@Service
public class ReservationService {

    @Autowired
    ReservationRepository resrepo;

    @Autowired
    UserRepository userRepo;

    @Autowired
    BoothRepository boothRepo;

    public ReservationService(ReservationRepository resrepo) {
        this.resrepo = resrepo;
    }

    public ReservationEntity createReservation(ReservationEntity reservation) {

        // Fix: correct getter name = getUser_id()
        if (reservation.getUser() != null) {
            Integer userId = reservation.getUser().getUserId();
            UserEntity user = userRepo.findById(userId).orElse(null);
            reservation.setUser(user);
        }

        // Fix: correct getter name = getBoothId()
        if (reservation.getBooth() != null) {
            Integer boothId = reservation.getBooth().getBoothId();
            BoothEntity booth = boothRepo.findById(boothId).orElse(null);
            reservation.setBooth(booth);
        }

        reservation.setStatus("upcoming");

        return resrepo.save(reservation);
    }

    public List<ReservationEntity> getAllReservations() {
        return resrepo.findAll();
    }

    public ReservationEntity updateReservation(int reservation_id, ReservationEntity newReservation) {
        ReservationEntity reservation = resrepo.findById(reservation_id)
                .orElseThrow(() -> new NoSuchElementException("Reservation " + reservation_id + " does not exist"));

        // Fix: correct setter names
        reservation.setReservationDate(newReservation.getReservationDate());
        reservation.setReservationTime(newReservation.getReservationTime());
        reservation.setDuration(newReservation.getDuration());

        return resrepo.save(reservation);
    }

    public String cancelReservation(int reservation_id) {
        ReservationEntity reservation = resrepo.findById(reservation_id)
                .orElseThrow(() -> new NoSuchElementException("Reservation " + reservation_id + " does not exist."));

        reservation.setStatus("cancelled");
        resrepo.save(reservation);

        return "Reservation " + reservation_id + " has been cancelled.";
    }
}
