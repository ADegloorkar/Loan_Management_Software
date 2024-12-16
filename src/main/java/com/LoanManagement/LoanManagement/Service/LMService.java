package com.LoanManagement.LoanManagement.Service;

import com.LoanManagement.LoanManagement.CustomerEntity.CustomerDetails;
import com.LoanManagement.LoanManagement.LoanEntity.LoanDetails;
import com.LoanManagement.LoanManagement.Repositatory.LoanDetailsRepositatory;
import com.LoanManagement.LoanManagement.Repositatory.CustomerDetailsReposiatory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LMService {

@Autowired
public CustomerDetailsReposiatory customerDetailsReposiatory;

@Autowired
public LoanDetailsRepositatory loanDetailsRepositatory;



public CustomerDetails saveData(CustomerDetails customerDetails) {
    return customerDetailsReposiatory.save(customerDetails);
}

public LoanDetails saveLoanData(LoanDetails loanDetails) {
    return loanDetailsRepositatory.save(loanDetails);
}

public List<CustomerDetails> getAllCustdetails() {
    return customerDetailsReposiatory.findAll();
}

public List<LoanDetails> getAllLoanDetails() {
    return loanDetailsRepositatory.findAll();
}

public CustomerDetails getCustbyId(Integer id) {
    return customerDetailsReposiatory.findById(id)
            .orElseThrow(() -> new RuntimeException("Customer not found with ID " + id));
}

public LoanDetails getLoanDetailsbyId(Integer id) {
    return loanDetailsRepositatory.findById(id)
            .orElseThrow(() -> new RuntimeException("Loan not found with ID " + id));
}

public CustomerDetails UpdateCust(Integer id, CustomerDetails updatedCustomer) {
    CustomerDetails existingCustomer = getCustbyId(id);
    existingCustomer.setName(updatedCustomer.getName());
    existingCustomer.setAddress(updatedCustomer.getAddress());
    existingCustomer.setAddharnu(updatedCustomer.getAddharnu());
    existingCustomer.setAge(updatedCustomer.getAge());
    existingCustomer.setOccupation(updatedCustomer.getOccupation());
    existingCustomer.setMobilenu(updatedCustomer.getMobilenu());
    existingCustomer.setPancardno(updatedCustomer.getPancardno());
    return customerDetailsReposiatory.save(existingCustomer);
}

public LoanDetails updateLoanDetails(Integer id, LoanDetails updatedLoanDetails) {
    LoanDetails existingLoan = getLoanDetailsbyId(id);
    existingLoan.setAmount(updatedLoanDetails.getAmount());
    existingLoan.setIntrestRate(updatedLoanDetails.getIntrestRate());
    existingLoan.setStartDate(updatedLoanDetails.getStartDate());
    existingLoan.setEndDate(updatedLoanDetails.getEndDate());
    return loanDetailsRepositatory.save(existingLoan);
}

public void deleteCustomer(Integer id) {
    if (!customerDetailsReposiatory.existsById(id)) {
        throw new RuntimeException("Customer not found with ID " + id);
    }
    customerDetailsReposiatory.deleteById(id);
}

public void deleteLoanDetails(Integer id) {
    if (!loanDetailsRepositatory.existsById(id)) {
        throw new RuntimeException("Loan not found with ID " + id);
    }
    loanDetailsRepositatory.deleteById(id);
}




}
