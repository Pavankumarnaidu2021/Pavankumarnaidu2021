package com.file.app.durgafileupload.entity;

import javax.persistence.*;

@Entity
@Table(name = "appointmentdetails")
public class AppiontmentDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer appiontmentDetailsId;
    private String patientName;
    private String patentAge;
    private String appintMentDate;
    private String problem;

    public Integer getAppiontmentDetailsId() {
        return appiontmentDetailsId;
    }

    public void setAppiontmentDetailsId(Integer appiontmentDetailsId) {
        this.appiontmentDetailsId = appiontmentDetailsId;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getPatentAge() {
        return patentAge;
    }

    public void setPatentAge(String patentAge) {
        this.patentAge = patentAge;
    }

    public String getAppintMentDate() {
        return appintMentDate;
    }

    public void setAppintMentDate(String appintMentDate) {
        this.appintMentDate = appintMentDate;
    }

    public String getProblem() {
        return problem;
    }

    public void setProblem(String problem) {
        this.problem = problem;
    }

    @Override
    public String toString() {
        return "AppiontmentDetails{" +
                "appiontmentDetailsId=" + appiontmentDetailsId +
                ", patientName='" + patientName + '\'' +
                ", patentAge='" + patentAge + '\'' +
                ", appintMentDate='" + appintMentDate + '\'' +
                ", problem='" + problem + '\'' +
                '}';
    }
}
