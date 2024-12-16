package com.LoanManagement.LoanManagement.Repositatory;

import com.LoanManagement.LoanManagement.CustomerEntity.CustomerDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerDetailsReposiatory extends JpaRepository <CustomerDetails,Integer> {




}
