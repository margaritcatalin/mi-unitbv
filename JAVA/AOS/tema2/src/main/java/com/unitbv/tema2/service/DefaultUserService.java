package com.unitbv.tema2.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unitbv.tema2.exception.BadRequest;
import com.unitbv.tema2.exception.ResourceNotFoundException;
import com.unitbv.tema2.model.User;
import com.unitbv.tema2.repository.UserRepository;

@Service
public class DefaultUserService implements UserService{

	private UserRepository repository;
	
	@Autowired
	public DefaultUserService(UserRepository repository) {
		this.repository = repository;
	}
	
	@Override
	@org.springframework.transaction.annotation.Transactional(readOnly=true)
	public List<User> findAll() {
		return repository.findAll();
	}

	@org.springframework.transaction.annotation.Transactional(readOnly=true)	
	@Override
	public User findOne(String id) {
		return repository.findOne(id).orElseThrow(() -> new ResourceNotFoundException("User", "id", id));
	}

	@org.springframework.transaction.annotation.Transactional
	@Override
	public User create(User user) {
		Optional<User> mayExists = repository.findByEmail(user.getEmail());
			if(mayExists.isPresent())
				throw new BadRequest("User with email "+ user.getEmail() + "already exists");
		return repository.save(user);
	}

	@org.springframework.transaction.annotation.Transactional
	@Override
	public User update(String id, User user) {
		repository.findOne(id).orElseThrow(() -> new ResourceNotFoundException("User", "id", id));
		return repository.save(user);
	}

	@org.springframework.transaction.annotation.Transactional
	@Override
	public void delete(String id) {
		User found = repository.findOne(id).orElseThrow(() -> new ResourceNotFoundException("User", "id", id));
		repository.delete(found);		
	}
}
