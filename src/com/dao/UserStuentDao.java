package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.entity.UserStudent;
import com.util.JDBCUtil;

public class UserStuentDao {

	public int insertUserStudent(UserStudent userStudent) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet result = null;
		int flag = 0;
		try {
			conn = JDBCUtil.getConnection();
			String sno = userStudent.getSno();
			String uspsw = userStudent.getUspsw();
			String sql = "insert into user_student values(?,?)";
			ps = conn.prepareStatement(sql);
			ps.setString(1, sno);
			ps.setString(2, uspsw);
			flag = ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.closeResource(conn, ps, result);
			return flag;
		}
	}

	public int updateUserStudent(UserStudent userStudent) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet result = null;
		int flag = 0;
		try {
			conn = JDBCUtil.getConnection();
			String sno = userStudent.getSno();
			String uspsw = userStudent.getUspsw();
			String sql = "update user_student set uspsw=? where sno=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, uspsw);
			ps.setString(2, sno);
			flag = ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.closeResource(conn, ps, result);
			return flag;
		}
	}

	public int delUserStudent(UserStudent userStudent) {
		// TODO Auto-generated method stub
		return 0;
	}

	public UserStudent selectUserStudent(UserStudent userStudent) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet result = null;
		UserStudent user = null;
		try {
			conn = JDBCUtil.getConnection();
			String sno = userStudent.getSno();
			String uspsw = userStudent.getUspsw();
			String sql = "select *from user_student where sno=? and uspsw=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, sno);
			ps.setString(2, uspsw);
			result = ps.executeQuery();
			while (result.next()) {
				user = new UserStudent();
				user.setSno(result.getString(1));
				user.setUspsw(result.getString(2));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.closeResource(conn, ps, result);
			return user;
		}
	}

	public List<UserStudent> selectUserStudentList(UserStudent userStudnet) {
		// TODO Auto-generated method stub
		return null;
	}

}
