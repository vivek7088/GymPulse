package com.vivek.gympulse.controller;

import com.vivek.gympulse.entity.Member;
import com.vivek.gympulse.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/member")
public class MemberController {

    @Autowired
    private MemberService memberService;

    @PostMapping("/add")
    public Member addMember(@RequestBody Member member) {
        return memberService.saveMember(member);
    }
    @GetMapping("/all")
    public List<Member> getAllMembers() {
        return memberService.getAllMembers();
    }
    @GetMapping("/pending")
    public List<Member> getPendingMembers() {
        return memberService.getPendingMembers();
    }
}