package com.ideaboard.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.ideaboard.connection.ConnectionDB;
import com.ideaboard.model.Skill;

public class SkillDao {

	Connection con;
	public SkillDao(){
		con = ConnectionDB.getConnection();
	}
	public List<Skill> get(){
		List<Skill> skills = new ArrayList<Skill>();
try {
			
			PreparedStatement ps = con.prepareStatement("select * from skills");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				Skill skill = new Skill(id,name);
				skills.add(skill);
			}
			ps.close();
			con.close();
		} catch(Exception e) {
			
		}
		return skills;
	}
	public Skill getById(int id){
		Skill skill = null;
try {
			
			PreparedStatement ps = con.prepareStatement("select * from skills where id= ?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				int id_local = rs.getInt("id");
				String name = rs.getString("name");
				skill = new Skill(id_local,name);
				
			}
			ps.close();
			con.close();
		} catch(Exception e) {
			
		}
		return skill;
	}
}
