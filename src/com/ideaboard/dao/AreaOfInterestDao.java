package com.ideaboard.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.ideaboard.connection.ConnectionDB;
import com.ideaboard.model.AreaOfInterest;


public class AreaOfInterestDao {
	static Connection con;
	public AreaOfInterestDao(){
		con = ConnectionDB.getConnection();
	}
	public List<AreaOfInterest> get(){
		List<AreaOfInterest> aoiList = new ArrayList<AreaOfInterest>();
try {
			
			PreparedStatement ps = con.prepareStatement("select * from areasofinterest");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				AreaOfInterest aoi  = new AreaOfInterest(id,name);
				aoiList.add(aoi);
			}
			ps.close();
			
		} catch(Exception e) {
			
		}
		return aoiList;
	}
	public AreaOfInterest getById(int id){
		AreaOfInterest aoi = null;
try {
			
			PreparedStatement ps = con.prepareStatement("select * from areasofinterest where id = ?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				int id_local = rs.getInt("id");
				String name = rs.getString("name");
				aoi  = new AreaOfInterest(id_local,name);
				
			}
			ps.close();
			
		} catch(Exception e) {
			
		}
		return aoi;
	}
}
