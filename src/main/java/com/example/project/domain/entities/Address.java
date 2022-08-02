package com.example.project.domain.entities;

import com.example.project.domain.entities.enums.AddressType;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity
public class Address extends AbstractPersistable<Long> {
    private String road;
    private Integer number;
    private String district;
    private String city;
    private String state;
    @Enumerated(EnumType.STRING)
    private AddressType addressType;

    public Address() {
    }

    public Address(String road, Integer number, String district, String city, String state, AddressType addressType) {
        this.road = road;
        this.number = number;
        this.district = district;
        this.city = city;
        this.state = state;
        this.addressType = addressType;
    }

    public String getRoad() {
        return road;
    }

    public void setRoad(String road) {
        this.road = road;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public AddressType getAddressType() {
        return addressType;
    }

    public void setAddressType(AddressType addressType) {
        this.addressType = addressType;
    }
}
