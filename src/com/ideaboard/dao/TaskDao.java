package com.ideaboard.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.ideaboard.connection.ConnectionDB;
import com.ideaboard.model.Task;




public class TaskDao {
	static Connection con;
	public TaskDao(){
		con = ConnectionDB.getConnection();
	}
	public int create(int projectId, String name, String status, int priority) {
		int result = 0;
		try {
			
			PreparedStatement ps = con.prepareStatement("insert into project_tasks(projectid,name,status,priority) values(?,?,?,?)");
			ps.setInt(1, projectId);
			ps.setString(2, name);
			ps.setString(3,status);
			ps.setInt(4, priority);
			result = ps.executeUpdate();
			ps.close();
			}catch(Exception e) {
				
			}
		return result;
		
	}
	public List<Task> getTasks(int projectId){
		List<Task> tasks = new ArrayList<Task>();
		try {
			PreparedStatement ps = con.prepareStatement("select * from project_tasks where projectid = ?");
			ps.setInt(1, projectId);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Task task = new Task();
				task.setId(rs.getInt("taskid"));
				task.setName(rs.getString("name"));
				task.setStatus(rs.getString("status"));
				task.setPriority(rs.getInt("priority"));
				tasks.add(task);
			}
			
		}catch(Exception e) {
			
		}
		return tasks;
	}
	public void delete(int projectId,String title) {
		try {
			PreparedStatement ps = con.prepareStatement("delete from project_tasks where projectid=? and name= ?");
			ps.setInt(1,projectId);
			ps.setString(2, title);
			ps.executeQuery();
		}catch(Exception e) {
			
		}
		
	}
	public Task getTaskDetails(int projectId,String title) {
		Task task=new Task();
		try {
			PreparedStatement ps = con.prepareStatement("select * from project_tasks where projectid = ? and name=?");
			ps.setInt(1,projectId);
			ps.setString(2, title);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				
				task.setId(rs.getInt("taskid"));
				task.setName(rs.getString("name"));
				task.setStatus(rs.getString("status"));
				task.setPriority(rs.getInt("priority"));
				
			}
		}catch(Exception e) {
			
		}
		
		return task;
	}
	public int update(Task task, int projectId) {
		int status = 0;
		try {
					
					PreparedStatement ps = con.prepareStatement("update project_tasks set name=?,status=?,priority=? where projectid = ? ");
					
					ps.setString(1, task.getName());
					ps.setString(2, task.getStatus());
					ps.setInt(3, task.getPriority());
					ps.setInt(4, projectId);
					
					status = ps.executeUpdate();
					ps.close();
					
				} catch(Exception e) {
					
				}
				return status;
	}
	
	
}