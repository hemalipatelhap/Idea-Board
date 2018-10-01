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

import com.ideaboard.dao.UserDao;
import com.ideaboard.model.AreaOfInterest;
import com.ideaboard.model.Skill;
import com.ideaboard.model.UserProfile;

public class UpdateProfileController extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String netId = request.getSession().getAttribute("netId").toString();
		updateProfile(netId, request);
		
		request.setAttribute("netId", netId);
		RequestDispatcher rd = request.getRequestDispatcher("viewProfile.jsp");
		rd.forward(request, response);
		
	}

	private void updateProfile(String netId, HttpServletRequest request) {
		UserProfile profile = new UserProfile(netId);
		
		if(request.getParameter("exp") != null) {
		int exp = Integer.parseInt(request.getParameter("exp"));
		profile.setExperience(exp);
		}
		if(request.getParameterValues("skill")!=null){
		List<String> skills = new ArrayList<String>(Arrays.asList(request.getParameterValues("skill")));
		profile.setSkills(skills);
		}
		if(request.getParameterValues("aoi") != null) {
		List<String> aoiList = new ArrayList<String>(Arrays.asList(request.getParameterValues("aoi")));
		profile.setAoiList(aoiList);
		}
		
		UserDao userDao = new UserDao();
		System.out.println(profile.getExperience());
		userDao.updateProfile(profile);
		
	}
	

}
