package com.entity;

/**
 * adminʵ����
 * 
 * @author Administrator
 *
 */
public class Admin {
	private int aid; // ����Ա���
	private String aname; // ����Ա�˻�
	private String apsw; // ����Ա����

	/**
	 * �޲ι���
	 */
	public Admin() {

	}

	/**
	 * �вι���
	 * 
	 * @param aname
	 * @param apsw
	 */
	public Admin(String aname, String apsw) {
		this.aname = aname;
		this.apsw = apsw;
	}

	/**
	 * ��ȡaid
	 * 
	 * @return the aid
	 */
	public int getAid() {
		return aid;
	}

	/**
	 * ����aid
	 * 
	 * @param aid
	 *            the aid to set
	 */
	public void setAid(int aid) {
		this.aid = aid;
	}

	/**
	 * ��ȡaname
	 * 
	 * @return the aname
	 */
	public String getAname() {
		return aname;
	}

	/**
	 * ����aname
	 * 
	 * @param aname
	 *            the aname to set
	 */
	public void setAname(String aname) {
		this.aname = aname;
	}

	/**
	 * ��ȡapsw
	 * 
	 * @return the apsw
	 */
	public String getApsw() {
		return apsw;
	}

	/**
	 * ����apsw
	 * 
	 * @param apsw
	 *            the apsw to set
	 */
	public void setApsw(String apsw) {
		this.apsw = apsw;
	}

}
