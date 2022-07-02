package com.creditcard.system.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.creditcard.system.entity.CreditCard;
import com.creditcard.system.repository.CreditCardProcessRepository;

@RestController
@RequestMapping("/cards/api")
public class CreditCardProcessController {

	@Autowired
	CreditCardProcessRepository creditCardProcessRepository;

	@GetMapping("/credit/getAll")
	public ResponseEntity<List<CreditCard>> getAllCreditCardDetails() {
		try {
			List<CreditCard> creditCards = new ArrayList<>();
			creditCardProcessRepository.findAll().forEach(creditCards::add);
			return new ResponseEntity<>(creditCards, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping("/credit/add")
	public ResponseEntity<CreditCard> createCreditCard(@Valid @RequestBody CreditCard creditCard) {
		try {
			if (Objects.nonNull(creditCard)) {
				CreditCard _creditCard = creditCardProcessRepository.save(creditCard);
				return new ResponseEntity<>(_creditCard, HttpStatus.CREATED);
			} else {
				return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
			}
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
