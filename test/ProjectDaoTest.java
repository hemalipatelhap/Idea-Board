import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.ideaboard.dao.IdeaDao;
import com.ideaboard.dao.ProjectDao;
import com.ideaboard.model.Idea;

public class ProjectDaoTest {
	
	ProjectDao projectDaoObject;
	
	@Before
	public void initialize() {
		projectDaoObject = new ProjectDao();
		
	}
	@Test
	public void testgetProjectsByUserId() {
		List<Idea> projects = projectDaoObject.getProjectsByUserId("lps160130");
		assertEquals(projects.size(), 1);
	}

}
