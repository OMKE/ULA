package com.ula.models;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;

import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

/*
 * Base Entity class that every class should inherit
 *  It adds created_at, updated_at and deleted columns
 */

@EntityListeners(AuditingEntityListener.class)
@MappedSuperclass
public abstract class BaseEntity implements Serializable {


	@Column(name = "deleted", columnDefinition = "bool default false", updatable = false)
	private boolean deleted = false;
	
	@Column(name = "created_at", nullable = false)
	private Date createdAt;
	
	@LastModifiedDate
	@Column(name = "updated_at")
	private Date updatedAt;



}
