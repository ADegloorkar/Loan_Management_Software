package com.LoanManagement.LoanManagement.TransactionEntity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Profit_lossDetails {

@Id
private double profit;
private double loss;
}
