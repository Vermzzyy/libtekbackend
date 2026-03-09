package com.appdevg6.miamiheat.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.appdevg6.miamiheat.entity.BoothEntity;
import com.appdevg6.miamiheat.service.BoothService;
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
@RequestMapping("/api/booth")
@CrossOrigin(origins = "*")
public class BoothController {

    @Autowired
    BoothService boothService;

    @PostMapping("/createBooth")
    public BoothEntity createBooth(@RequestBody BoothEntity booth) {
        return boothService.createBooth(booth);
    }

    @GetMapping("/getAllBooths")
    public List<BoothEntity> getAllBooths() {
        return boothService.getAllBooths();
    }

    @PutMapping("/updateBooth/{boothId}")
    public BoothEntity updateBooth(@PathVariable int boothId, @RequestBody BoothEntity newBooth) {
        return boothService.updateBooth(boothId, newBooth);
    }

    @DeleteMapping("/deleteBooth/{boothId}")
    public String deleteBooth(@PathVariable int boothId){
        return boothService.deleteBooth(boothId);
    }
    
}
