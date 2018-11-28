package com.ideaboard.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ideaboard.dao.IdeaDao;
import com.ideaboard.model.Idea;
import com.ideaboard.model.IdeaDetails;

public class IdeaController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		
		String netId = request.getSession().getAttribute("netId").toString();
		String method = request.getParameter("method");
		if(method.equals("displayAll")) {
			getAllIdeas(netId, request);
			RequestDispatcher rd = request.getRequestDispatcher("userIdeasPage.jsp");
			rd.forward(request, response);
		}else if(method.equals("view")) {
			String title =request.getParameter("title"); 
			getIdea(netId, title, request);
			RequestDispatcher rd = request.getRequestDispatcher("viewIdea.jsp");
			rd.forward(request, response);
		}else if(method.equals("update")) {
			String title =request.getParameter("title"); 
			getIdea(netId, title, request);
			RequestDispatcher rd = request.getRequestDispatcher("updateIdea.jsp");
			rd.forward(request, response);
		}else if(method.equals("delete")) {
			String title =request.getParameter("title"); 
			deleteIdea(netId, title, request);
			getAllIdeas(netId, request);
			RequestDispatcher rd = request.getRequestDispatcher("userIdeasPage.jsp");
			rd.forward(request, response);
		}
		
	}
	private void deleteIdea(String netId, String title, HttpServletRequest request) {
		IdeaDao ideaDao = new IdeaDao();
		ideaDao.delete(netId, title);
		
	}
	private void getIdea(String netId, String title, HttpServletRequest request) {
		IdeaDao ideaDao = new IdeaDao();
		Idea idea = ideaDao.getIdea(netId, title);
		IdeaDetails details = idea.getIdeaDetails();
		request.setAttribute("idea", idea);
		request.setAttribute("details", details);
		request.setAttribute("from", "view");
		
	}
	private void getAllIdeas(String netId, HttpServletRequest request) {
		IdeaDao ideaDao = new IdeaDao();
		List<Idea> idea = ideaDao.getIdeas(netId);
		request.setAttribute("ideas", idea);
		
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		String netId = request.getSession().getAttribute("netId").toString();
		String method = request.getParameter("method");
		if(method.equals("create")) {
			createIdea(netId, request);
		} else if(method.equals("update")) {
			String oldTitle = request.getParameter("oldTitle");
			updateIdea(netId, oldTitle, request);
		}
		
		getAllIdeas(netId, request);
		RequestDispatcher rd = request.getRequestDispatcher("userIdeasPage.jsp");
		rd.forward(request, response);

	}

	private void updateIdea(String netId, String oldTitle, HttpServletRequest request) {
		IdeaDao ideaDao = new IdeaDao();
		Idea idea = new Idea(netId);
		
		
		String title = request.getParameter("title");
		String description = request.getParameter("description");
		System.out.println(description);
		int status = Integer.parseInt(request.getParameter("status"));
		idea.setTitle(title);
		idea.setDescription(description);
		idea.setStatus(status);
		int exp = 0;
		List<String> skills = new ArrayList<String>();
		if(request.getParameter("exp") != null) {
			
			exp = Integer.parseInt(request.getParameter("exp"));
			}
			if(request.getParameterValues("skill")!=null){
			
				 skills = new ArrayList<String>(Arrays.asList(request.getParameterValues("skill")));
			}
			idea.setIdeaDetails(skills, exp);
			ideaDao.update(idea, oldTitle);
			
		
	}
	private void createIdea(String netId, HttpServletRequest request) {
		IdeaDao ideaDao = new IdeaDao();
		Idea idea = new Idea(netId);
		
		
		String title = request.getParameter("title");
		String description = request.getParameter("description");
		int status = Integer.parseInt(request.getParameter("status"));
		idea.setTitle(title);
		idea.setDescription(description);
		idea.setStatus(status);
		int exp = 0;
		List<String> skills = new ArrayList<String>();
		if(request.getParameter("exp") != null) {
			
			exp = Integer.parseInt(request.getParameter("exp"));
			}
			if(request.getParameterValues("skill")!=null){
			
				skills = new ArrayList<String>(Arrays.asList(request.getParameterValues("skill")));
			}
			
			idea.setIdeaDetails(skills, exp);
			ideaDao.create(idea);
			
		
	}
}


