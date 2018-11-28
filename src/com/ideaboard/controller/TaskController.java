package com.ideaboard.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ideaboard.dao.TaskDao;
import com.ideaboard.model.Task;

public class TaskController extends HttpServlet{
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String method = request.getParameter("method");
		if(method.equals("create")) {
			if(request.getParameter("projectId") != null) {
				int projectId = Integer.parseInt(request.getParameter("projectId"));
				request.setAttribute("projectId", projectId);
				RequestDispatcher rd = request.getRequestDispatcher("createTask.jsp");
				rd.forward(request, response);
			}
		}else if(method.equals("viewAll")) {
			if(request.getParameter("projectId") != null) {
				int projectId = Integer.parseInt(request.getParameter("projectId"));
				List<Task> tasks = viewAllTasks(projectId);
				request.setAttribute("tasks", tasks);
				request.setAttribute("projectId", projectId);
				RequestDispatcher rd = request.getRequestDispatcher("projectTasks.jsp");
				rd.forward(request, response);
			}
		}else if(method.equals("delete")) {
			if(request.getParameter("projectId") != null) {
				int projectId = Integer.parseInt(request.getParameter("projectId"));
				String title =request.getParameter("name"); 
				deleteTask(projectId,title, request);
				List<Task> tasks = viewAllTasks(projectId);
				request.setAttribute("tasks", tasks);
				request.setAttribute("projectId", projectId);
				RequestDispatcher rd = request.getRequestDispatcher("projectTasks.jsp");
				rd.forward(request, response);
			}
		}else if(method.equals("update")) {
			if(request.getParameter("projectId") != null) {
				int projectId = Integer.parseInt(request.getParameter("projectId"));
				
				String title =request.getParameter("name"); 
				getTask(projectId,title, request);
				
				
				RequestDispatcher rd = request.getRequestDispatcher("updateTask.jsp");
				rd.forward(request, response);
			}
		}
	}
	
	private void getTask(int projectId,String title, HttpServletRequest request) {
		TaskDao taskDao = new TaskDao();
		Task task = taskDao.getTaskDetails(projectId, title);
		request.setAttribute("task", task);
		request.setAttribute("projectId", projectId);
	}
	private void deleteTask(int projectId,String title, HttpServletRequest request) {
		TaskDao taskDao = new TaskDao();
		taskDao.delete(projectId,title);
		
	}
	private List<Task> viewAllTasks(int projectId) {
		TaskDao taskDao = new TaskDao();
		List<Task> tasks = taskDao.getTasks(projectId);
		return tasks;
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String method = request.getParameter("method");
		int projectId =0;
		if(request.getParameter("projectId") != null) {
			 projectId = Integer.parseInt(request.getParameter("projectId"));
		}
		if(method.equals("create")) {
			
				String name = request.getParameter("name");
				int status = Integer.parseInt(request.getParameter("status"));
				int priority = Integer.parseInt(request.getParameter("priority"));
				createTask(projectId, name, status, priority);
				
			
		}else if(method.equals("update")) {
			
			updateTask(projectId, request);
		}
		List<Task> tasks = viewAllTasks(projectId);
		request.setAttribute("tasks", tasks);
		request.setAttribute("method", "viewAll");
		request.setAttribute("projectId", projectId);
		RequestDispatcher rd = request.getRequestDispatcher("projectTasks.jsp");
		rd.forward(request, response);
	}
	private void updateTask(int projectId, HttpServletRequest request) {
		TaskDao taskDao = new TaskDao();
		Task task = new Task();
		String name = request.getParameter("name");
		int status = Integer.parseInt(request.getParameter("status"));
		String status_text = null;
		if(status == 1) {
			 status_text = "started";
		} else if(status == 2) {
			status_text = "in progress";
		} else if(status == 3) {
			status_text = "completed";
		}
		
		int priority = Integer.parseInt(request.getParameter("priority"));
		task.setName(name);
		task.setPriority(priority);
		task.setStatus(status_text);
		taskDao.update(task,projectId);	
		
	}
	
	private void createTask(int projectId, String name, int status, int priority) {
		String status_text = null;
		if(status == 1) {
			 status_text = "started";
		} else if(status == 2) {
			status_text = "in progress";
		} else if(status == 3) {
			status_text = "completed";
		}
		TaskDao taskDao = new TaskDao();
		taskDao.create(projectId, name, status_text, priority);
		
	}
}
