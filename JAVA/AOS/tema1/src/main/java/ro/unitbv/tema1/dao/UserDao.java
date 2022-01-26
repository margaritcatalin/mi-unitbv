package ro.unitbv.tema1.dao;

import java.util.List;

import ro.unitbv.tema1.entities.User;

public interface UserDao {
	public List<User> getUsers();

	public void saveUser(User theUser);

	public User getUser(int theId);

	public void deleteUser(int theId);
}
