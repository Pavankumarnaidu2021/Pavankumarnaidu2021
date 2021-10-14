package com.file.app.durgafileupload.service;

import com.file.app.durgafileupload.entity.ICUBeds;

import java.util.List;

public interface ICUBedsService {

    public ICUBeds getIcuBedById(Integer bedID);

    public List<ICUBeds> getAllIcuBeds();

    public void createBed(ICUBeds icuBeds);
}
