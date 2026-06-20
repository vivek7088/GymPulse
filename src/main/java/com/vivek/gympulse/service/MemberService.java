package com.vivek.gympulse.service;

import com.vivek.gympulse.entity.Member;
import com.vivek.gympulse.repository.MemberRepository;
import com.vivek.gympulse.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.time.LocalDate;


import com.vivek.gympulse.dto.DashboardDTO;

@Service
public class MemberService {

    @Autowired
    private MemberRepository memberRepository;
    @Autowired
    private PaymentRepository paymentRepository;

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

        long pendingMembers = memberRepository.countPendingMembers();

        Double totalIncome = paymentRepository.getTotalIncome();
        Double totalPendingAmount = memberRepository.getTotalPendingAmount();

        return new DashboardDTO(
                totalMembers,
                activeMembers,
                expiredMembers,
                pendingMembers,
                totalIncome,
                totalPendingAmount
        );
    }
    public List<Member> getPendingMembers() {
        return memberRepository.findPendingMembers();
    }
    public Member renewMember(Long id) {

        Member member = memberRepository.findById(id).orElseThrow();

        Integer months = member.getPlanMonths();

        member.setExpiryDate(
                member.getExpiryDate().plusMonths(months)
        );

        member.setStatus("ACTIVE");

        return memberRepository.save(member);
    }
}