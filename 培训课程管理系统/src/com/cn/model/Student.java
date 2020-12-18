package com.cn.model;

//学生实体类
public class Student {
	private int id;
	private String name;	//姓名
	private String age;		//年龄
	private String address;	//地址
	private String tel;		//课程
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
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public Student(int id, String name, String age, String address, String tel) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.address = address;
		this.tel = tel;
	}
	public Student() {
		super();
	}
	
	
}
