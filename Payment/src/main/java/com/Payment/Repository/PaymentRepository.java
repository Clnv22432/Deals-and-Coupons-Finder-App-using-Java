package com.Payment.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.Payment.Model.PaymentPOJO;

public interface PaymentRepository extends MongoRepository<PaymentPOJO, Integer> {

}
