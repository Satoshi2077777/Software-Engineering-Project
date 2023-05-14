package com.entity;

/**
 * 课程实体类
 * 
 * @author xies
 *
 */
public class Course {

	String cno;// 课程号
	String cname;// 课程名
	int cmark; // 学分
	Teacher teacher;// 相应老师
	String ctime;// 上课时间
	String cplace;// 上课地点
	String ckind;// 学科门类
	String cdesc;// 课程描述

	public String getCno() {
		return cno;
	}

	public void setCno(String cno) {
		this.cno = cno;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public int getCmark() {
		return cmark;
	}

	public void setCmark(int cmark) {
		this.cmark = cmark;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public String getCtime() {
		return ctime;
	}

	public void setCtime(String ctime) {
		this.ctime = ctime;
	}

	public String getCplace() {
		return cplace;
	}

	public void setCplace(String cplace) {
		this.cplace = cplace;
	}

	public String getCkind() {
		return ckind;
	}

	public void setCkind(String ckind) {
		this.ckind = ckind;
	}

	public String getCdesc() {
		return cdesc;
	}

	public void setCdesc(String cdesc) {
		this.cdesc = cdesc;
	}

}
