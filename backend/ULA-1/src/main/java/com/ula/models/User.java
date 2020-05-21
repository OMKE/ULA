package com.ula.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false, unique = true, columnDefinition = "VARCHAR(64)")
	private String username;

	@Column(nullable = false, unique = true, columnDefinition = "VARCHAR(256)")
	private String email;

	@Column(nullable = false, columnDefinition = "VARCHAR(256)")
	private String password;

	@Column(nullable = true, columnDefinition = "VARCHAR(256)")
	private String profileImage;

	@Column(nullable = false, columnDefinition = "VARCHAR(128)")
	private String firstName;

	@Column(nullable = false, columnDefinition = "VARCHAR(128)")
	private String lastName;

	@Column(columnDefinition = "VARCHAR(128)")
	private String ipAddress;

}
