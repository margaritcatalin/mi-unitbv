package com.unitbv.tema2.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.unitbv.tema2.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	public List<User> findAll();
	public Optional<User> findOne(String userId);
	public Optional<User> findByEmail(String email);
	public User save(User user);
	public void delete(User user);
}