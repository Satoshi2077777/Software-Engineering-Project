package com.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.entity.Student;
import com.util.JDBCUtil;

public class StudentDao {

	public int insertStudent(Student student) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet result = null;
		int flag = 0;
		try {
			conn = JDBCUtil.getConnection();
			String sno = student.getSno();
			String sname = student.getSname();
			int sex = student.getSex();
			String sclass = student.getSclass();
			String department = student.getDepartment();
			String nationality = student.getNationality();
			String nativeplace = student.getNativeplace();
			String major = student.getMajor();
			Date sbirth = student.getSbirth();
			String telephone = student.getTelephone();

			String sql = new String("insert into student values(?,?,?,?,?,?,?,?,?,?)");
			ps = conn.prepareStatement(sql);
			ps.setString(1, sno);
			ps.setString(2, sname);
			ps.setInt(3, sex);
			ps.setString(4, sclass);
			ps.setString(5, department);
			ps.setString(6, nationality);
			ps.setString(7, nativeplace);
			ps.setString(8, telephone);
			ps.setString(9, major);
			ps.setDate(10, sbirth);

			flag = ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.closeResource(conn, ps, result);
			return flag;
		}
	}

	public int updateStudent(Student student) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet result = null;
		int flag = 0;
		try {
			conn = JDBCUtil.getConnection();
			String sno = student.getSno();
			String sname = student.getSname();
			int sex = student.getSex();
			String sclass = student.getSclass();
			String department = student.getDepartment();
			String nationality = student.getNationality();
			String nativeplace = student.getNativeplace();
			String major = student.getMajor();
			Date sbirth = student.getSbirth();
			String telephone = student.getTelephone();

			String sql = new String("update student set sname=?,sex=?,sclass=?,"
					+ "department=?,nationality=?,nativeplace=?,major=?,sbirth=?," + "telephone=? where sno=?");
			ps = conn.prepareStatement(sql);

			ps.setString(1, sname);
			ps.setInt(2, sex);
			ps.setString(3, sclass);
			ps.setString(4, department);
			ps.setString(5, nationality);
			ps.setString(6, nativeplace);
			ps.setString(7, major);
			ps.setDate(8, sbirth);
			ps.setString(9, telephone);
			ps.setString(10, sno);

			flag = ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.closeResource(conn, ps, result);
			return flag;
		}
	}

	public int delStudent(Student student) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet result = null;
		int flag = 0;
		try {
			conn = JDBCUtil.getConnection();
			String sno = student.getSno();
			String sql = "delete from student where sno=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, sno);
			System.out.print("delStudent(Student student)" + ps.toString());
			flag = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.closeResource(conn, ps, result);
			return flag;
		}
	}

	public Student selectStudent(Student student) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet result = null;
		Student user = null;
		try {
			conn = JDBCUtil.getConnection();
			String sno = student.getSno();
			String sql = "select *from student where sno=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, sno);
			result = ps.executeQuery();
			while (result.next()) {
				user = new Student();
				user.setSno(result.getString("sno"));
				user.setSname(result.getString("sname"));
				user.setSex(result.getInt("sex"));
				user.setSclass(result.getString("sclass"));
				user.setDepartment(result.getString("department"));
				user.setNationality(result.getString("nationality"));
				user.setNativeplace(result.getString("nativeplace"));
				user.setMajor(result.getString("major"));
				user.setSbirth(result.getDate("sbirth"));
				user.setTelephone(result.getString("telephone"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.closeResource(conn, ps, result);
			return user;
		}
	}

	public List<Student> selectStudentList(Student student) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet result = null;
		ArrayList<Student> list = new ArrayList<Student>();
		try {
			conn = JDBCUtil.getConnection();
			String sno = student.getSno();
			String sname = student.getSname();
			String sclass = student.getSclass();
			String department = student.getDepartment();
			String place = student.getNativeplace();
			StringBuffer sql = new StringBuffer("select *from student where 1=1");
			if (!("".equals(sno)) && sno != null) {
				sql.append(" and sno= '" + sno + "'");
			}
			if (!("".equals(sname)) && sname != null) {
				sql.append(" and sname= '" + sname + "'");
			}
			if (!("").equals(sclass) && sclass != null) {
				sql.append(" and sclass='" + sclass + "'");
			}
			if (!("").equals(department) && department != null) {
				sql.append(" and department='" + department + "'");
			}
			if (!("").equals(place) && place != null) {
				sql.append(" and nativeplace like '%" + place + "%'");
			}
			ps = conn.prepareStatement(String.valueOf(sql));
			result = ps.executeQuery();
			while (result.next()) {
				Student user = new Student();
				user.setSno(result.getString("sno"));
				user.setSname(result.getString("sname"));
				user.setSex(result.getInt("sex"));
				user.setSclass(result.getString("sclass"));
				user.setDepartment(result.getString("department"));
				user.setNationality(result.getString("nationality"));
				user.setNativeplace(result.getString("nativeplace"));
				user.setMajor(result.getString("major"));
				user.setSbirth(result.getDate("sbirth"));
				user.setTelephone(result.getString("telephone"));
				list.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.closeResource(conn, ps, result);
			return list;
		}
	}

}
