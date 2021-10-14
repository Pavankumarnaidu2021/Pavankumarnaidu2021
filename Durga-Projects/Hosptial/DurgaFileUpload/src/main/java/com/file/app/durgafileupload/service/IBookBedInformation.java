package com.file.app.durgafileupload.service;

import com.file.app.durgafileupload.entity.BookBedInformation;

import java.util.List;

public interface IBookBedInformation {

    public void saveBookingInfo(BookBedInformation bookBedInformation);

    public BookBedInformation getBookBedInformationById(Integer infoId);

    List<BookBedInformation> listBookBedInformations();
}
