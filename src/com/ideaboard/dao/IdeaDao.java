package com.ideaboard.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.ideaboard.connection.ConnectionDB;
import com.ideaboard.model.Idea;
import com.ideaboard.model.IdeaDetails;
import com.ideaboard.model.Skill;

public class IdeaDao {

	
	static Connection con;
	public IdeaDao(){
		con = ConnectionDB.getConnection();
	}
	public int update(Idea idea, String title) {
		int status = 0;
		try {
					
					PreparedStatement ps = con.prepareStatement("update ideas set title=?,description=? ,status=? where netid = ? and title = ?");
					
					ps.setString(1, idea.getTitle());
					ps.setString(2, idea.getDescription());
					ps.setInt(3, idea.getStatus());
					ps.setString(4, idea.getNetId());
					ps.setString(5, title);
					status = ps.executeUpdate();
					IdeaDetails details = idea.getIdeaDetails();
					List<String> skills = details.getSkills();
					ps = con.prepareStatement("delete from idea_skills where netid = ? and title = ?");
					ps.setString(1, idea.getNetId());
					ps.setString(2, title);
					ps.executeUpdate();
					for(String skill : skills) {
						
						ps = con.prepareStatement("insert into idea_skills values(?,?,?)");
						ps.setString(1, idea.getNetId());
						ps.setString(2, idea.getTitle());
						ps.setString(3, skill);
						ps.executeUpdate();
					}
					
					ps = con.prepareStatement("update idea_exp set title=?,exp= ? where netid = ? and title = ?");
					ps.setString(1, idea.getTitle());
					ps.setString(2, details.getExperience());
					ps.setString(3, idea.getNetId());
					ps.setString(4, title);
					ps.executeUpdate();
					ps.close();
					
				} catch(Exception e) {
					
				}
				return status;
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
			
		} catch(Exception e) {
			
		}
		return status;
	}
	public List<Idea> getIdeas(String netId) {
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
				idea.setIdeaId(rs.getInt("ideaid"));
				ideas.add(idea);
			}
			
		}catch(Exception e) {
			
		}
		return ideas;
	}
	
	public Idea getIdea(String netId, String title) {
		Idea idea = null;
		try {
			PreparedStatement ps = con.prepareStatement("select * from ideas where netid=? and title = ?");
			ps.setString(1, netId);
			ps.setString(2, title);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				 idea = new Idea(netId);
				idea.setTitle(rs.getString("title"));
				idea.setDescription(rs.getString("description"));
				idea.setStatus(rs.getInt("status"));
				
			}
			ps = con.prepareStatement("select * from idea_skills where netid=? and title = ? ");
			ps.setString(1, netId);
			ps.setString(2, title);
			rs = ps.executeQuery();
			List<String> skills = new ArrayList<String>(); 
			while(rs.next()) {
				skills.add(rs.getString("skill"));
			}
			ps = con.prepareStatement("select * from idea_exp where netid=? and title = ? ");
			ps.setString(1, netId);
			ps.setString(2, title);
			rs = ps.executeQuery();
			String exp = "";
			while(rs.next()) {
				exp = rs.getString("exp");
			}
			idea.setIdeaDetails(skills, exp);
			
		}catch(Exception e) {
			
		}
		
		
		return idea;
	}
	public Idea getIdeaByTitle(String title) {
		Idea idea = null;
		try {
			PreparedStatement ps = con.prepareStatement("select * from ideas where title = ?");
			//ps.setString(1, netId);
			ps.setString(1, title);
			ResultSet rs = ps.executeQuery();
			 idea = new Idea();
			 //idea.setNetId(netId);
			while(rs.next()) {
				idea.setNetId(rs.getString("netid"));
				 idea.setIdeaId(rs.getInt("ideaid"));
				idea.setTitle(rs.getString("title"));
				idea.setDescription(rs.getString("description"));
				idea.setStatus(rs.getInt("status"));
				
			}
			ps = con.prepareStatement("select * from idea_skills where title = ? ");
			
			ps.setString(1, title);
			rs = ps.executeQuery();
			List<String> skills = new ArrayList<String>(); 
			while(rs.next()) {
				skills.add(rs.getString("skill"));
			}
			ps = con.prepareStatement("select * from idea_exp where title = ? ");
			
			ps.setString(2, title);
			rs = ps.executeQuery();
			String exp = "";
			while(rs.next()) {
				exp = rs.getString("exp");
			}
			idea.setIdeaDetails(skills, exp);
			
		}catch(Exception e) {
			
		}
		
		
		return idea;
	}
public List<Idea> getSearchIdea(String ideatitle,String aoi1,String aoi2,String skill1,String skill2) {
		
		List<Idea> ideas = new ArrayList<Idea>();
		PreparedStatement ps;
		try {
			Set<String> ideaSet = new HashSet<String>();
			if((skill1!=null && skill1!="") &&(skill2!=null && skill2!="") ) {
				 ps = con.prepareStatement("select title from idea_skills where skill =(? OR ?) ");
				 ps.setString(1, skill1);
				 ps.setString(2, skill2);
				 ResultSet rs = ps.executeQuery();
				 while(rs.next()) {
						ideaSet.add(rs.getString("title"));
				}
			}else if((skill1!=null && skill1!="") &&(skill2=="-1")) {
				ps = con.prepareStatement("select title from idea_skills where skill = ? ");
				 ps.setString(1, skill1);
				ResultSet rs = ps.executeQuery();
				 while(rs.next()) {
						ideaSet.add(rs.getString("title"));
				}
			}
			if(ideaSet.isEmpty()) {
				if(ideatitle!=null) {
					 ps = con.prepareStatement("select * from ideas where title like ? ");
						ps.setString(1, "%"+ideatitle+"%");
						ResultSet rs = ps.executeQuery();
						while(rs.next()) {
							Idea idea = new Idea();
							idea.setTitle(rs.getString("title"));
							idea.setDescription(rs.getString("description"));
							//idea.setStatus(rs.getInt("status"));
							ideas.add(idea);
						}
				}
			}else {
				for(String id : ideaSet) {
					if(id!=null) {
						 ps = con.prepareStatement("select * from ideas where title =? ");
							ps.setString(1, id);
							ResultSet rs = ps.executeQuery();
							while(rs.next()) {
								Idea idea = new Idea();
								idea.setTitle(rs.getString("title"));
								idea.setDescription(rs.getString("description"));
								//idea.setStatus(rs.getInt("status"));
								ideas.add(idea);
							}
					}
					
				}
			}
			
			
			
		}catch(Exception e) {
			
		}
		return ideas;
	}
	
	public void delete(String netId, String title) {
		try {
			PreparedStatement ps = con.prepareStatement("delete from ideas where netId= ? and title= ?");
			ps.setString(1, netId);
			ps.setString(2, title);
			ps.executeQuery();
			ps = con.prepareStatement("delete from idea_skills where netId= ? and title= ?");
			ps.setString(1, netId);
			ps.setString(2, title);
			ps.executeQuery();
			ps = con.prepareStatement("delete from idea_exp where netId= ? and title= ?");
			ps.setString(1, netId);
			ps.setString(2, title);
			ps.executeQuery();
			
			
			
		}catch(Exception e) {
			
		}
		
	}
}
