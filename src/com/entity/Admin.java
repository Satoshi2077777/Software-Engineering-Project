package com.entity;

/**
 * admin实体类
 * 
 * @author Administrator
 *
 */
public class Admin {
	private int aid; // 管理员编号
	private String aname; // 管理员账户
	private String apsw; // 管理员密码

	/**
	 * 无参构造
	 */
	public Admin() {

	}

	/**
	 * 有参构造
	 * 
	 * @param aname
	 * @param apsw
	 */
	public Admin(String aname, String apsw) {
		this.aname = aname;
		this.apsw = apsw;
	}

	/**
	 * 获取aid
	 * 
	 * @return the aid
	 */
	public int getAid() {
		return aid;
	}

	/**
	 * 设置aid
	 * 
	 * @param aid
	 *            the aid to set
	 */
	public void setAid(int aid) {
		this.aid = aid;
	}

	/**
	 * 获取aname
	 * 
	 * @return the aname
	 */
	public String getAname() {
		return aname;
	}

	/**
	 * 设置aname
	 * 
	 * @param aname
	 *            the aname to set
	 */
	public void setAname(String aname) {
		this.aname = aname;
	}

	/**
	 * 获取apsw
	 * 
	 * @return the apsw
	 */
	public String getApsw() {
		return apsw;
	}

	/**
	 * 设置apsw
	 * 
	 * @param apsw
	 *            the apsw to set
	 */
	public void setApsw(String apsw) {
		this.apsw = apsw;
	}

}
