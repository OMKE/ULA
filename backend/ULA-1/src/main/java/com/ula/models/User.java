package com.ula.models;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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

	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	private Set<UserPermission> userPermissions;

	public User() {
		super();
	}


	public User(Long id, String username, String email, String password, String profileImage,
			String firstName, String lastName, String ipAddress,
			Set<UserPermission> userPermissions) {
		super();
		this.id = id;
		this.username = username;
		this.email = email;
		this.password = password;
		this.profileImage = profileImage;
		this.firstName = firstName;
		this.lastName = lastName;
		this.ipAddress = ipAddress;
		this.userPermissions = userPermissions;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getProfileImage() {
		return profileImage;
	}

	public void setProfileImage(String profileImage) {
		this.profileImage = profileImage;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	public Set<UserPermission> getUserPermissions() {
		return userPermissions;
	}

	public void setUserPermissions(Set<UserPermission> userPermissions) {
		this.userPermissions = userPermissions;
	}

}
