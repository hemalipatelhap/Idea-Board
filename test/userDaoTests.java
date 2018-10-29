import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.Before;

import com.ideaboard.dao.UserDao;
import com.ideaboard.model.User;

public class userDaoTests {
	
	private UserDao userDaoObject;
	private User newUser;
	
	@Before
	public void prepareUser() {
		newUser = new User();
		userDaoObject = new UserDao();
		newUser.setFirstName("test user");
		newUser.setLastName("test name");
		newUser.setNetId("testid");
		newUser.setPassword("password");
		newUser.setUsername("testuser");
	}
	
	@Test
	public void testRegister() {
		int statusCheck = userDaoObject.register(newUser);
//		System.out.println(statusCheck);
		assertEquals(statusCheck,0);
	}
	
	@Test
	public void testValidateUser() {
		String usernameActual = "testuser";
		String usernameExpected = userDaoObject.validateUser(newUser);
		assertEquals(usernameActual, usernameExpected);
	}

}
