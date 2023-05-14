package com.entity;

/*
 * 教师用户实体类
 */
public class UserTeacher {
	private String tno; // 教师用户工号
	private String utpsw; // 教师用户密码

	/*
	 * 无参构造
	 */
	public UserTeacher() {

	}

	public UserTeacher(String tno, String utpsw) {
		this.tno = tno;
		this.utpsw = utpsw;
	}

	/**
	 * @return the tno
	 */
	public String getTno() {
		return tno;
	}

	/**
	 * @param tno
	 *            the tno to set
	 */
	public void setTno(String tno) {
		this.tno = tno;
	}

	/**
	 * @return the upsw
	 */
	public String getUtpsw() {
		return utpsw;
	}

	/**
	 * @param upsw
	 *            the upsw to set
	 */
	public void setUtpsw(String utpsw) {
		this.utpsw = utpsw;
	}

}
