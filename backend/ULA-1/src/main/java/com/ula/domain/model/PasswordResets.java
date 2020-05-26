package com.ula.domain.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Entity
@Getter
@Setter
@Accessors(chain = true)
public class PasswordResets extends BaseEntity
{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false, columnDefinition = "VARCHAR(128)")
	private String email;

	@Column(nullable = false, columnDefinition = "VARCHAR(256)")
	private String token;

	@Column(nullable = false, columnDefinition = "DATETIME")
	private Date expiryDate;
}
