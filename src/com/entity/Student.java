package com.entity;

import java.sql.Date;

/**
 * ѧ��ʵ����
 * 
 * @author xies
 *
 */
public class Student {
	private String sno; // ѧ��ѧ��
	private String sname; // ѧ������
	int sex; // �Ա�
	private String sclass; // ���ڰ༶
	private String department; // ����Ժϵ
	private String nationality; // ����
	private String nativeplace; // ����
	private String telephone; // ��ϵ�绰
	private String major; // רҵ
	private Date sbirth;

	public Student() {
	}

	// ѧ�Ź��췽��
	public Student(String sno) {
		this.sno = sno;
	}

	// ���췽��
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
