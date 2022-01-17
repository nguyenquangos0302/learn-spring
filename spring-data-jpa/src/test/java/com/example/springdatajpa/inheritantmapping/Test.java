package com.example.springdatajpa.inheritantmapping;

import com.example.springdatajpa.entity.inheritant_mapping.CheckNumber;
import com.example.springdatajpa.entity.inheritant_mapping.CreditCard;
import com.example.springdatajpa.repository.IPaymentRepository;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Test {

    @Autowired
    IPaymentRepository paymentRepository;

    @org.junit.Test
    public void contextLoads() {
    }

    @org.junit.Test
    public void createPayment() {
        CreditCard cc = new CreditCard();
        cc.setId(123);
        cc.setAmount(1000);
        cc.setCardNumber("123");
        paymentRepository.save(cc);
    }

    @org.junit.Test
    public void checkPayment() {
        CheckNumber ch = new CheckNumber();
        ch.setId(1231);
        ch.setAmount(1000);
        ch.setCheckNumber("1234");
        paymentRepository.save(ch);
    }

}
