package com.visa.mada.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.visa.mada.Model.VisaHistory;
import com.visa.mada.Model.VisaHistoryId;

@Repository
public interface VisaHistoryRepository extends JpaRepository<VisaHistory, VisaHistoryId> {
}