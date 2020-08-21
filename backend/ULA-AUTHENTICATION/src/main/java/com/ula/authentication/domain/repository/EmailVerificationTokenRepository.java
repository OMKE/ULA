package com.ula.authentication.domain.repository;

import com.ula.authentication.domain.model.EmailVerificationToken;
import com.ula.authentication.domain.model.User;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;




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
