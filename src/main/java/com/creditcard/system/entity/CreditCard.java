/**
 * 
 */
package com.creditcard.system.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author kunjalchauhan
 *
 */
@Entity
@Table(name = "credit_cards")
public class CreditCard extends Card{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
}
