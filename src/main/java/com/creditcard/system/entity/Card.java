package com.creditcard.system.entity;

import javax.persistence.Column;

public abstract class Card {

	@Column(nullable = false)
    private String name;
	
	@Column(nullable = false)
    private Long card_number;
	
    private Double credit_limit;
	
    private Double balance;
}
