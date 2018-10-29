import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.ideaboard.dao.IdeaDao;
import com.ideaboard.dao.RequestDao;
import com.ideaboard.model.Idea;
import com.ideaboard.model.Request;

public class RequestDaoTest {

	Request request;
	RequestDao requestDaoObject;
	Idea idea;
	IdeaDao ideaDaoObject;
	
	@Before
	public void prepareIdea() {
		request = new Request();
		requestDaoObject = new RequestDao();
		idea = new Idea();
		ideaDaoObject = new IdeaDao();
		idea.setIdeaId(5);
		idea.setNetId("test_netid");
		idea.setTitle("test_title");
		idea.setDescription("test_description");
		List<String> skills = new ArrayList<String>();
		skills.add("C");
		idea.setIdeaDetails(skills, 1);
		//ideaDaoObject.create(idea);
		request.setIdeaId(idea.getIdeaId());
		request.setNetId("lps160130");
		request.setRequestId(5);
		request.setStatus("applied");
		
	}
	
	@Test 
	public void testCreateRequests() {
		int status = requestDaoObject.createRequests(request);
		assertEquals(status,1);
	}
	
	@Test
	public void testGetRequests() {
		List<Request> requests =  requestDaoObject.getRequests(idea.getIdeaId());
		assertEquals(requests.size(),1);
		
	}
	
	@Test 
	public void testUpdateRequests() {
		int status = requestDaoObject.updateRequests(request.getRequestId(), "decline");
		assertEquals(status,1);
	}
	
	
}
