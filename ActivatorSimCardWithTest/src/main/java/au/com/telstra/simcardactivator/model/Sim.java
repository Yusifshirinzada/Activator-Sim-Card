package au.com.telstra.simcardactivator.model;

import au.com.telstra.simcardactivator.record.Record;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@JsonIgnoreProperties(ignoreUnknown = true)
public class Sim {


    private String iccid;
    private String customerEmail;
    private boolean active;

    public Sim() {
    }

    public Sim(String iccid, String customerEmail, boolean active) {
        this.iccid = iccid;
        this.customerEmail = customerEmail;
        this.active = active;
    }

    public Sim(Record record){
        this.iccid=record.getIccid();
        this.customerEmail=record.getCostumerEmail();
        this.active=record.isActivate();
    }

    public String getIccid() {
        return iccid;
    }

    public void setIccid(String iccid) {
        this.iccid = iccid;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }


}
