package com.ideaboard.model;

public class Idea {

	private String netId;
	private int ideaId;
	private String title;
	private String description;
	private int status;
	private IdeaDetails ideaDetails;
	
	public Idea(String netId) {
		this.netId = netId;
	}
	public String getNetId() {
		return netId;
	}
	public void setNetId(String netId) {
		this.netId = netId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public IdeaDetails getIdeaDetails() {
		return ideaDetails;
	}
	public void setIdeaDetails(IdeaDetails ideaDetails) {
		this.ideaDetails = ideaDetails;
	}
	public int getIdeaId() {
		return ideaId;
	}
	public void setIdeaId(int ideaId) {
		this.ideaId = ideaId;
	}
	
}
