package com.hualuo.springmvc.domain;

/**
 * @author Joseph 
 *
 */
public class DemoObj {
	
	private long id;
	private String name;

	/**
	 * @param id
	 * @param name
	 */
	public DemoObj(long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public DemoObj() {
		super();
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
