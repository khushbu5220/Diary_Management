package com.filediarysystem.payload.response;

import java.util.List;

import com.filediarysystem.entities.NavBarOption;

public class NavBarOptionsResponse 
{
	private String username;
	private NavBarOption parent;
	private List<NavBarOption> child;
	public NavBarOptionsResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	public NavBarOptionsResponse(String username, NavBarOption parent, List<NavBarOption> child) {
		super();
		this.username = username;
		this.parent = parent;
		this.child = child;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public NavBarOption getParent() {
		return parent;
	}
	public void setParent(NavBarOption parent) {
		this.parent = parent;
	}
	public List<NavBarOption> getChild() {
		return child;
	}
	public void setChild(List<NavBarOption> child) {
		this.child = child;
	}
	@Override
	public String toString() {
		return "NavBarOptionsResponse [username=" + username + ", parent=" + parent + ", child=" + child + "]";
	}
}
