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

        List<Member> members = memberRepository.findAll();

        for (Member member : members) {

            if (member.getExpiryDate() != null &&
                    member.getExpiryDate().isBefore(LocalDate.now())) {

                member.setStatus("EXPIRED");

            } else {

                member.setStatus("ACTIVE");
            }

            memberRepository.save(member);
        }

        return members;
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
    public Member updateMember(Long id, Member updatedMember) {

        Member member = memberRepository.findById(id).orElseThrow();

        member.setName(updatedMember.getName());
        member.setPhone(updatedMember.getPhone());
        member.setFeesAmount(updatedMember.getFeesAmount());
        member.setJoiningDate(updatedMember.getJoiningDate());
        member.setExpiryDate(updatedMember.getExpiryDate());
        member.setStatus(updatedMember.getStatus());
        member.setPlanType(updatedMember.getPlanType());
        member.setPlanMonths(updatedMember.getPlanMonths());

        return memberRepository.save(member);
    }
    public void deleteMember(Long id) {
        memberRepository.deleteById(id);
    }

}