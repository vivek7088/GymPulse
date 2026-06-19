package com.vivek.gympulse.repository;

import com.vivek.gympulse.entity.GymOwner;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GymOwnerRepository extends JpaRepository<GymOwner, Long> {
}