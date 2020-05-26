package com.ula.domain.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Accessors(chain = true)
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

	@Column(nullable = false, columnDefinition = "BOOLEAN DEFAULT false")
	private boolean emailVerified;

	@Column(columnDefinition = "VARCHAR(128)")
	private String ipAddress;

	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	private Set<UserPermission> userPermissions;


}
