package com.demo.producer;

public class RiderStatus {

    private String riderId;
    private String status;

    public RiderStatus() {}

    public RiderStatus(String riderId, String status) {
        this.riderId = riderId;
        this.status = status;
    }

    public String getRiderId() {
        return riderId;
    }

    public String getStatus() {
        return status;
    }
}