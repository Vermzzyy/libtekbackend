package com.appdevg6.miamiheat.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.appdevg6.miamiheat.entity.ReservationEntity;
import com.appdevg6.miamiheat.service.ReservationService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("/api/reservation")
@CrossOrigin(origins = "*")
public class ReservationController {

    @Autowired
    ReservationService reservationService;

    @PostMapping("/newReservation")
    public ReservationEntity newReservation(@RequestBody ReservationEntity reservation) {
        return reservationService.createReservation(reservation);
    }

    @GetMapping("/getAllReservations")
    public List<ReservationEntity> getAllReservations() {
        return reservationService.getAllReservations();
    }
    
    @PutMapping("/update/{reservation_id}")
    public ReservationEntity updateReservation(@PathVariable int reservation_id, @RequestBody ReservationEntity newReservation) {
        return reservationService.updateReservation(reservation_id, newReservation);
    }

    //delete
    //@DeleteMapping("/delete/{reservation_id}")
    //public String deleteReservation(@PathVariable int reservation_id){
        //return reservationService.cancelReservation(reservation_id);
    //}

    @PutMapping("/cancel/{reservation_id}")
    public String cancelReservation(@PathVariable int reservation_id) {
        return reservationService.cancelReservation(reservation_id);
    }
    
}
