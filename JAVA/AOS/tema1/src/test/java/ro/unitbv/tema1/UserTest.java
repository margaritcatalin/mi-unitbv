package ro.unitbv.tema1;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import ro.unitbv.tema1.entities.User;
import ro.unitbv.tema1.service.UserService;

@RunWith(SpringRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring-mvc-servlet.xml")
@Category(Integration.class)
public class UserTest {
	
    @Autowired
	private UserService userService;
	
	@Test
	public void getUsersCreateUserTest() {
		while(!userService.getUsers().isEmpty())
		{
			userService.deleteUser(userService.getUsers().get(0).getId());
		}
		List<User> users = userService.getUsers();
		assertTrue(users.isEmpty());

		User user1=new User();
		user1.setEmail("test1@test1.com");
		user1.setName("Unit Test 1");
		userService.saveUser(user1);
		
		User user2=new User();
		user2.setEmail("test2@test2.com");
		user2.setName("Unit Test 2");
		userService.saveUser(user2);
		
		users = userService.getUsers();

		assertEquals(2, users.size());
		assertNotNull(users.get(0));
		assertNotNull(users.get(1));

		users.sort((u1, u2) -> u1.getName().compareTo(u2.getName()));

		assertFalse(users.get(0).getName().isEmpty());

		assertNotNull(users.get(0).getName());
		assertNotNull(users.get(0).getEmail());
		
		assertNotNull(users.get(1).getName());
		assertNotNull(users.get(1).getEmail());

		assertNotNull(users.get(0).getId());
		assertEquals("Unit Test 1", users.get(0).getName());
		assertEquals("test1@test1.com", users.get(0).getEmail());

		assertNotNull(users.get(1).getId());
		assertEquals("Unit Test 2", users.get(1).getName());
		assertEquals("test2@test2.com", users.get(1).getEmail());
	}
	
	@Test
	public void deleteUserTest() {
		while(!userService.getUsers().isEmpty())
		{
			userService.deleteUser(userService.getUsers().get(0).getId());
		}
		List<User> users = userService.getUsers();
		assertTrue(users.isEmpty());

		User user1=new User();
		user1.setEmail("test1@test1.com");
		user1.setName("Unit Test 1");
		userService.saveUser(user1);
		
		User user2=new User();
		user2.setEmail("test2@test2.com");
		user2.setName("Unit Test 2");
		userService.saveUser(user2);
		
		users = userService.getUsers();
		assertEquals(2, users.size());
		assertNotNull(users.get(0));
		assertNotNull(users.get(1));

		users.sort((u1, u2) -> u1.getName().compareTo(u2.getName()));
		
		assertNotNull(users.get(0).getId());
		assertEquals("Unit Test 1", users.get(0).getName());
		assertEquals("test1@test1.com", users.get(0).getEmail());

		assertNotNull(users.get(1).getId());
		assertEquals("Unit Test 2", users.get(1).getName());
		assertEquals("test2@test2.com", users.get(1).getEmail());

		userService.deleteUser(users.get(0).getId());

		users = userService.getUsers();
		assertEquals(1, users.size());
		assertNotNull(users.get(0));

	}
}
