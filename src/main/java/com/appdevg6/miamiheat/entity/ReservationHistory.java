package com.appdevg6.miamiheat.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "history")
public class ReservationHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer historyId;

    private String startTime;
    private String endTime;
    private String status;

    @ManyToOne
    @JoinColumn(name = "reservationId")
    private ReservationEntity reservation;

    @ManyToOne
    @JoinColumn(name = "userId")
    private UserEntity user;

    @ManyToOne
    @JoinColumn(name = "boothId")
    private BoothEntity booth;

    public ReservationHistory() {}

    public ReservationHistory(String startTime, String endTime, String status) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.status = status;
    }

    public Integer getHistoryId() { return historyId; }
    public void setHistoryId(Integer historyId) { this.historyId = historyId; }

    public String getStartTime() { return startTime; }
    public void setStartTime(String startTime) { this.startTime = startTime; }

    public String getEndTime() { return endTime; }
    public void setEndTime(String endTime) { this.endTime = endTime; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public ReservationEntity getReservation() { return reservation; }
    public void setReservation(ReservationEntity reservation) { this.reservation = reservation; }

    public UserEntity getUser() { return user; }
    public void setUser(UserEntity user) { this.user = user; }

    public BoothEntity getBooth() { return booth; }
    public void setBooth(BoothEntity booth) { this.booth = booth; }
}
