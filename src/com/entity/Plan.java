package com.entity;

public class Plan {
	private String pid;
	private String term;
	private String year;
	private String cno;
	private String RL;

	public Plan() {
	}

	public Plan(String pid, String term, String year, String cno, String RL) {
		// TODO Auto-generated constructor stub
		this.pid = pid;
		this.term = term;
		this.year = year;
		this.cno = cno;
		this.RL = RL;
	}

	public String getPid() {
		return pid;
	}

	public void setPid(String i) {
		this.pid = i;
	}

	public String getTerm() {
		return term;
	}

	public void setTerm(String term) {
		this.term = term;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getCno() {
		return cno;
	}

	public void setCno(String cno) {
		this.cno = cno;
	}

	public String getRL() {
		return RL;
	}

	public void setRL(String rL) {
		RL = rL;
	}

}
