package com.vivek.gympulse.controller;

import com.vivek.gympulse.dto.DashboardDTO;
import com.vivek.gympulse.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DashboardController {

    @Autowired
    private MemberService memberService;

    @GetMapping("/dashboard")
    public DashboardDTO getDashboard() {
        return memberService.getDashboardData();
    }
}