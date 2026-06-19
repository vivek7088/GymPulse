package com.vivek.gympulse.repository;

import com.vivek.gympulse.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
public interface MemberRepository extends JpaRepository<Member, Long> {
    @Query("SELECT COUNT(m) FROM Member m WHERE m.status = 'ACTIVE'")
    long countActiveMembers();

    @Query("SELECT COUNT(m) FROM Member m WHERE m.status = 'EXPIRED'")
    long countExpiredMembers();
}