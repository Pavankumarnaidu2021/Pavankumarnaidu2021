package com.file.app.durgafileupload.repo;

import com.file.app.durgafileupload.entity.AppiontmentDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppiontmentDetailsRepo extends JpaRepository<AppiontmentDetails, Integer> {
}
