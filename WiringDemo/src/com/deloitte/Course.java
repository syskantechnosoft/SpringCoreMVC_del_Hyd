package com.deloitte;

public class Course {
	private int id;
	private String name;
	private int duration;
	private String description;
	private String url;

	public Course() {
		super();
	}

	public Course(int id, String name, int duration, String description, String url) {
		super();
		this.id = id;
		this.name = name;
		this.duration = duration;
		this.description = description;
		this.url = url;
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

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public String toString() {
		return "Course [id=" + id + ", name=" + name + ", duration=" + duration + ", description=" + description
				+ ", url=" + url + "]";
	}

}
