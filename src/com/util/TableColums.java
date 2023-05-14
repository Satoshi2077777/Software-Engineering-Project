package com.util;

public class TableColums {
	public static String[] getStudentColums() {
		String[] colums = new String[] { "学号", "姓名", "性别", "出生日期", "联系电话", "院系", "专业", "班级", "民族", "籍贯" };
		return colums;
	}

	public static String[] getRoomColums() {
		String[] colums = new String[] { "A201", "A202", "A203", "A204", "A205", "A206", "B301", "B302" + "B303",
				"B305", "B306", "第五微机室", "第四微机室", "第三微机室", "第二微机室", "第一微机室" };
		return colums;
	}

	public static String[] getTeacherColums() {
		String[] colums = new String[] { "学号", "姓名", "性别", "出生日期", "联系电话", "院系", "民族", "籍贯" };
		return colums;
	}

	public static String[] getCourseColums() {
		String[] colums = { "课程编号", "课程名称", "学分", "授课教师", "时间", "地点", "学科门类", "课程描述" };
		return colums;
	}

	public static String[] getSelectColums() {
		String[] colums = { "课程编号", "课程名称", "学分", "授课教师", "学科门类", "课程描述" };
		return colums;
	}

	public static String[] getScoreColums() {
		String[] colums = { "课程编号", "课程名称", "学分", "授课教师", "学科门类", "成绩" };
		return colums;
	}

	public static String[] getTeacherCourseColums() {
		String[] colums = { "课程编号", "课程名称", "学分", "授课教师", "学科门类", "课程描述" };
		return colums;
	}

	public static String[] getTeacherScoreColums() {
		String[] colums = { "课程编号", "课程名称", "学分", "学号", "姓名", "成绩" };
		return colums;
	}

	public static String[] getAdminRoomColums() {
		String[] colums = { "预约编号", "教室名称", "预约人", "可用状态", "预约时间" };
		return colums;
	}

	public static String[] getPlanColums() {
		String[] colums = { "培养专业", "学年", "学期", "课程名称", "课程学分", "课程类别", "课程容量" };
		return colums;
	}

	public static String[] getAdminThingColums() {
		String[] colums = { "通知编号", "通知内容", "通知时间" };
		return colums;
	}
}
