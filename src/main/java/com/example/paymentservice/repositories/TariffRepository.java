package com.example.paymentservice.repositories;

import com.example.paymentservice.exceptions.InvalidTariffException;
import com.example.paymentservice.models.Tariff;

public interface TariffRepository {

    Tariff getTariffById(long tariffId) throws InvalidTariffException;

}
