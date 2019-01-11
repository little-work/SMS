package com.alibaba.wms.bean;

public class Cost {
	
	
	private String course_id;
	private String course_cost_stud;
	private String course_cost_teach;
	private String course_discount;
	private String course_activity;
	private String course_cost_total_stud;
	private String course_cost_total_teach;
	private String actual_cost_stud;
	public String getCourse_id() {
		return course_id;
	}
	public void setCourse_id(String course_id) {
		this.course_id = course_id;
	}
	public String getCourse_cost_stud() {
		return course_cost_stud;
	}
	public void setCourse_cost_stud(String course_cost_stud) {
		this.course_cost_stud = course_cost_stud;
	}
	public String getCourse_cost_teach() {
		return course_cost_teach;
	}
	public void setCourse_cost_teach(String course_cost_teach) {
		this.course_cost_teach = course_cost_teach;
	}
	public String getCourse_discount() {
		return course_discount;
	}
	public void setCourse_discount(String course_discount) {
		this.course_discount = course_discount;
	}
	public String getCourse_activity() {
		return course_activity;
	}
	public void setCourse_activity(String course_activity) {
		this.course_activity = course_activity;
	}
	public String getCourse_cost_total_stud() {
		return course_cost_total_stud;
	}
	public void setCourse_cost_total_stud(String course_cost_total_stud) {
		this.course_cost_total_stud = course_cost_total_stud;
	}
	public String getCourse_cost_total_teach() {
		return course_cost_total_teach;
	}
	public void setCourse_cost_total_teach(String course_cost_total_teach) {
		this.course_cost_total_teach = course_cost_total_teach;
	}
	public String getActual_cost_stud() {
		return actual_cost_stud;
	}
	public void setActual_cost_stud(String actual_cost_stud) {
		this.actual_cost_stud = actual_cost_stud;
	}
	@Override
	public String toString() {
		return "Cost [course_id=" + course_id + ", course_cost_stud=" + course_cost_stud + ", course_cost_teach="
				+ course_cost_teach + ", course_discount=" + course_discount + ", course_activity=" + course_activity
				+ ", course_cost_total_stud=" + course_cost_total_stud + ", course_cost_total_teach="
				+ course_cost_total_teach + ", actual_cost_stud=" + actual_cost_stud + "]";
	}
	
	
	
	
	

}
