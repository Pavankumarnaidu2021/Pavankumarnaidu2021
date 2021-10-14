package com.file.app.durgafileupload.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "bedstable")
public class ICUBeds {

    @Id
    @Column(name = "bedid")
    private Integer bedId;
    @Column(name = "roomnumber")
    private Integer roomNumber;
    @Column(name = "avail")
    private String isAvalable;
    @Column(name = "booked")
    private String isBooked;

    public Integer getBedId() {
        return bedId;
    }

    public void setBedId(Integer bedId) {
        this.bedId = bedId;
    }

    public Integer getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(Integer roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getIsAvalable() {
        return isAvalable;
    }

    public void setIsAvalable(String isAvalable) {
        this.isAvalable = isAvalable;
    }

    public String getIsBooked() {
        return isBooked;
    }

    public void setIsBooked(String isBooked) {
        this.isBooked = isBooked;
    }

    @Override
    public String toString() {
        return "ICUBeds{" +
                "bedId=" + bedId +
                ", roomNumber=" + roomNumber +
                ", isAvalable=" + isAvalable +
                ", isBooked=" + isBooked +
                '}';
    }
}
