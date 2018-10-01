package com.ideaboard.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.ideaboard.connection.ConnectionDB;
import com.ideaboard.model.Idea;
import com.ideaboard.model.IdeaDetails;

public class IdeaDao {

	Connection con;
	public IdeaDao(){
		con = ConnectionDB.getConnection();
	}
	public int create(Idea idea) {
		int status = 0;
try {
			
			PreparedStatement ps = con.prepareStatement("insert into ideas values(?,?,?,?)");
			ps.setString(1, idea.getNetId());
			ps.setString(2, idea.getTitle());
			ps.setString(3, idea.getDescription());
			ps.setInt(4, idea.getStatus());
			
			status = ps.executeUpdate();
			IdeaDetails details = idea.getIdeaDetails();
			List<String> skills = details.getSkills();
			for(String skill : skills) {
				ps = con.prepareStatement("insert into idea_skills values(?,?,?)");
				ps.setString(1, idea.getNetId());
				ps.setString(2, idea.getTitle());
				ps.setString(3, skill);
				ps.executeUpdate();
			}
			ps = con.prepareStatement("insert into idea_exp values(?,?,?)");
			ps.setString(1, idea.getNetId());
			ps.setString(2, idea.getTitle());
			ps.setString(3, details.getExperience());
			ps.executeUpdate();
			ps.close();
			con.close();
		} catch(Exception e) {
			
		}
		return status;
	}
	public List<Idea> getIdea(String netId) {
		List<Idea> ideas = new ArrayList<Idea>();
		try {
			PreparedStatement ps = con.prepareStatement("select * from ideas where netid=?");
			ps.setString(1, netId);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Idea idea = new Idea(netId);
				idea.setTitle(rs.getString("title"));
				idea.setDescription(rs.getString("description"));
				idea.setStatus(rs.getInt("status"));
				ideas.add(idea);
			}
			
		}catch(Exception e) {
			
		}
		return ideas;
	}
}
