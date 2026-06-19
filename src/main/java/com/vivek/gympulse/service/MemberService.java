package com.vivek.gympulse.service;

import com.vivek.gympulse.entity.Member;
import com.vivek.gympulse.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import com.vivek.gympulse.dto.DashboardDTO;

@Service
public class MemberService {

    @Autowired
    private MemberRepository memberRepository;

    public Member saveMember(Member member) {
        return memberRepository.save(member);
    }
    public List<Member> getAllMembers() {
        return memberRepository.findAll();
    }
    public DashboardDTO getDashboardData() {

        long totalMembers = memberRepository.count();

        long activeMembers = memberRepository.countActiveMembers();

        long expiredMembers = memberRepository.countExpiredMembers();

        return new DashboardDTO(
                totalMembers,
                activeMembers,
                expiredMembers
        );
    }
}