package com.entity;

/**
 * room实体类
 * 
 * @author Administrator
 *
 */
public class Room {
	private int rid; // 教室编号
	private String rname; // 教师名称
	private String pname; // 预约人姓名
	private String ptime; // 预约人姓名
	private String pstatu; // 可用状态

	public Room() {
	}

	public Room(int rid, String rname, String pname, String ptime, String pstatu) {
		super();
		this.rid = rid;
		this.rname = rname;
		this.pname = pname;
		this.ptime = ptime;
		this.pstatu = pstatu;
	}

	public int getRid() {
		return rid;
	}

	public void setRid(int rid) {
		this.rid = rid;
	}

	public String getRname() {
		return rname;
	}

	public void setRname(String rname) {
		this.rname = rname;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public String getPtime() {
		return ptime;
	}

	public void setPtime(String ptime) {
		this.ptime = ptime;
	}

	public String getPstatu() {
		return pstatu;
	}

	public void setPstatu(String pstatu) {
		this.pstatu = pstatu;
	}

}
