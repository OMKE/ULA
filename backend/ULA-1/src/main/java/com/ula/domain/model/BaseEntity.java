package com.ula.domain.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/*
 * Base Entity class that every class should inherit
 *  It adds created_at, updated_at and deleted columns
 */

@EntityListeners(AuditingEntityListener.class)
@MappedSuperclass
@Getter
@Setter
@NoArgsConstructor
public abstract class BaseEntity implements Serializable {


	@Column(name = "deleted", columnDefinition = "bool default false", updatable = false)
	private boolean deleted = false;
	
	@CreationTimestamp
	@Column(name = "created_at", nullable = false, columnDefinition = "TIMESTAMP")
	private Date createdAt;
	
	@UpdateTimestamp
	@Column(name = "updated_at", columnDefinition = "TIMESTAMP")
	private Date updatedAt;



}
