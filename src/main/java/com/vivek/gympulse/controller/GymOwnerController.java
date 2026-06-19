package com.vivek.gympulse.controller;

import com.vivek.gympulse.entity.GymOwner;
import com.vivek.gympulse.repository.GymOwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/owner")
public class GymOwnerController {

    @Autowired
    private GymOwnerRepository gymOwnerRepository;

    @PostMapping("/register")
    public GymOwner register(@RequestBody GymOwner gymOwner) {
        return gymOwnerRepository.save(gymOwner);
    }
}