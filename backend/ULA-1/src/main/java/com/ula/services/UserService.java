package com.ula.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ula.models.User;
import com.ula.repositories.UserRepository;

@Service
public class UserService
{

    @Autowired
    private UserRepository userRepository;

    
    public Iterable<User> findAll(){
		return userRepository.findAll();
    }
    public User findById(Long id){
        return userRepository.findById(id).orElse(null);
    }

	public User findByIdWithTrashed(Long id) {
		return userRepository.findByIdTrashed(id).orElse(null);
	}

	public Optional<User> getUserByUsername(String username) {
		return userRepository.findByUsername(username);
	}

	public Optional<User> getUserByUsername(String username, String password) {
		return userRepository.findByUsernameAndPassword(username, password);
	}

	public Optional<User> getUserByEmail(String email) {
		return userRepository.findByEmail(email);
	}

	public Optional<User> getUserByEmail(String email, String password) {
		return userRepository.findByEmailAndPassword(email, password);
	}
    
    public void save(User user){
        userRepository.save(user);
    }
    public void delete(Long id){
		userRepository.deleteById(id);
    }

	public void restore(Long id) {
		userRepository.restoreById(id);
	}
}