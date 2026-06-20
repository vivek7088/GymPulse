package com.vivek.gympulse.repository;

import com.vivek.gympulse.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;
public interface MemberRepository extends JpaRepository<Member, Long> {
    @Query("SELECT COUNT(m) FROM Member m WHERE m.status = 'ACTIVE'")
    long countActiveMembers();

    @Query("SELECT COUNT(m) FROM Member m WHERE m.status = 'EXPIRED'")
    long countExpiredMembers();
    List<Member> findByExpiryDateBefore(java.time.LocalDate date);

    @Query("SELECT m FROM Member m WHERE m.expiryDate < CURRENT_DATE")
    List<Member> findPendingMembers();
    @Query("SELECT COUNT(m) FROM Member m WHERE m.expiryDate < CURRENT_DATE")
    long countPendingMembers();
    @Query("SELECT COALESCE(SUM(m.feesAmount),0) FROM Member m WHERE m.expiryDate < CURRENT_DATE")
    Double getTotalPendingAmount();
}