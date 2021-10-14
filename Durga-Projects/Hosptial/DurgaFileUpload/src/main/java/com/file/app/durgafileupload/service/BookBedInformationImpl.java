package com.file.app.durgafileupload.service;

import com.file.app.durgafileupload.entity.BookBedInformation;
import com.file.app.durgafileupload.repo.BookBedInformationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookBedInformationImpl implements IBookBedInformation {

    @Autowired
    private BookBedInformationRepo repo;

    @Override
    public void saveBookingInfo(BookBedInformation bookBedInformation) {
        repo.save(bookBedInformation);
    }

    @Override
    public BookBedInformation getBookBedInformationById(Integer infoId) {
        return repo.getById(infoId);
    }

    @Override
    public List<BookBedInformation> listBookBedInformations() {
        return repo.findAll();
    }
}
