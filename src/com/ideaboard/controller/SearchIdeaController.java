/**
 * 
 */
package com.ideaboard.controller;


import java.io.*;


import java.util.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.ideaboard.model.Idea;
import com.ideaboard.model.IdeaDetails;
import com.ideaboard.model.Request;
import com.ideaboard.model.User;
import com.ideaboard.dao.IdeaDao;
import com.ideaboard.dao.RequestDao;
import com.ideaboard.dao.UserDao;


/**
 * @author harthi
 *
 */

public class SearchIdeaController extends HttpServlet{
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
	
		String search=request.getSession().getAttribute("search").toString();
		if(search.equals("idea")) {
			System.out.println("inside search");
			String ideatitle=null,aoi1=null,aoi2=null,skill1=null,skill2=null;
		
			ideatitle=request.getParameter("ideatitle");
			aoi1=request.getParameter("aoi1");
			aoi2=request.getParameter("aoi2");
			skill1=request.getParameter("skill1");
			skill2=request.getParameter("skill2");
			System.out.println(ideatitle);
			IdeaDao ideadao = new IdeaDao();
			List<Idea> ideaList=ideadao.getSearchIdea(ideatitle, aoi1, aoi2, skill1, skill2);
			System.out.println(ideaList.size());
			request.setAttribute("ideaList", ideaList);
			RequestDispatcher rd = request.getRequestDispatcher("SearchViewIdea.jsp");
			rd.forward(request, response);
		}else if(search.equals("people")) {
			String fname= request.getParameter("name");
			UserDao userDao= new UserDao();
			List<User> userList = userDao.getSearchUser(fname);
			request.setAttribute("userList", userList);
			RequestDispatcher rd = request.getRequestDispatcher("SearchViewPeople.jsp");
			rd.forward(request, response);
		}
		
		
	}
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		Idea idea = new Idea();
		String netId = request.getSession().getAttribute("netId").toString();
		String method = request.getParameter("method");
		String title =request.getParameter("title"); 
		idea=getIdea(netId, title, request);
		 if(method.equals("view")) {
			 
			 
			RequestDispatcher rd = request.getRequestDispatcher("viewIdea.jsp");
			rd.forward(request, response);
		}else if(method.equals("apply")) {
			
			createRequest(idea, request);
			RequestDispatcher rd = request.getRequestDispatcher("userHomePage.jsp");
			rd.forward(request, response);
		}else if(method.equals("viewPeople")) {
			RequestDispatcher rd = request.getRequestDispatcher("userHomePage.jsp");
			rd.forward(request, response);
		}
		
	}
	private void createRequest(Idea idea, HttpServletRequest request) {
	// TODO Auto-generated method stub
		Request ideaRequest = new Request();
		System.out.println("idea id"+ idea.getIdeaId());
		ideaRequest.setIdeaId(idea.getIdeaId());
		ideaRequest.setNetId(request.getSession().getAttribute("netId").toString());
		ideaRequest.setStatus("applied");
		RequestDao requestDao= new RequestDao();
		requestDao.createRequests(ideaRequest);
	
}
	private Idea getIdea(String netId, String title, HttpServletRequest request) {
			IdeaDao ideaDao = new IdeaDao();
			
			Idea idea = ideaDao.getIdeaByTitle(title);
			IdeaDetails details = idea.getIdeaDetails();
			request.setAttribute("idea", idea);
			request.setAttribute("details", details);
			request.setAttribute("from", "search");
			return idea;
	}
	
	
}
