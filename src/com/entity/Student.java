package com.entity;

import java.sql.Date;

/**
 * 学生实体类
 * 
 * @author xies
 *
 */
public class Student {
	private String sno; // 学生学号
	private String sname; // 学生姓名
	int sex; // 性别
	private String sclass; // 所在班级
	private String department; // 所属院系
	private String nationality; // 民族
	private String nativeplace; // 籍贯
	private String telephone; // 联系电话
	private String major; // 专业
	private Date sbirth;

	public Student() {
	}

	// 学号构造方法
	public Student(String sno) {
		this.sno = sno;
	}

	// 构造方法
	public String getSno() {
		return sno;
	}

	public void setSno(String sno) {
		this.sno = sno;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public int getSex() {
		return sex;
	}

	public void setSex(int sex) {
		this.sex = sex;
	}

	public String getSclass() {
		return sclass;
	}

	public void setSclass(String sclass) {
		this.sclass = sclass;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public String getNativeplace() {
		return nativeplace;
	}

	public void setNativeplace(String nativeplace) {
		this.nativeplace = nativeplace;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public Date getSbirth() {
		return sbirth;
	}

	public void setSbirth(Date sbirth) {
		this.sbirth = sbirth;
	}

}
