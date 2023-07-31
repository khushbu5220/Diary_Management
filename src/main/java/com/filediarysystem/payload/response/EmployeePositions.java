package com.filediarysystem.payload.response;

import java.util.List;

import com.filediarysystem.entities.Designation;
import com.filediarysystem.entities.Division;

public class EmployeePositions 
{
	private List<Designation> designation;
	private List<Division> division;
	public EmployeePositions(List<Designation> designation, List<Division> division) {
		super();
		this.designation = designation;
		this.division = division;
	}
	public EmployeePositions() {
		super();
		// TODO Auto-generated constructor stub
	}
	public List<Designation> getDesignation() {
		return designation;
	}
	public void setDesignation(List<Designation> designation) {
		this.designation = designation;
	}
	public List<Division> getDivision() {
		return division;
	}
	public void setDivision(List<Division> division) {
		this.division = division;
	}
	@Override
	public String toString() {
		return "EmployeePositions [designation=" + designation + ", division=" + division + "]";
	}
}
