package com.filediarysystem.payload.response;

import java.util.List;

import com.filediarysystem.entities.FileDiary;
import com.filediarysystem.entities.FileMovementHistory;

public class FileDiaryResponse 
{
	private FileDiary filediary;
	private List<FileMovementHistory> filemovementhistory;
	public FileDiaryResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	public FileDiaryResponse(FileDiary filediary, List<FileMovementHistory> filemovementhistory) {
		super();
		this.filediary = filediary;
		this.filemovementhistory = filemovementhistory;
	}
	public FileDiary getFilediary() {
		return filediary;
	}
	public void setFilediary(FileDiary filediary) {
		this.filediary = filediary;
	}
	public List<FileMovementHistory> getFilemovementhistory() {
		return filemovementhistory;
	}
	public void setFilemovementhistory(List<FileMovementHistory> filemovementhistory) {
		this.filemovementhistory = filemovementhistory;
	}
	@Override
	public String toString() {
		return "FileDiaryResponse [filediary=" + filediary + ", filemovementhistory=" + filemovementhistory + "]";
	} 
}
