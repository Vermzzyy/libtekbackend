package com.appdevg6.miamiheat.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appdevg6.miamiheat.entity.BoothEntity;
import com.appdevg6.miamiheat.repository.BoothRepository;

@Service
public class BoothService {

    @Autowired
    BoothRepository boothRepo;

    public BoothService(BoothRepository boothRepo){
        this.boothRepo = boothRepo;
    }

    public BoothEntity createBooth(BoothEntity booth){
        return boothRepo.save(booth);
    }

    public List<BoothEntity> getAllBooths(){
        return boothRepo.findAll();
    }

    public BoothEntity updateBooth(int boothId, BoothEntity newBooth){
        
        BoothEntity booth = boothRepo.findById(boothId)
                .orElseThrow(() -> new NoSuchElementException("Booth " + boothId + " does not exist!"));

        booth.setBoothName(newBooth.getBoothName());
        booth.setLocation(newBooth.getLocation()); // important fix
        booth.setMaxCapacity(newBooth.getMaxCapacity());
        booth.setAvailability(newBooth.getAvailability());

        return boothRepo.save(booth);
    }

    public String deleteBooth(Integer boothId){

        if (boothRepo.existsById(boothId)) {
            boothRepo.deleteById(boothId);
            return "Booth " + boothId + " is successfully deleted!";
        }

        return "Booth " + boothId + " does not exist!";
    }
}
