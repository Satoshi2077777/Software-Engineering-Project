package com.entity;

/**
 * ѧ��ʵ����
 * 
 * @author Administrator
 *
 */
public class UserStudent {
	private String sno; // ѧ���û���ѧ��
	private String uspsw; // ѧ���û�������

	/**
	 * �޲ι���
	 */
	public UserStudent() {

	}

	/**
	 * �вι���
	 * 
	 * @param sno
	 * @param spsw
	 */

	public UserStudent(String sno, String spsw) {
		this.sno = sno;
		this.uspsw = spsw;
	}

	/**
	 * ��ȡѧ����ѧ��
	 * 
	 * @return the sno
	 */
	public String getSno() {
		return sno;
	}

	/**
	 * ����ѧ����ѧ��
	 * 
	 * @param sno
	 *            the sno to set
	 */
	public void setSno(String sno) {
		this.sno = sno;
	}

	/**
	 * ��ȡѧ��������
	 * 
	 * @return the spsw
	 */
	public String getUspsw() {
		return uspsw;
	}

	/**
	 * ����ѧ��������
	 * 
	 * @param spsw
	 *            the spsw to set
	 */
	public void setUspsw(String uspsw) {
		this.uspsw = uspsw;
	}

}
