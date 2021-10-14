package com.file.app.durgafileupload.repo;

import com.file.app.durgafileupload.entity.BookBedInformation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookBedInformationRepo extends JpaRepository<BookBedInformation, Integer> {
}
