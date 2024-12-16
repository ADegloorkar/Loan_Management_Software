package com.LoanManagement.LoanManagement.Repositatory;

import com.LoanManagement.LoanManagement.LoanEntity.LoanDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoanDetailsRepositatory extends JpaRepository<LoanDetails, Integer> {
}
