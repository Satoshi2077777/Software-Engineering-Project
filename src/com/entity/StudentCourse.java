package com.entity;

/**
 * ѧ���γ�ʵ����
 * 
 * @author xies
 *
 */
public class StudentCourse {
	@Override
	public String toString() {
		return "StudentCourse [student=" + student.getSno() + ", course=" + course.getCno() + ", cscore=" + cscore
				+ "]";
	}

	private Student student;
	private Course course;
	private int cscore;

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public int getCscore() {
		return cscore;
	}

	public void setCscore(int cscore) {
		this.cscore = cscore;
	}

}
