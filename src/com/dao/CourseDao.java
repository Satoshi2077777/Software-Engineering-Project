package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.entity.Course;
import com.entity.Teacher;
import com.util.JDBCUtil;

public class CourseDao {

	public int insertCourse(Course course) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet result = null;
		int flag = 0;
		try {
			conn = JDBCUtil.getConnection();
			String cno = course.getCno();
			String cname = course.getCname();
			int cmark = course.getCmark();
			Teacher teacher = course.getTeacher();
			String tno = teacher.getTno();
			String ctime = course.getCtime();
			String cplace = course.getCplace();
			String ckind = course.getCkind();
			String cdesc = course.getCdesc();
			String sql = "insert into course values(?,?,?,?,?,?,?,?)";
			System.out.println("insertCourse(Course course)" + sql);

			ps = conn.prepareStatement(sql);

			ps.setString(1, cno);
			ps.setString(2, cname);
			ps.setInt(3, cmark);
			ps.setString(4, tno);
			ps.setString(5, ctime);
			ps.setString(6, cplace);
			ps.setString(7, ckind);
			ps.setString(8, cdesc);
			flag = ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.closeResource(conn, ps, result);
			return flag;
		}
	}

	public int updateCourse(Course course) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet result = null;
		int flag = 0;
		try {
			conn = JDBCUtil.getConnection();
			String cno = course.getCno();
			String cname = course.getCname();
			int cmark = course.getCmark();
			Teacher teacher = course.getTeacher();
			String tno = teacher.getTno();
			String ctime = course.getCtime();
			String cplace = course.getCplace();
			String ckind = course.getCkind();
			String cdesc = course.getCdesc();
			String sql = "update course set cname=?,cmark=?,tno=?," + "ctime=?,cplace=?,ckind=?,cdesc=? where cno=?";
			System.out.println("updateCourse(Course course)" + sql);

			ps = conn.prepareStatement(sql);

			ps.setString(1, cname);
			ps.setInt(2, cmark);
			ps.setString(3, tno);
			ps.setString(4, ctime);
			ps.setString(5, cplace);
			ps.setString(6, ckind);
			ps.setString(7, cdesc);
			ps.setString(8, cno);
			flag = ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.closeResource(conn, ps, result);
			return flag;
		}
	}

	public int delCourse(Course course) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet result = null;
		int flag = 0;
		try {
			conn = JDBCUtil.getConnection();
			String cno = course.getCno();
			String sql = "delete from course where cno=?";

			ps = conn.prepareStatement(sql);
			ps.setString(1, cno);
			flag = ps.executeUpdate();
			System.out.println("delCourse(Course course)" + ps.toString());
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.closeResource(conn, ps, result);
			return flag;
		}
	}

	public Course selectCourse(Course course) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet result = null;
		Course c = null;
		try {
			conn = JDBCUtil.getConnection();
			String sql = "select * from course where cno=?";

			ps = conn.prepareStatement(sql);
			String cno = course.getCno();
			ps.setString(1, cno);
			System.out.println("course selectCourse(Course course) " + ps.toString());
			result = ps.executeQuery();
			while (result.next()) {
				c = new Course();
				c.setCno(result.getString("cno"));
				c.setCname(result.getString("cname"));
				c.setCmark(result.getInt("cmark"));
				Teacher t = new Teacher();
				t.setTno(result.getString("tno"));
				c.setTeacher(t);
				c.setCtime(result.getString("ctime"));
				c.setCplace(result.getString("cplace"));
				c.setCkind(result.getString("ckind"));
				c.setCdesc(result.getString("cdesc"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.closeResource(conn, ps, result);
			return c;
		}
	}

	public List<Course> selectCourseList(Course course) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet result = null;
		ArrayList<Course> list = new ArrayList<Course>();
		try {
			conn = JDBCUtil.getConnection();
			String cno = course.getCno();
			String cname = course.getCname();
			String ckind = course.getCkind();

			StringBuffer sql = new StringBuffer("select *from course where 1=1");
			System.out.println("selectCourseList(Course course) " + sql);

			if (!("".equals(cno)) & cno != null) {
				sql.append(" and cno= '" + cno + "'");
			}
			if (!("".equals(cname)) && cname != null) {
				sql.append(" and cname= '" + cname + "'");
			}
			if (!("").equals(ckind) && ckind != null) {
				sql.append(" and ckind like '" + ckind + "'");
			}
			ps = conn.prepareStatement(String.valueOf(sql));
			result = ps.executeQuery();
			while (result.next()) {

				Course c = new Course();
				c.setCno(result.getString("cno"));
				c.setCname(result.getString("cname"));
				c.setCmark(result.getInt("cmark"));
				Teacher t = new Teacher();
				t.setTno(result.getString("tno"));
				c.setTeacher(t);
				c.setCtime(result.getString("ctime"));
				c.setCplace(result.getString("cplace"));
				c.setCkind(result.getString("ckind"));
				c.setCdesc(result.getString("cdesc"));
				list.add(c);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.closeResource(conn, ps, result);
			return list;
		}
	}

	public List<Course> selectCourseListByTeacher(Teacher t) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet result = null;
		ArrayList<Course> list = new ArrayList<Course>();
		try {
			conn = JDBCUtil.getConnection();
			String tno = t.getTno();
			String sql = "select *from course where tno=?";
			System.out.println("selectCourseListByTeacher(Teacher t) " + sql);

			ps = conn.prepareStatement(sql);
			ps.setString(1, t.getTno());
			result = ps.executeQuery();
			while (result.next()) {

				Course c = new Course();
				c.setCno(result.getString("cno"));
				c.setCname(result.getString("cname"));
				c.setCmark(result.getInt("cmark"));
				c.setTeacher(t);
				c.setCtime(result.getString("ctime"));
				c.setCplace(result.getString("cplace"));
				c.setCkind(result.getString("ckind"));
				c.setCdesc(result.getString("cdesc"));
				list.add(c);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.closeResource(conn, ps, result);
			return list;
		}
	}

}
