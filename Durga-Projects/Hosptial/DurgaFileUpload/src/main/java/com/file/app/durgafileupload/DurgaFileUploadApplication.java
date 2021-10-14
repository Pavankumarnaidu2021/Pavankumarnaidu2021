package com.file.app.durgafileupload;

import com.file.app.durgafileupload.entity.ICUBeds;
import com.file.app.durgafileupload.service.ICUBedsServiceImpl;
import com.file.app.durgafileupload.service.TestClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class DurgaFileUploadApplication {

    public static void main(String[] args) {
        SpringApplication.run(DurgaFileUploadApplication.class, args);
    }

    @Autowired
    private ICUBedsServiceImpl service;

    @PostConstruct
    public void  insertDataInToDb() {
        ICUBeds icuBeds = new ICUBeds();
        icuBeds.setBedId(100);
        icuBeds.setRoomNumber(104);
        icuBeds.setIsAvalable("true");
        icuBeds.setIsBooked("true");
        service.createBed(icuBeds);
    }

}
