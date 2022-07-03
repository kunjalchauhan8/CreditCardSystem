package com.creditcard.system.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.creditcard.system.entity.CreditCard;

public interface CreditCardProcessRepository extends JpaRepository<CreditCard, Long> {

	List<CreditCard> findBycardNumber(Long cardNumber);
}
