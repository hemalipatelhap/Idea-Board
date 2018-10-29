import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.ideaboard.dao.IdeaDao;
import com.ideaboard.model.Idea;

public class IdeaDaoTest {

	Idea idea;
	IdeaDao ideaDaoObject;
	
	@Before
	public void prepareIdea() {
		idea = new Idea();
		ideaDaoObject = new IdeaDao();
		idea.setIdeaId(5);
		idea.setNetId("test_netid");
		idea.setTitle("test_title");
		idea.setDescription("test_description");
		List<String> skills = new ArrayList<String>();
		skills.add("C");
		idea.setIdeaDetails(skills, 1);
	}

/*	@Test
	public void testCreateIdea() {
		int status = ideaDaoObject.create(idea);
		assertEquals(status, 1);
	}
	@Test
	public void testUpdate() {
		idea.setDescription("test_description1");
		int status = ideaDaoObject.update(idea, idea.getTitle());
		assertEquals(status, 1);
	}*/
	
	/*@Test
	public void testGetIdeas() {
		List<Idea> list = ideaDaoObject.getIdeas(idea.getNetId());
		assertEquals(list.size(),1);
	}
	@Test
	public void testGetIdea() {
		Idea idea_test = ideaDaoObject.getIdea(idea.getNetId(), idea.getTitle());
		assertEquals(idea_test.getDescription(),"test_description1");
	}
	@Test
	public void testGetIdeaByTitle() {
		Idea idea_test = ideaDaoObject.getIdeaByTitle(idea.getTitle());
		System.out.println(idea_test.getDescription());
		//assertEquals(idea_test.getDescription(),"test_description1");
	}
	@Test
	public void testGetSearch() {
		List<Idea> idea_test = ideaDaoObject.getSearchIdea(idea.getTitle(), "", "", "", "");
		assertEquals(idea_test.size(),1);
	}*/
	@Test
	public void testDeleteIdea() {
		ideaDaoObject.delete(idea.getNetId(), idea.getTitle());
		Idea idea_test = ideaDaoObject.getIdeaByTitle(idea.getTitle());
		assertEquals(idea_test.getDescription(),null);
	}
	
	
	
	

}
