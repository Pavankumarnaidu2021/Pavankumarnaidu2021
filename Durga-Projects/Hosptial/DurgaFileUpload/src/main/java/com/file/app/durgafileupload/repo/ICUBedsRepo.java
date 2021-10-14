package com.file.app.durgafileupload.repo;

import com.file.app.durgafileupload.entity.ICUBeds;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICUBedsRepo extends JpaRepository<ICUBeds, Integer> {
}
