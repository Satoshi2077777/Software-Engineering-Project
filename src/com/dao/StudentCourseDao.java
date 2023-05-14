package com.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.entity.Course;
import com.entity.Student;
import com.entity.StudentCourse;
import com.entity.Teacher;
import com.util.JDBCUtil;

public class StudentCourseDao {

	public int insertStudentCourse(StudentCourse studentCourse) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet result = null;
		int flag = 0;
		try {
			conn = JDBCUtil.getConnection();
			Student s = studentCourse.getStudent();
			Course c = studentCourse.getCourse();
			String sno = s.getSno();
			String cno = c.getCno();
			int i = studentCourse.getCscore();
			int cscore = studentCourse.getCscore();
			System.out.println("rrr");
			String sql = "insert into student_course values(?,?,?,?)";
			ps = conn.prepareStatement(sql);
			ps.setString(1, sno);
			ps.setString(2, cno);
			ps.setInt(3, cscore);
			ps.setInt(4, 0);
			System.out.println(sno);
			System.out.println(cno);
			System.out.println(cscore);
			flag = ps.executeUpdate();
			System.out.println(sno);
			System.out.println(cno);
			System.out.println(cscore);
			System.out.println(ps.toString());

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			JDBCUtil.closeResource(conn, ps, result);
			return flag;
		}
	}

	public int updateStudentCourse(StudentCourse studentCourse) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet result = null;
		int flag = 0;
		try {
			conn = JDBCUtil.getConnection();
			Student s = studentCourse.getStudent();
			Course c = studentCourse.getCourse();
			String sno = s.getSno();
			String cno = c.getCno();
			int cscore = studentCourse.getCscore();

			String sql = "update student_course set cscore=? where sno=? and cno=? ";
			ps = conn.prepareStatement(sql);
			ps.setString(2, sno);
			ps.setString(3, cno);
			ps.setInt(1, cscore);
			flag = ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.closeResource(conn, ps, result);
			return flag;
		}
	}

	public int updateStudentCourseStatu(String sno, String cno) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet result = null;
		int flag = 0;
		try {
			conn = JDBCUtil.getConnection();

			String sql = "update student_course set STATU=1 where sno=? and cno=? ";
			ps = conn.prepareStatement(sql);
			ps.setString(1, sno);
			ps.setString(2, cno);

			flag = ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.closeResource(conn, ps, result);
			return flag;
		}
	}

	public int SelectStatu(String sno, String cno) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet result = null;
		int flag = 0;
		try {
			conn = JDBCUtil.getConnection();

			String sql = "select * from student_course where STATU='1' and sno=? and cno=? ";
			ps = conn.prepareStatement(sql);
			ps.setString(1, sno);
			ps.setString(2, cno);
			System.out.println(ps.toString());
			result = ps.executeQuery();
			while (result.next()) {

				flag = 1;
			}
			return flag;

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.closeResource(conn, ps, result);
			return flag;
		}
	}

	public int delStudentCourse(StudentCourse studentCourse) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet result = null;
		int flag = 0;
		try {
			conn = JDBCUtil.getConnection();
			Course course = studentCourse.getCourse();
			String cno = course.getCno();
			String sql = "delete  from student_course where cno=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, cno);
			flag = ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.closeResource(conn, ps, result);
			return flag;
		}
	}

	public StudentCourse selectStudentCourse(StudentCourse studentCourse) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet result = null;
		StudentCourse s = null;
		int flag = 0;
		try {
			conn = JDBCUtil.getConnection();
			Course c = studentCourse.getCourse();
			String cno = c.getCno();

			String sql = "select *from student_course where cno=? and sno=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, cno);

			Student st2 = studentCourse.getStudent();
			ps.setString(2, st2.getSno());
			result = ps.executeQuery();
			while (result.next()) {
				s = new StudentCourse();
				String sno = result.getString(1);
				String cno2 = result.getString(2);
				int cscore = result.getInt(3);

				Course course = new Course();
				course.setCno(cno2);
				Student st = new Student();
				st.setSno(sno);

				s.setCourse(course);
				s.setStudent(st);
				s.setCscore(cscore);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.closeResource(conn, ps, result);
			return s;
		}
	}

	public List<StudentCourse> selectStudentCourseListByStudent(Student s) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet result = null;
		List<StudentCourse> list = new ArrayList<StudentCourse>();
		int flag = 0;
		try {
			conn = JDBCUtil.getConnection();
			String sno = s.getSno();

			String sql = "select c.cno,c.cname,c.ctime,c.cplace,t.tno,t.tname,c.ckind,c.cdesc,c.cmark,sc.cscore "
					+ " from course c,teacher t,student_course sc "
					+ " where sc.sno=? and c.cno=sc.cno and c.tno=t.tno";
			ps = conn.prepareStatement(sql);
			ps.setString(1, sno);
			result = ps.executeQuery();
			while (result.next()) {
				StudentCourse studentCourse = new StudentCourse();
				Course course = new Course();
				course.setCno(result.getString("cno"));
				course.setCname(result.getString("cname"));
				course.setCkind(result.getString("ckind"));
				course.setCdesc(result.getString("cdesc"));
				course.setCmark(result.getInt("cmark"));
				course.setCplace(result.getString("cplace"));
				course.setCtime(result.getString("ctime"));

				Teacher t = new Teacher();
				String tno = result.getString("tno");
				String tname = result.getString("tname");
				t.setTno(tno);
				t.setTname(tname);
				course.setTeacher(t);
				int cscore = result.getInt("cscore");

				studentCourse.setCourse(course);
				studentCourse.setStudent(s);

				studentCourse.setCscore(cscore);
				list.add(studentCourse);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.closeResource(conn, ps, result);
			return list;
		}

	}

	public List<StudentCourse> selectStudentCourseListByCourse(Course c) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet result = null;
		List<StudentCourse> list = new ArrayList<StudentCourse>();
		int flag = 0;
		try {
			conn = JDBCUtil.getConnection();
			String tno = c.getTeacher().getTno();
			StringBuffer sql = new StringBuffer("select c.cno,c.cname,c.cmark,s.sname,sc.sno,sc.cscore from "
					+ "course c,student_course sc,student s " + " where  c.cno=sc.cno and s.sno=sc.sno and c.tno='"
					+ tno + "'");
			String cname = c.getCname();
			if (!("".equals(cname))) {
				sql.append(" and c.cname='" + cname + "'");
			}

			ps = conn.prepareStatement(String.valueOf(sql));
			result = ps.executeQuery();

			while (result.next()) {
				StudentCourse studentCourse = new StudentCourse();
				Course course = new Course();
				course.setCno(result.getString("cno"));
				course.setCname(result.getString("cname"));
				course.setCmark(result.getInt("cmark"));

				Student s = new Student();
				s.setSno(result.getString("sno"));
				s.setSname(result.getString("sname"));

				studentCourse.setCourse(course);
				studentCourse.setStudent(s);
				studentCourse.setCscore(result.getInt("cscore"));
				list.add(studentCourse);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.closeResource(conn, ps, result);
			return list;
		}

	}
	public String checkselectcoursetime(String str)
	{
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet result = null;
		String selecttime=null;
		String flag ="未到";
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			java.util.Date d = sdf.parse(str); //转换为util.date
			conn = JDBCUtil.getConnection();
		
			String sql = "select APSW from admin where ANAME='selectcoursetime'";
			ps = conn.prepareStatement(sql);
			result = ps.executeQuery();
			while (result.next()) {
				selecttime=result.getString("APSW");
			}
			
			if(d.compareTo(sdf.parse(selecttime))<0)
            {
                flag=selecttime;
            }
            else
            {
                flag="到期";
            }

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} 
		catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			JDBCUtil.closeResource(conn, ps, result);
			return flag;
		}
	}
	public void updateselectcoursetime(String str)
	{
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet result = null;
		String selecttime=null;
		int flag;
		try {
			conn = JDBCUtil.getConnection();

			String sql = "update admin set APSW=? where ANAME='selectcoursetime' ";
			ps = conn.prepareStatement(sql);
			ps.setString(1, str);
		

			flag = ps.executeUpdate();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} 
		catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			JDBCUtil.closeResource(conn, ps, result);
			
		}
	}
	public static void main(String args[])
	{
		StudentCourseDao a=new StudentCourseDao();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println(a.checkselectcoursetime("2018-05-28 08:20:50"));
		System.out.println(a.checkselectcoursetime("2018-05-28 09:30:50"));
		System.out.println(a.checkselectcoursetime(sdf.format(new java.util.Date()).toString()));
		
	}

	public List<Student> getStudentList(Student student) {
		// TODO Auto-generated method stub
		return null;
	}

}
