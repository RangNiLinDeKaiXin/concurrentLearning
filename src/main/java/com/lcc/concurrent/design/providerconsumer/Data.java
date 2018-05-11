package com.lcc.concurrent.design.providerconsumer;

/**
 * @author: lcc
 * @Date: 2018-05-11
 **/
public final class Data {

	private String id;
	private String name;

	public Data(String id, String name) {
		this.id = id;
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "{id: " + id + ", name: " + name + "}";
	}

}
