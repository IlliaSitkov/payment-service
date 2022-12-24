package com.example.paymentservice.repositories;

import com.example.paymentservice.exceptions.InvalidBillException;
import com.example.paymentservice.models.Bill;
import org.springframework.stereotype.Component;

@Component
public class BillRepositoryImpl implements BillRepository {


    @Override
    public Bill saveBill(Bill bill) throws InvalidBillException {
        // connect to db and save the bill
        // throw exception if bill is incorrect
        // return newly created bill
        return null;
    }

    @Override
    public Bill updateBill(Bill bill) throws InvalidBillException {
        // connect to db and update the bill
        // throw exception if bill is incorrect
        // return updated bill
        return null;
    }

    @Override
    public Bill getById(long id) throws InvalidBillException {
        // connect to db and find the bill by id
        // throw exception if bill is incorrect
        // return the bill
        return null;
    }

    @Override
    public int getUnpaidBillCountForPeriod(long userId, int periodDays) {
        // count unpaid bills of the user with the userId specified during the last periodDays
        return 0;
    }
}
