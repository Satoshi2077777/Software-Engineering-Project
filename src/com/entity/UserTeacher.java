package com.entity;

/*
 * ��ʦ�û�ʵ����
 */
public class UserTeacher {
	private String tno; // ��ʦ�û�����
	private String utpsw; // ��ʦ�û�����

	/*
	 * �޲ι���
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
