package com.ideaboard.model;

import java.util.ArrayList;
import java.util.List;

public class ProjectDetails {

	int projectId;
	List<String> members;
	List<Task> tasks;
	public ProjectDetails() {
		members = new ArrayList<String>();
		tasks = new ArrayList<Task>();
	}
	public void setMembers(List<String> members) {
		this.members = members;
	}
	
	public void addTask(Task task) {
		tasks.add(task);
	}
	public int getProjectId() {
		return projectId;
	}
	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}
	
}
