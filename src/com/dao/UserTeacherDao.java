package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.entity.UserTeacher;
import com.util.JDBCUtil;

public class UserTeacherDao {

	public int insertUserTeacher(UserTeacher userTeacher) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet result = null;
		int flag = 0;
		try {
			conn = JDBCUtil.getConnection();
			String tno = userTeacher.getTno();
			String utpsw = userTeacher.getUtpsw();
			String sql = "insert into user_teacher values(?,?)";
			ps = conn.prepareStatement(sql);
			ps.setString(1, tno);
			ps.setString(2, utpsw);
			flag = ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.closeResource(conn, ps, result);
			return flag;
		}
	}

	public int updateUserTeacher(UserTeacher userTeacher) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet result = null;
		int flag = 0;
		try {
			conn = JDBCUtil.getConnection();
			String tno = userTeacher.getTno();
			String utpsw = userTeacher.getUtpsw();
			String sql = "update user_teacher set utpsw=? where tno=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, utpsw);
			ps.setString(2, tno);
			flag = ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.closeResource(conn, ps, result);
			return flag;
		}
	}

	public int delUserTeacher(UserTeacher userTeacher) {
		// TODO Auto-generated method stub
		return 0;
	}

	public UserTeacher selectUserTeacher(UserTeacher userTeacher) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet result = null;
		UserTeacher user = null;
		try {
			conn = JDBCUtil.getConnection();
			String tno = userTeacher.getTno();
			String utpsw = userTeacher.getUtpsw();
			String sql = "select *from user_teacher where tno=? and utpsw=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, tno);
			ps.setString(2, utpsw);
			result = ps.executeQuery();
			while (result.next()) {
				user = new UserTeacher();
				user.setTno(result.getString(1));
				user.setUtpsw(result.getString(2));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.closeResource(conn, ps, result);
			return user;
		}
	}

	public List<UserTeacher> selectUserTeacherList(UserTeacher userTeacher) {
		// TODO Auto-generated method stub
		return null;
	}

}
