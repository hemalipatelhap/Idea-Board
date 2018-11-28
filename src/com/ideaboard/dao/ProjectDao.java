package com.ideaboard.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.ideaboard.connection.ConnectionDB;
import com.ideaboard.model.Idea;
import com.ideaboard.model.ProjectDetails;

public class ProjectDao {

	static Connection con;
	public ProjectDao(){
		con = ConnectionDB.getConnection();
	}
	public void save(ProjectDetails projectDetails) {
		
	}
	public List<Idea> getProjectsByUserId(String netId) {
		List<Integer> ideaIds = new ArrayList<Integer>();
		List<Idea> projects = new ArrayList<Idea>(); 
		try {
			PreparedStatement ps = con.prepareStatement("select * from requests where netid=? and status='approve'");
			ps.setString(1, netId);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				ideaIds.add(rs.getInt("ideaid"));
			}
			ps = con.prepareStatement("select * from ideas where netid=? and status=1");
			ps.setString(1, netId);
			rs = ps.executeQuery();
			while(rs.next()) {
				ideaIds.add(rs.getInt("ideaid"));
			}
		
		for(Integer id : ideaIds) {
			IdeaDao ideaDao = new IdeaDao();
			Idea idea = ideaDao.getIdeaById(id);
			if(idea.getStatus() == 1) {
				projects.add(idea);
			}
		}
		
			
		}catch(Exception e) {
			
		}
		return projects;
	}
}
