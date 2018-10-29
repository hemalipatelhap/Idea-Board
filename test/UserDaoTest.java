import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;


import com.ideaboard.dao.UserDao;
import com.ideaboard.model.User;
import com.ideaboard.model.UserProfile;

public class UserDaoTest {

	private UserDao userDaoObject;
	private User newUser;
	private UserProfile userProfile;
	
	@Before
	public void prepareUser() {
		newUser = new User();
		userDaoObject = new UserDao();
		newUser.setFirstName("test_fname");
		newUser.setLastName("test_lname");
		newUser.setNetId("test_netid");
		newUser.setPassword("test_password");
		newUser.setUsername("test_username");
		userProfile = new UserProfile(newUser.getNetId());
		userProfile.setExperience(1);
		List<String> skills = new ArrayList<String>();
		skills.add("C");
		skills.add("C++");
		List<String> aoiList = new ArrayList<String>();
		aoiList.add("Software Developement");
		userProfile.setSkills(skills);
		userProfile.setAoiList(aoiList);
		
		
		
	}
	
	@Test
	public void testRegister() {
		int statusCheck = userDaoObject.register(newUser);
		System.out.println(statusCheck);
		assertEquals(statusCheck,1);
	}
	
	@Test
	public void testValidateUser() {
		String usernameActual = "test_username";
		String usernameExpected = userDaoObject.validateUser(newUser);
		assertEquals(usernameActual, usernameExpected);
	}
	
	@Test 
	public void testGetProfile() {
		userDaoObject.updateProfile(userProfile);
		int skills_size = 2;
		String skill = "C";
		int aoi_size = 1;
		String aoi = "Software Developement";
		UserProfile userProfile = userDaoObject.getProfile(newUser.getNetId());
		assertEquals(skills_size,userProfile.getSkills().size());
		assertTrue(userProfile.getSkills().contains(skill));
		assertEquals(aoi_size,userProfile.getAoiList().size());
		assertTrue(userProfile.getAoiList().contains(aoi));
		
	}
	

}
