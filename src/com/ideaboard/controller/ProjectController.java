package com.ideaboard.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ideaboard.dao.IdeaDao;
import com.ideaboard.dao.ProjectDao;
import com.ideaboard.dao.RequestDao;
import com.ideaboard.model.Idea;

public class ProjectController extends HttpServlet  {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String method = request.getParameter("method");
		String netId = request.getSession().getAttribute("netId").toString();
		System.out.println(netId);
		if(method.equals("create")) {
			if(request.getParameter("ideaId") != null) {
				
			int ideaId = Integer.parseInt(request.getParameter("ideaId"));	
			System.out.println(ideaId);
			startProject(ideaId);
			RequestDispatcher rd = request.getRequestDispatcher("userIdeasPage.jsp");
			rd.forward(request, response);
			
			}
		}
		else if(method.equals("myProjects")) {
			List<Idea> projects = getProjects(netId);
			request.setAttribute("projects",projects);
			RequestDispatcher rd = request.getRequestDispatcher("myProjects.jsp");
			rd.forward(request, response);
			
		}else if(method.equals("viewProject")) {
			if(request.getParameter("ideaId") != null) {
				int ideaId = Integer.parseInt(request.getParameter("ideaId"));
				request.setAttribute("projectId",ideaId);
				RequestDispatcher rd = request.getRequestDispatcher("viewProject.jsp");
				rd.forward(request, response);
				
			}
		} else if (method.equals("viewMembers")) {
			if(request.getParameter("projectId") != null) {
				int projectId = Integer.parseInt(request.getParameter("projectId"));
				List<String> members = getMembers(projectId);
				request.setAttribute("members", members);
				RequestDispatcher rd = request.getRequestDispatcher("viewMembers.jsp");
				rd.forward(request, response);
			}
		}
	}

	
	private List<String> getMembers(int projectId) {
		List<String> members = new ArrayList<String>();
	    RequestDao requestDao = new RequestDao();
	    IdeaDao ideaDao = new IdeaDao();
		for(String member : requestDao.getApprovedRequests(projectId)) {
			members.add(member);
		}
		Idea idea = ideaDao.getIdeaById(projectId);
		members.add(idea.getNetId());
		return members;
		
		
	}


	private List<Idea> getProjects(String netId) {
		ProjectDao projectDao = new ProjectDao();
		return projectDao.getProjectsByUserId(netId);
		
		
	}

	private void startProject(int ideaId) {
		IdeaDao ideaDao = new IdeaDao();
		Idea idea = ideaDao.getIdeaById(ideaId);
		idea.setStatus(1);
		System.out.println("title"+ idea.getTitle());
		ideaDao.update(idea, idea.getTitle());
		
	}

}
