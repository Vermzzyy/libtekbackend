package com.appdevg6.miamiheat.entity; 

import jakarta.persistence.Entity; 
import jakarta.persistence.GeneratedValue; 
import jakarta.persistence.GenerationType; 
import jakarta.persistence.Id; 
import jakarta.persistence.Table; 

@Entity 
@Table(name = "booth") 
public class BoothEntity { 
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Integer boothId; 
    
    private String boothName; 
    private String location; 
    private Integer maxCapacity; 
    private String availability; // available, full, maintenance 
    
    public BoothEntity() {} 
    
    public BoothEntity(String boothName, String location, Integer maxCapacity, String availability){ 
        this.boothName = boothName; 
        this.location = location; 
        this.maxCapacity = maxCapacity; 
        this.availability = availability; 
    } 
    
    public Integer getBoothId() { return boothId; }
    public void setBoothId(Integer boothId) { this.boothId = boothId; }

    public void setBoothName(String boothName) { this.boothName = boothName; } 
    public String getBoothName() { return boothName; } 
    
    public void setLocation(String location) { this.location = location; } 
    public String getLocation() { return location; } 
    
    public void setMaxCapacity(Integer maxCapacity) { this.maxCapacity = maxCapacity; } 
    public Integer getMaxCapacity() { return maxCapacity; } 
    
    public void setAvailability(String availability) { this.availability = availability; } 
    public String getAvailability() { return availability; } 

}