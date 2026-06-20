package com.vivek.gympulse.dto;

public class DashboardDTO {

    private long totalMembers;
    private long activeMembers;
    private long expiredMembers;
    private long pendingMembers;
    private Double totalIncome;

    public DashboardDTO(long totalMembers,
                        long activeMembers,
                        long expiredMembers,
                        long pendingMembers,
                        Double totalIncome) {

        this.totalMembers = totalMembers;
        this.activeMembers = activeMembers;
        this.expiredMembers = expiredMembers;
        this.pendingMembers = pendingMembers;
        this.totalIncome = totalIncome;
    }

    public long getTotalMembers() {
        return totalMembers;
    }

    public long getActiveMembers() {
        return activeMembers;
    }

    public long getExpiredMembers() {
        return expiredMembers;
    }

    public long getPendingMembers() {
        return pendingMembers;
    }

    public Double getTotalIncome() {
        return totalIncome;
    }
}