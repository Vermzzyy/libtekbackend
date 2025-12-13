package com.appdevg6.miamiheat.entity; 

import jakarta.persistence.Entity; 
import jakarta.persistence.GeneratedValue; 
import jakarta.persistence.GenerationType; 
import jakarta.persistence.Id; 
import jakarta.persistence.JoinColumn; 
import jakarta.persistence.ManyToOne; 
import jakarta.persistence.Table; 

@Entity 
@Table(name = "reservation") 

public class ReservationEntity { 
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Integer reservationId; 
    
    private String reservationDate; 
    private String reservationTime; 
    private String duration; 
    private String status; // upcoming, completed, cancelled 
    
    @ManyToOne 
    @JoinColumn(name = "userId") 
    private UserEntity user; 
    
    @ManyToOne 
    @JoinColumn(name = "boothId") 
    private BoothEntity booth; 
    
    public ReservationEntity() {} 
    
    public ReservationEntity(String reservationDate, String reservationTime, String duration, String status){ 
        this.reservationDate = reservationDate; 
        this.reservationTime = reservationTime; 
        this.duration = duration; 
        this.status = status; 
    
    } 
    
    public void setReservationId(Integer reservationId) { this.reservationId = reservationId; } 
    public Integer getReservationId() { return reservationId; } 
    
    public void setReservationDate(String reservationDate) { this.reservationDate = reservationDate; } 
    public String getReservationDate() { return reservationDate; } 
    
    public void setReservationTime(String reservationTime) { this.reservationTime = reservationTime; } 
    public String getReservationTime() { return reservationTime; } 
    
    public void setDuration(String duration) { this.duration = duration; } 
    public String getDuration() { return duration; } 
    
    public void setStatus(String status) { this.status = status; } 
    public String getStatus() { return status; } 
    
    public UserEntity getUser() { return user; } 
    public void setUser(UserEntity user) { this.user = user; } 
    
    public BoothEntity getBooth() { return booth; } 
    public void setBooth(BoothEntity booth) { this.booth = booth; } 

}