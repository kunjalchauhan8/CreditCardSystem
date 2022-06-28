/**
 * 
 */
package com.creditcard.system.entity;

import javax.persistence.*;

/**
 * @author kunjalchauhan
 *
 */
@Entity
@Table(name = "user")
public class User {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Column(nullable = false)
    private String username;
    
    @Column(nullable = false)
    private String pass;
}
