package com.file.app.durgafileupload.entity;

import javax.persistence.*;

@Entity
@Table(name = "bookinginfo")
public class BookBedInformation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer BookBedInformationId;
    private String patientName;
    private String patientAge;
    private String patientAddr;
    private String patientGender;
    private String roomNum;
    private String bedNum;

    public Integer getBookBedInformationId() {
        return BookBedInformationId;
    }

    public void setBookBedInformationId(Integer bookBedInformationId) {
        BookBedInformationId = bookBedInformationId;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getPatientAge() {
        return patientAge;
    }

    public void setPatientAge(String patientAge) {
        this.patientAge = patientAge;
    }

    public String getPatientAddr() {
        return patientAddr;
    }

    public void setPatientAddr(String patientAddr) {
        this.patientAddr = patientAddr;
    }

    public String getPatientGender() {
        return patientGender;
    }

    public void setPatientGender(String patientGender) {
        this.patientGender = patientGender;
    }

    public String getRoomNum() {
        return roomNum;
    }

    public void setRoomNum(String roomNum) {
        this.roomNum = roomNum;
    }

    public String getBedNum() {
        return bedNum;
    }

    public void setBedNum(String bedNum) {
        this.bedNum = bedNum;
    }

    @Override
    public String toString() {
        return "BookBedInformation{" +
                "BookBedInformationId=" + BookBedInformationId +
                ", patientName='" + patientName + '\'' +
                ", patientAge='" + patientAge + '\'' +
                ", patientAddr='" + patientAddr + '\'' +
                ", patientGender='" + patientGender + '\'' +
                ", roomNum='" + roomNum + '\'' +
                ", bedNum='" + bedNum + '\'' +
                '}';
    }
}
