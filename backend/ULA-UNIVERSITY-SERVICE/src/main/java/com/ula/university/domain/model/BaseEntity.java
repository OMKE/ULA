package com.ula.university.domain.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.util.Date;

/*
 * Base Entity class that every class should inherit
 *  It adds created_at, updated_at and deleted columns
 */

@EntityListeners(AuditingEntityListener.class)
@MappedSuperclass
@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
public abstract class BaseEntity implements Serializable {



	@Column(name = "deleted", columnDefinition = "bool default false")
	private boolean deleted = false;
	
	@CreationTimestamp
	@Column(name = "created_at", nullable = false, columnDefinition = "TIMESTAMP")
	private Date createdAt;
	
	@UpdateTimestamp
	@Column(name = "updated_at", columnDefinition = "TIMESTAMP")
	private Date updatedAt;



}
