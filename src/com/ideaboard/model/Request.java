package com.ideaboard.model;

public class Request {
	
	private int requestId;
	private String netId;
	private int ideaId;
	private String status;
	
	public String getNetId() {
		return netId;
	}
	public void setNetId(String netId) {
		this.netId = netId;
	}
	public int getIdeaId() {
		return ideaId;
	}
	public void setIdeaId(int ideaId) {
		this.ideaId = ideaId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getRequestId() {
		return requestId;
	}
	public void setRequestId(int requestId) {
		this.requestId = requestId;
	}
	

}
