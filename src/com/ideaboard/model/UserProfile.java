package com.ideaboard.model;

import java.util.List;

public class UserProfile {
String netId;
public String getNetId() {
	return netId;
}
List<String> skills;
List<String> aoiList;
String experience="none";
public UserProfile(String netId) {
	this.netId = netId;
}
public List<String> getSkills() {
	return skills;
}
public void setSkills(List<String> skills) {
	this.skills = skills;
}
public List<String> getAoiList() {
	return aoiList;
}
public void setAoiList(List<String> aoiList) {
	this.aoiList = aoiList;
}
public String getExperience() {
	return experience;
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



}
