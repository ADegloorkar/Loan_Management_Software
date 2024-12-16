package com.LoanManagement.LoanManagement.CustomerEntity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table (name = "Customer_Details")
public class CustomerDetails {


@GeneratedValue
@Column(name = "ID")
@Id
private  int id;

@Column(name = "Name")
private  String name;

    @Column(name = "Occupation")
    private String occupation;

    @Column(name = "Age")
    private String age;

    @Column(name = "Address")
    private String address;

    @Column(name = "PanCard_No")
    private String pancardno;

    @Column(name = "Mobile_nu")
    private Long mobilenu;

    @Column(name = "Addhar_no")
    private Long addharnu;


}
