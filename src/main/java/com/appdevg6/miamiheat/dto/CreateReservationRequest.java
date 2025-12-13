package com.appdevg6.miamiheat.dto;

public class CreateReservationRequest {
    private Integer user_id;  
    private Integer booth_id;
    private String reservation_date;
    private String reservation_time;
    private String duration;

    public Integer getUser_id() { return user_id; }
    public void setUser_id(Integer user_id) { this.user_id = user_id; }

    public Integer getBooth_id() { return booth_id; }
    public void setBooth_id(Integer booth_id) { this.booth_id = booth_id; }

    public String getReservation_date() { return reservation_date; }
    public void setReservation_date(String reservation_date) { this.reservation_date = reservation_date; }

    public String getReservation_time() { return reservation_time; }
    public void setReservation_time(String reservation_time) { this.reservation_time = reservation_time; }

    public String getDuration() { return duration; }
    public void setDuration(String duration) { this.duration = duration; }
}

