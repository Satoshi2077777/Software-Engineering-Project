package com.entity;

/**
 * �γ�ʵ����
 * 
 * @author xies
 *
 */
public class Course {

	String cno;// �γ̺�
	String cname;// �γ���
	int cmark; // ѧ��
	Teacher teacher;// ��Ӧ��ʦ
	String ctime;// �Ͽ�ʱ��
	String cplace;// �Ͽεص�
	String ckind;// ѧ������
	String cdesc;// �γ�����

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
