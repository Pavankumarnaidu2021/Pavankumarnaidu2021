package com.file.app.durgafileupload.service;

import com.file.app.durgafileupload.entity.AppiontmentDetails;
import com.file.app.durgafileupload.repo.AppiontmentDetailsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppiontmentDetailsServiceImpl implements IAppiontmentDetailsService {

    @Autowired
    private AppiontmentDetailsRepo detailsRepo;

    @Override
    public AppiontmentDetails getAppiontmentDetails(Integer apptId) {
        return detailsRepo.getById(apptId);
    }

    @Override
    public void saveAppiontmentDetails(AppiontmentDetails appiontmentDetails) {
        detailsRepo.save(appiontmentDetails);
    }

    @Override
    public List<AppiontmentDetails> listAllAppointDetails() {
        return detailsRepo.findAll();
    }
}
