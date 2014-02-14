/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tsms.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author ravindu
 */
@Entity
public class Driver implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(length=10,unique=true)
    private String nic;
    @Column(length=10)
    private String telephone1;
    @Column(length=10)
    private String telephone2;
    @Column(length=10)
    private String mobile;
    @Column(length=10)
    private String mobile2;
    private String licenceNumber;
    private String postalCode1;
    private String address1;
    private String city1;
    private String country1;
    private String postalCode2;
    private String address2;
    private String city2;
    private String country2;
    @Column(length = 5000)
    private String experience;
    private String firstName;
    private String lastName;
    private String bloodGroup;
    private String title;
    private String emergenceyContactName;
    private String emergenceyContactNumber;
    private String emergenceyContactRelationship;    
    private String sex;
    private String martialStatus;

    public String getMartialStatus() {
        return martialStatus;
    }

    public void setMartialStatus(String martialStatus) {
        this.martialStatus = martialStatus;
    }
    
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getEmergenceyContactName() {
        return emergenceyContactName;
    }

    public void setEmergenceyContactName(String emergenceyContactName) {
        this.emergenceyContactName = emergenceyContactName;
    }

    public String getEmergenceyContactNumber() {
        return emergenceyContactNumber;
    }

    public void setEmergenceyContactNumber(String emergenceyContactNumber) {
        this.emergenceyContactNumber = emergenceyContactNumber;
    }

    public String getEmergenceyContactRelationship() {
        return emergenceyContactRelationship;
    }

    public void setEmergenceyContactRelationship(String emergenceyContactRelationship) {
        this.emergenceyContactRelationship = emergenceyContactRelationship;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public String getLicenceNumber() {
        return licenceNumber;
    }

    public void setLicenceNumber(String licenceNumber) {
        this.licenceNumber = licenceNumber;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public String getTelephone1() {
        return telephone1;
    }

    public void setTelephone1(String telephone1) {
        this.telephone1 = telephone1;
    }

    public String getTelephone2() {
        return telephone2;
    }

    public void setTelephone2(String telephone2) {
        this.telephone2 = telephone2;
    }

    public String getMobile2() {
        return mobile2;
    }

    public void setMobile2(String mobile2) {
        this.mobile2 = mobile2;
    }

    public String getPostalCode1() {
        return postalCode1;
    }

    public void setPostalCode1(String postalCode1) {
        this.postalCode1 = postalCode1;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getCity1() {
        return city1;
    }

    public void setCity1(String city1) {
        this.city1 = city1;
    }

    public String getCountry1() {
        return country1;
    }

    public void setCountry1(String country1) {
        this.country1 = country1;
    }

    public String getPostalCode2() {
        return postalCode2;
    }

    public void setPostalCode2(String postalCode2) {
        this.postalCode2 = postalCode2;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getCity2() {
        return city2;
    }

    public void setCity2(String city2) {
        this.city2 = city2;
    }

    public String getCountry2() {
        return country2;
    }

    public void setCountry2(String country2) {
        this.country2 = country2;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + (this.nic != null ? this.nic.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Driver other = (Driver) obj;
        if ((this.nic == null) ? (other.nic != null) : !this.nic.equals(other.nic)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Driver{" + "nic=" + nic + ", telephone1=" + telephone1 + ", telephone2=" + telephone2 + ", mobile=" + mobile + ", mobile2=" + mobile2 + ", licenceNumber=" + licenceNumber + ", postalCode1=" + postalCode1 + ", address1=" + address1 + ", city1=" + city1 + ", country1=" + country1 + ", postalCode2=" + postalCode2 + ", address2=" + address2 + ", city2=" + city2 + ", country2=" + country2 + ", experience=" + experience + ", firstName=" + firstName + ", lastName=" + lastName + ", bloodGroup=" + bloodGroup + ", title=" + title + ", emergenceyContactName=" + emergenceyContactName + ", emergenceyContactNumber=" + emergenceyContactNumber + ", emergenceyContactRelationship=" + emergenceyContactRelationship + '}';
    }


   
}
