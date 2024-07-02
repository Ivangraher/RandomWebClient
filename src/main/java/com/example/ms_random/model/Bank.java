package com.example.ms_random.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Bank {


    private Long id;
    private String uid;
    private String accountNumber;
    private String iban;
    private String bankName;
    private String routingNumber;
    private String swiftBic;
}
