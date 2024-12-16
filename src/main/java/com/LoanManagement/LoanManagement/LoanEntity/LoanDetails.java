package com.LoanManagement.LoanManagement.LoanEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Loan_Details")
public class LoanDetails {

    @Column(name = "Loan_ID")
    @Id
    private int loanid;

    @Column(name = "Customer_ID")
    private int customerid;

    @Column(name = "Amount")
    private Float amount;

    @Column(name = "Rate_of_Intrest")
    private Double intrestRate;

    @Column(name = "Start_Date")
    private String startDate;

    @Column(name = "End_Date")
    private String endDate;


}
