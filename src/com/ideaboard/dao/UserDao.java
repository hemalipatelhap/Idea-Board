package com.ideaboard.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ideaboard.connection.ConnectionDB;
import com.ideaboard.model.User;
import com.ideaboard.model.UserProfile;

public class UserDao {

	Connection con;
	public UserDao(){
		con = ConnectionDB.getConnection();
	}
	public int register(User user) {
		int status = 0;
		try {
			
			PreparedStatement ps = con.prepareStatement("insert into users values(?,?,?,?,?)");
			ps.setString(1, user.getNetId());
			ps.setString(2, user.getFirstName());
			ps.setString(3, user.getLastName());
			ps.setString(4, user.getUsername());
			ps.setString(5, user.getPassword());
			status = ps.executeUpdate();
			ps = con.prepareStatement("insert into user_exp values(?,?)");
			ps.setString(1, user.getNetId());
			ps.setString(2, "none");
			ps.executeUpdate();
			ps.close();
			con.close();
		} catch(Exception e) {
			
		}
		return status;
	}
	public String validateUser(User user) {
		String username = "";
		try {
			PreparedStatement ps;
			ps = con.prepareStatement("select * from users where netid= ? and password= ?");
			ps.setString(1, user.getNetId());
			ps.setString(2, user.getPassword());
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				
				username = rs.getString("username");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return username;
		
	}
	public void updateProfile(UserProfile profile) {
		
		try {
			PreparedStatement ps;
			if(profile.getSkills() != null) {
			for(String skill : profile.getSkills()) {
				ps = con.prepareStatement("insert into user_skills values(?,?)");
				ps.setString(1, profile.getNetId());
				ps.setString(2, skill);
				ps.executeUpdate();
			}
			}
			if(profile.getAoiList()!= null) {
			for(String aoi : profile.getAoiList()) {
				ps = con.prepareStatement("insert into user_aoi values(?,?)");
				ps.setString(1, profile.getNetId());
				ps.setString(2, aoi);
				ps.executeUpdate();
			}
			}
			if(profile.getExperience() != null) {
			ps = con.prepareStatement("update user_exp set exp=? where netid=?");
			ps.setString(1, profile.getExperience());
			ps.setString(2, profile.getNetId());
			ps.executeUpdate();
			}
				
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public UserProfile getProfile(String netId) {
		UserProfile profile = new UserProfile(netId);
		List<String> skills = new ArrayList<String>();
		List<String> aoiList = new ArrayList<String>();
		String exp = "none";
		try {
			PreparedStatement ps;
			ps = con.prepareStatement("select * from user_skills where netid= ?");
			ps.setString(1, netId);
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				
				skills.add(rs.getString("skill"));
			}
			ps = con.prepareStatement("select * from user_aoi where netid= ?");
			ps.setString(1, netId);
			
			 rs = ps.executeQuery();
			while(rs.next()) {
				
				aoiList.add(rs.getString("aoi"));
			}
			ps = con.prepareStatement("select * from user_exp where netid= ?");
			ps.setString(1, netId);
			
			 rs = ps.executeQuery();
			if(rs.next()) {
				
				exp = rs.getString("exp");
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		profile.setExperience(exp);
		profile.setSkills(skills);
		profile.setAoiList(aoiList);
		return profile;
		
		
		
	}
	
}
