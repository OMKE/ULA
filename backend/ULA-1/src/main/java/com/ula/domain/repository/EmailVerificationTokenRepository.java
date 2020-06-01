package com.ula.domain.repository;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ula.domain.model.EmailVerificationToken;
import com.ula.domain.model.User;

@Repository
public interface EmailVerificationTokenRepository
		extends CrudRepository<EmailVerificationToken, Long>
{

	Optional<EmailVerificationToken> getByToken(String token);

	@Transactional
	@Modifying
	@Query("delete from EmailVerificationToken e where e.user=:user")
	void deleteByUser(@Param("user") User user);
}
