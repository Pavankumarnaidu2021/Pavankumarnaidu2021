package com.file.app.durgafileupload.service;

import com.file.app.durgafileupload.entity.AppiontmentDetails;

import java.util.List;

public interface IAppiontmentDetailsService {

    public AppiontmentDetails getAppiontmentDetails(Integer apptId);

    public void saveAppiontmentDetails(AppiontmentDetails appiontmentDetails);

    public List<AppiontmentDetails> listAllAppointDetails();
}
