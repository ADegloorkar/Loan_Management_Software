package com.LoanManagement.LoanManagement.Controller;

import com.LoanManagement.LoanManagement.CustomerEntity.CustomerDetails;
import com.LoanManagement.LoanManagement.LoanEntity.LoanDetails;
import com.LoanManagement.LoanManagement.Service.LMService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController 
@RequestMapping("/api")
public class LMController {

   @Autowired
   public   LMService lmService;

   @PostMapping  ("/customers")
   public CustomerDetails savedetails (@RequestBody CustomerDetails customerDetails)
   {
       return lmService.saveData(customerDetails);
   }

   @PostMapping ("/loans")
    public ResponseEntity<LoanDetails> addLoan(@RequestBody LoanDetails loanDetails) {
        LoanDetails savedLoan = lmService.saveLoanData(loanDetails);
        return ResponseEntity.ok(savedLoan);
    }

  @GetMapping("/customers")
  public List<CustomerDetails> getAllCustomers() {
    return lmService.getAllCustdetails();
}

@GetMapping("/loans")
public List<LoanDetails> getAllLoans() {
    return lmService.getAllLoanDetails();
}


@GetMapping("/customers/{id}")
public ResponseEntity<CustomerDetails> getCustomerById(@PathVariable Integer id) {
    CustomerDetails customer = lmService.getCustbyId(id);
    return ResponseEntity.ok(customer);
}

@GetMapping("/loans/{id}")
public ResponseEntity<LoanDetails> getLoanById(@PathVariable Integer id) {
    LoanDetails loan = lmService.getLoanDetailsbyId(id);
    return ResponseEntity.ok(loan);
}


@PutMapping("/customers/{id}")
public ResponseEntity<CustomerDetails> updateCustomer(@PathVariable Integer id, @RequestBody CustomerDetails updatedCustomer) {
    CustomerDetails updated = lmService.UpdateCust(id, updatedCustomer);
    return ResponseEntity.ok(updated);
}

@PutMapping("/loans/{id}")
public ResponseEntity<LoanDetails> updateLoan(@PathVariable Integer id, @RequestBody LoanDetails updatedLoanDetails) {
    LoanDetails updated = lmService.updateLoanDetails(id, updatedLoanDetails);
    return ResponseEntity.ok(updated);
}

@DeleteMapping("/customers/{id}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable Integer id) {
        lmService.deleteCustomer(id);
        return ResponseEntity.noContent().build();
    }


     @DeleteMapping("/loans/{id}")
    public ResponseEntity<Void> deleteLoan(@PathVariable Integer id) {
        lmService.deleteLoanDetails(id);
        return ResponseEntity.noContent().build();
    }

}
