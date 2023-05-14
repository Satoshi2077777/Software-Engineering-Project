package com.entity;

/**
 * 学生实体类
 * 
 * @author Administrator
 *
 */
public class UserStudent {
	private String sno; // 学生用户的学号
	private String uspsw; // 学生用户的密码

	/**
	 * 无参构造
	 */
	public UserStudent() {

	}

	/**
	 * 有参构造
	 * 
	 * @param sno
	 * @param spsw
	 */

	public UserStudent(String sno, String spsw) {
		this.sno = sno;
		this.uspsw = spsw;
	}

	/**
	 * 获取学生的学号
	 * 
	 * @return the sno
	 */
	public String getSno() {
		return sno;
	}

	/**
	 * 设置学生的学号
	 * 
	 * @param sno
	 *            the sno to set
	 */
	public void setSno(String sno) {
		this.sno = sno;
	}

	/**
	 * 获取学生的密码
	 * 
	 * @return the spsw
	 */
	public String getUspsw() {
		return uspsw;
	}

	/**
	 * 设置学生的密码
	 * 
	 * @param spsw
	 *            the spsw to set
	 */
	public void setUspsw(String uspsw) {
		this.uspsw = uspsw;
	}

}
