package com.ideaboard.model;

import java.util.List;

public class IdeaDetails {

   /* String netId;
	
	String title;*/
	
	
	List<String> skills;
	String experience="none";
	public List<String> getSkills() {
		return skills;
	}
	public void setSkills(List<String> skills) {
		this.skills = skills;
	}
	public String getExperience() {
		return experience;
	}
	public int getExperienceVal() {
		if(getExperience().equals("less than 1 year")) return 1;
		else if(getExperience().equals("1-2 years")) return 2;
		else if(getExperience().equals("3-5 years")) return 3;
		else if(getExperience().equals("more than 5 years")) return 4;
		return 0;
	}
	public void setExperience(int value) {
		 switch (value) { 
	     case 1: 
	         experience = "less than 1 year"; 
	         break; 
	     case 2: 
	    	 experience = "1-2 years"; 
	         break; 
	     case 3: 
	    	 experience = "3-5 years"; 
	         break; 
	     case 4: 
	    	 experience = "more than 5 years"; 
	         break; 
	     default: 
	    	 experience  = "none"; 
	         break; 
		 }
	}
	public void setExperience(String exp) {
		this.experience = exp;
	}
	/*public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getNetId() {
		return netId;
	}
	public void setNetId(String netId) {
		this.netId = netId;
	}*/
	
}
