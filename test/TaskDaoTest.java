import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.ideaboard.dao.TaskDao;
import com.ideaboard.model.Task;

public class TaskDaoTest {

	TaskDao taskDao;
	
	@Before
	public void initialize() {
		taskDao = new TaskDao();
	}
/*	@Test
	public void testCreate() {
		int result = taskDao.create(1, "task1", "started", 2);
		assertEquals(result,1);
		
	}*/
/*	@Test
	public void testGetTasks() {
		List<Task> tasks = taskDao.getTasks(1);
		assertEquals(tasks.size(),2);
	}*/
	/*@Test
	public void testUpdate() {
		Task task_old = taskDao.getTaskDetails(1, "task2");
		assertEquals(task_old.getName() , "task2");
		assertEquals(task_old.getStatus(),"started");
		
		task_old.setStatus("complete");
		
		taskDao.update(task_old, 1);
		Task task = taskDao.getTaskDetails(1, "task2");
		assertEquals(task.getStatus(),"complete");
	}*/
	@Test
	public void testDelete() {
		Task task = taskDao.getTaskDetails(1, "task2");
		
		
		taskDao.delete(1, task.getName());
		task = taskDao.getTaskDetails(1, task.getName());
		assertEquals(task.getStatus(),null);
	}
	
	

}
