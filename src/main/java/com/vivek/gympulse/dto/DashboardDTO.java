package com.vivek.gympulse.dto;

public class DashboardDTO {

    private long totalMembers;
    private long activeMembers;
    private long expiredMembers;

    public DashboardDTO(long totalMembers, long activeMembers, long expiredMembers) {
        this.totalMembers = totalMembers;
        this.activeMembers = activeMembers;
        this.expiredMembers = expiredMembers;
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
}