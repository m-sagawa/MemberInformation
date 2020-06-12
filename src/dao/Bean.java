package dao;

import java.io.Serializable;

public class Bean implements Serializable {

	private String member;
	private String name;
	private int age;
	private int year;
	private int month;
	private int day;

	public String getMember() {
		return member;
	}
	public void setMember(String member) {
		this.member = member;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	public int getDay() {
		return day;
	}
	public void setDay(int day) {
		this.day = day;
	}
}
