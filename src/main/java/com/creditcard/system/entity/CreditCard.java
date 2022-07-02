/**
 * 
 */
package com.creditcard.system.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.creditcard.system.validator.LuhnConstraint;

/**
 * @author kunjalchauhan
 *
 */
@Entity
@Table(name = "credit_cards")
public class CreditCard {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@NotBlank(message = "Name is mandatory")
	@Column(name = "name")
	private String name;

	@NotNull(message = "Card Number is mandatory")
	@Column(name = "cardNumber", length = 19)
	@LuhnConstraint
	private Long cardNumber;

	@NotNull(message = "Limit is mandatory")
	@Column(name = "creditLimit")
	private Double creditLimit;

	@Column(name = "balance")
	private Double balance;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(Long cardNumber) {
		this.cardNumber = cardNumber;
	}

	public Double getCreditLimit() {
		return creditLimit;
	}

	public void setCreditLimit(Double creditLimit) {
		this.creditLimit = creditLimit;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "CreditCard [id=" + id + ", name=" + name + ", cardNumber=" + cardNumber + ", creditLimit=" + creditLimit
				+ ", balance=" + balance + "]";
	}

}
