package com.file.app.durgafileupload.service;

import com.file.app.durgafileupload.entity.ICUBeds;
import com.file.app.durgafileupload.repo.ICUBedsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ICUBedsServiceImpl implements ICUBedsService {

    @Autowired
    private ICUBedsRepo bedsRepo;

    @Override
    public ICUBeds getIcuBedById(Integer bedID) {
        return bedsRepo.getById(bedID);
    }

    @Override
    public List<ICUBeds> getAllIcuBeds() {
        return bedsRepo.findAll();
    }

    @Override
    public void createBed(ICUBeds icuBeds) {
        bedsRepo.save(icuBeds);
    }
}
