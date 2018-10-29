import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.ideaboard.connection.ConnectionDB;
import com.ideaboard.dao.RequestDao;
import com.ideaboard.model.*;
import com.mysql.jdbc.Connection;

import org.junit.Before;

public class requestDaoTests {
	
	private RequestDao requestdao;
	@Before
	public void prepare() {
		requestdao = new RequestDao();
	}
	
	@Test
	public void testGetRequests() {
		// get requests submitted
		// before any requests are made
		String netid = "testid";
		List<Request> requests = requestdao.getRequests(netid);
		System.out.println(requests);
		assertTrue(requests.isEmpty());
		}
	public void testGetRequestAfter() {
		// test after creating a request
		assertTrue(true);
	}
	
	
}
