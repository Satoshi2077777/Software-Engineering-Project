package com.entity;

/**
 * roomʵ����
 * 
 * @author Administrator
 *
 */
public class Room {
	private int rid; // ���ұ��
	private String rname; // ��ʦ����
	private String pname; // ԤԼ������
	private String ptime; // ԤԼ������
	private String pstatu; // ����״̬

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
