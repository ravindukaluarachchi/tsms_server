/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tsms.entity;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import javax.persistence.*;

/**
 *
 * @author ravindu
 */
@Entity
public class Tour implements Serializable {
    public final static int REQUESTED = 0;
    public final static int Confirmed = 1;
    public final static int Finished = 2;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @OneToOne(cascade = CascadeType.MERGE)
    private Location location;
    private Float distance = 0F;
    private Long startMeter = 0L;
    private Long endMeter = 0L;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Calendar startDate;
    private Integer noOfDays;
    @Temporal(javax.persistence.TemporalType.TIME)
    private Calendar startTime;
    @Temporal(javax.persistence.TemporalType.TIME)
    private Calendar endTime;
    private String paymentType;
    @OneToOne(cascade= CascadeType.MERGE)
    private Customer customer;
    private Float rate;
    @OneToOne(cascade= CascadeType.MERGE)
    private Vehicle vehicle;
    @OneToOne(cascade= CascadeType.MERGE)
    private Driver driver;
    private Integer status = REQUESTED;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
    

    public Integer getNoOfDays() {
        return noOfDays;
    }

    public void setNoOfDays(Integer noOfDays) {
        this.noOfDays = noOfDays;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Float getDistance() {
        return distance;
    }

    public void setDistance(Float distance) {
        this.distance = distance;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public Long getEndMeter() {
        return endMeter;
    }

    public void setEndMeter(Long endMeter) {
        this.endMeter = endMeter;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public Long getStartMeter() {
        return startMeter;
    }

    public void setStartMeter(Long startMeter) {
        this.startMeter = startMeter;
    }

    public Calendar getStartDate() {
        return startDate;
    }

    public void setStartDate(Calendar startDate) {
        this.startDate = startDate;
    }

    public Calendar getStartTime() {
        return startTime;
    }

    public void setStartTime(Calendar startTime) {
        this.startTime = startTime;
    }

    public Calendar getEndTime() {
        return endTime;
    }

    public void setEndTime(Calendar endTime) {
        this.endTime = endTime;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public Float getRate() {
        return rate;
    }

    public void setRate(Float rate) {
        this.rate = rate;
    }


    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tour)) {
            return false;
        }
        Tour other = (Tour) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.tabona.entity.Tour[ id=" + id + " ]";
    }
    
}
