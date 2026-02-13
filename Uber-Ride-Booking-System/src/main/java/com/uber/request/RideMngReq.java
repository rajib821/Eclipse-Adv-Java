package com.uber.request;

import com.uber.entity.RideStatus;

public class RideMngReq {

    private String source;
    private String destination;
    private int fare;
    private int riderId;
    private int driverId;
    private RideStatus status;

    public String getSource() {
        return source;
    }
    public void setSource(String source) {
        this.source = source;
    }

    public String getDestination() {
        return destination;
    }
    public void setDestination(String destination) {
        this.destination = destination;
    }

    public int getFare() {
        return fare;
    }
    public void setFare(int fare) {
        this.fare = fare;
    }

    public int getRiderId() {
        return riderId;
    }
    public void setRiderId(int riderId) {
        this.riderId = riderId;
    }

    public int getDriverId() {
        return driverId;
    }
    public void setDriverId(int driverId) {
        this.driverId = driverId;
    }

    public RideStatus getStatus() {
        return status;
    }
    public void setStatus(RideStatus status) {
        this.status = status;
    }
}
