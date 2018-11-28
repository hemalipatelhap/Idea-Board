package com.ideaboard.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.ideaboard.connection.ConnectionDB;
import com.ideaboard.model.Request;

public class RequestDao {
	Connection con;
	public RequestDao(){
		con = ConnectionDB.getConnection();
	}
	
	public List<Request> getRequests(String netId) {
		List<Request> requests = new ArrayList<Request>();
		try {
			PreparedStatement ps = con.prepareStatement("select * from requests where netid=?");
			ps.setString(1, netId);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Request request = new Request();
				request.setRequestId(rs.getInt("requestid"));
				request.setIdeaId(rs.getInt("ideaID"));
				request.setNetId(rs.getString("netId"));
				request.setStatus(rs.getString("status"));
				requests.add(request);
			}
			
		}catch(Exception e) {
			
		}
		return requests;
	}
	public List<String> getApprovedRequests(int ideaId){
		List<String> members = new ArrayList<String>();
		try {
			PreparedStatement ps = con.prepareStatement("select * from requests where ideaid=? and status = 'approve'");
			ps.setInt(1, ideaId);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				
				members.add(rs.getString("netid"));
				
			}
			
		}catch(Exception e) {
			
		}
		return members;
	}
	public List<Request> getRequests(int ideaId) {
		List<Request> requests = new ArrayList<Request>();
		try {
			PreparedStatement ps = con.prepareStatement("select * from requests where ideaid=? and status = 'applied'");
			ps.setInt(1, ideaId);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Request request = new Request();
				request.setRequestId(rs.getInt("requestid"));
				request.setIdeaId(rs.getInt("ideaID"));
				request.setNetId(rs.getString("netId"));
				request.setStatus(rs.getString("status"));
				requests.add(request);
			}
			
		}catch(Exception e) {
			
		}
		return requests;
	}

	public int updateRequests(int requestId, String decision) {
		int i = 0;
		try {
			System.out.println("updating requests"+ requestId +":"+ decision);
			PreparedStatement ps = con.prepareStatement("update requests SET status=? where requestid=?");
			ps.setString(1, decision);
			ps.setInt(2, requestId);
			i = ps.executeUpdate();	
			
			System.out.println("status" + i);
		
		}catch(Exception e) {
			
		}
		return i;
		
	}
	public int createRequests(Request ideaRequest) {
		int status =0;
		try {
			
			PreparedStatement ps = con.prepareStatement("insert into requests(requestid,ideaid,netid,status) values(?,?,?,?)");
			
			ps.setInt(1, 8);
			ps.setInt(2, ideaRequest.getIdeaId());
			ps.setString(3, ideaRequest.getNetId());
			ps.setString(4, ideaRequest.getStatus());
			//ps.setInt(4, idea.getStatus());
			status=ps.executeUpdate();
			
		} catch(Exception e) {
			
		}
		return status;
	}
}
