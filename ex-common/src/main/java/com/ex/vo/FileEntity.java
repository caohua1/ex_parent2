package com.ex.vo;

import java.sql.Timestamp;

public class FileEntity {

	private int id;
    private String type;
    private String size;
    private String path;
    private String titleOrig;
    private String titleAlter;
    private Timestamp uploadTime;
	@Override
	public String toString() {
		return "FileEntity [id=" + id + ", type=" + type + ", size=" + size
				+ ", path=" + path + ", titleOrig=" + titleOrig
				+ ", titleAlter=" + titleAlter + ", uploadTime=" + uploadTime
				+ "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public String getTitleOrig() {
		return titleOrig;
	}
	public void setTitleOrig(String titleOrig) {
		this.titleOrig = titleOrig;
	}
	public String getTitleAlter() {
		return titleAlter;
	}
	public void setTitleAlter(String titleAlter) {
		this.titleAlter = titleAlter;
	}
	public Timestamp getUploadTime() {
		return uploadTime;
	}
	public void setUploadTime(Timestamp uploadTime) {
		this.uploadTime = uploadTime;
	}
	public FileEntity(int id, String type, String size, String path,
			String titleOrig, String titleAlter, Timestamp uploadTime) {
		super();
		this.id = id;
		this.type = type;
		this.size = size;
		this.path = path;
		this.titleOrig = titleOrig;
		this.titleAlter = titleAlter;
		this.uploadTime = uploadTime;
	}
	public FileEntity() {
		super();
	}
    
    
}
