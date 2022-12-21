package com.example.paymentservice.repositories;

import com.example.paymentservice.exceptions.InvalidBillException;
import com.example.paymentservice.models.Bill;

public interface BillRepository {

    Bill saveBill(Bill bill) throws InvalidBillException;

    Bill updateBill(Bill bill) throws InvalidBillException;

    Bill getById(long id) throws InvalidBillException;

    int getUnpaidBillCount(long userId);
}
