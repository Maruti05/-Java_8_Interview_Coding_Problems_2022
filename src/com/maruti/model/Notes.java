package com.maruti.model;

public class Notes {
	private int id;
	private String name;
	private int quatity;
	
	public Notes(int id, String name, int quatity) {
		super();
		this.id = id;
		this.name = name;
		this.quatity = quatity;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getQuatity() {
		return quatity;
	}
	public void setQuatity(int quatity) {
		this.quatity = quatity;
	}
	@Override
	public String toString() {
		return "Notes [id=" + id + ", name=" + name + ", quatity=" + quatity + "]";
	}
	
	
}
