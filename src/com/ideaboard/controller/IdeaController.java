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

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String netId = request.getSession().getAttribute("netId").toString();
		createIdea(netId, request);
		RequestDispatcher rd = request.getRequestDispatcher("userIdeasPage.jsp");
		rd.forward(request, response);

	}

	private void createIdea(String netId, HttpServletRequest request) {
		IdeaDao ideaDao = new IdeaDao();
		Idea idea = new Idea(netId);
		IdeaDetails detials = new IdeaDetails();
		
		String title = request.getParameter("title");
		String description = request.getParameter("description");
		int status = Integer.parseInt(request.getParameter("status"));
		idea.setTitle(title);
		idea.setDescription(description);
		idea.setStatus(status);
		if(request.getParameter("exp") != null) {
			int exp = Integer.parseInt(request.getParameter("exp"));
			detials.setExperience(exp);
			}
			if(request.getParameterValues("skill")!=null){
			List<String> skills = new ArrayList<String>(Arrays.asList(request.getParameterValues("skill")));
			detials.setSkills(skills);
			}
			idea.setIdeaDetails(detials);
			ideaDao.create(idea);
			
		
	}
}
