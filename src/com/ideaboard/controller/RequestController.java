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
import com.ideaboard.dao.RequestDao;
import com.ideaboard.model.Idea;
import com.ideaboard.model.IdeaDetails;
import com.ideaboard.model.Request;

public class RequestController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String netId = request.getSession().getAttribute("netId").toString();
		if(request.getParameter("netId")!=null) {
			netId = request.getParameter("netId");
		}
		String method = request.getParameter("method");
		if(method.equals("myRequests")) {
			getMyRequests(netId, request);
			RequestDispatcher rd = request.getRequestDispatcher("myApplications.jsp");
			rd.forward(request, response);
		}
		else if(method.equals("viewApplications")) {
			int ideaId = Integer.parseInt(request.getParameter("ideaId"));
			getApplications(ideaId, request);
			RequestDispatcher rd = request.getRequestDispatcher("viewApplications.jsp");
			rd.forward(request, response);
		}
		else if(method.equals("approve") || method.equals("decline")) {
			int requestId = Integer.parseInt(request.getParameter("requestId"));
			String decision = method;
			updateRequest(requestId, decision);
			int ideaId = Integer.parseInt(request.getParameter("ideaId"));
			getApplications(ideaId, request);
			request.setAttribute("requestId", "");
			request.setAttribute("method", "");
			RequestDispatcher rd = request.getRequestDispatcher("viewApplications.jsp?method=viewApplications&ideaId=%s");
			
			rd.forward(request, response);
		}
		
	}
	

	private void getMyRequests(String netId, HttpServletRequest request) {
		List<Request> requests = null;
		RequestDao  requestDao = new RequestDao();
		requests = requestDao.getRequests(netId);
		request.setAttribute("requests", requests);
		
	}
	
	private void getApplications(int ideaId, HttpServletRequest request) {
		List<Request> requests = null;
		RequestDao  requestDao = new RequestDao();
		requests = requestDao.getRequests(ideaId);
		request.setAttribute("requests", requests);
	}
	
	private void updateRequest(int requestId, String decision) {
		RequestDao  requestDao = new RequestDao();
		requestDao.updateRequests(requestId, decision);
		
	}
}	