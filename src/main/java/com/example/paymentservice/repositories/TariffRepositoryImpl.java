package com.example.paymentservice.repositories;

import com.example.paymentservice.exceptions.InvalidTariffException;
import com.example.paymentservice.models.Tariff;
import org.springframework.stereotype.Component;

@Component
public class TariffRepositoryImpl implements TariffRepository {


    @Override
    public Tariff getTariffById(long tariffId) throws InvalidTariffException {
        // connect to db and find a tariff by id
        // throw exception if tariff not found
        // return the tariff
        return null;
    }
}
