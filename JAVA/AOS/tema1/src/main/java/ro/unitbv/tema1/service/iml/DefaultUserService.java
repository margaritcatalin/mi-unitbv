package ro.unitbv.tema1.service.iml;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ro.unitbv.tema1.dao.UserDao;
import ro.unitbv.tema1.entities.User;
import ro.unitbv.tema1.service.UserService;

@Service("userService")
public class DefaultUserService implements UserService {

	@Autowired
	private UserDao userDao;

	@Override
	@Transactional
	public List<User> getUsers() {
		return userDao.getUsers();
	}

	@Override
	@Transactional
	public void saveUser(User theUser) {

		userDao.saveUser(theUser);
	}

	@Override
	@Transactional
	public User getUser(int theId) {

		return userDao.getUser(theId);
	}

	@Override
	@Transactional
	public void deleteUser(int theId) {

		userDao.deleteUser(theId);
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public UserDao getUserDao() {
		return userDao;
	}
}
