package com.example.bassam.khedmaapp.user.models;

/**
 * Created by bassam on 2/15/17.
 */

public class OldOrderRecyclerViewModel {

    String orderId,Service,rateState;

    public OldOrderRecyclerViewModel() {
    }

    public OldOrderRecyclerViewModel(String orderId, String rateState, String service) {
        this.orderId = orderId;
        this.rateState = rateState;
        Service = service;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getService() {
        return Service;
    }

    public void setService(String service) {
        Service = service;
    }

    public String getRateState() {
        return rateState;
    }

    public void setRateState(String rateState) {
        this.rateState = rateState;
    }
}
