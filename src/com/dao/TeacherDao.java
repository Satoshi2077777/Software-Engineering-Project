package com.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.entity.Teacher;
import com.util.JDBCUtil;

public class TeacherDao {

	public int insertTeacher(Teacher teacher) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet result = null;
		int flag = 0;
		try {
			conn = JDBCUtil.getConnection();
			String tno = teacher.getTno();
			String tname = teacher.getTname();
			int sex = teacher.getSex();
			String department = teacher.getDepartment();
			String nationality = teacher.getNationality();
			String nativeplace = teacher.getNativeplace();
			Date tbirth = teacher.getTbirth();
			String telephone = teacher.getTelephone();

			String sql = new String("insert into teacher values(?,?,?,?,?,?,?,?)");
			ps = conn.prepareStatement(sql);
			ps.setString(1, tno);
			ps.setString(2, tname);
			ps.setInt(3, sex);
			ps.setString(4, department);
			ps.setString(5, nationality);
			ps.setString(6, nativeplace);
			ps.setString(7, telephone);
			ps.setDate(8, tbirth);

			flag = ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.closeResource(conn, ps, result);
			return flag;
		}
	}

	public int updateTeacher(Teacher teacher) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet result = null;
		int flag = 0;
		try {
			conn = JDBCUtil.getConnection();
			String tno = teacher.getTno();
			String sql = "update teacher set tname=?,sex=?,department=?,"
					+ "nationality=?,nativeplace=?,telephone=?,tbirth=? where tno=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, teacher.getTname());
			ps.setInt(2, teacher.getSex());
			ps.setString(3, teacher.getDepartment());
			ps.setString(4, teacher.getNationality());
			ps.setString(5, teacher.getNativeplace());
			ps.setString(6, teacher.getTelephone());
			ps.setDate(7, teacher.getTbirth());
			ps.setString(8, tno);
			flag = ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.closeResource(conn, ps, result);
			return flag;
		}
	}

	public int delTeacher(Teacher teacher) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet result = null;
		int flag = 0;
		try {
			conn = JDBCUtil.getConnection();
			String tno = teacher.getTno();
			String sql = "delete from teacher where tno=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, tno);
			flag = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.closeResource(conn, ps, result);
			return flag;
		}

	}

	public Teacher selectTeacher(Teacher teacher) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet result = null;
		Teacher user = null;
		try {
			conn = JDBCUtil.getConnection();
			String tno = teacher.getTno();
			String sql = "select *from teacher where tno=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, tno);
			result = ps.executeQuery();
			while (result.next()) {
				user = new Teacher();
				user.setTno(result.getString("tno"));
				user.setTname(result.getString("tname"));
				user.setSex(result.getInt("sex"));
				user.setDepartment(result.getString("department"));
				user.setNationality(result.getString("nationality"));
				user.setNativeplace(result.getString("nativeplace"));
				user.setTelephone(result.getString("telephone"));
				user.setTbirth(result.getDate("tbirth"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.closeResource(conn, ps, result);
			return user;
		}
	}

	public List<Teacher> selectTeacherList(Teacher teacher) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet result = null;
		ArrayList<Teacher> list = new ArrayList<Teacher>();
		try {
			conn = JDBCUtil.getConnection();
			String tno = teacher.getTno();
			String tname = teacher.getTname();
			String department = teacher.getDepartment();
			String place = teacher.getNativeplace();

			StringBuffer sql = new StringBuffer("select *from teacher where 1=1");
			if (!("".equals(tno)) && tno != null) {
				sql.append(" and tno= '" + tno + "'");
			}
			if (!("".equals(tname)) && tname != null) {
				sql.append(" and tname= '" + tname + "'");
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
				Teacher user = new Teacher();
				user.setTno(result.getString("tno"));
				user.setTname(result.getString("tname"));
				user.setSex(result.getInt("sex"));
				user.setDepartment(result.getString("department"));
				user.setNationality(result.getString("nationality"));
				user.setNativeplace(result.getString("nativeplace"));
				user.setTbirth(result.getDate("tbirth"));
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
