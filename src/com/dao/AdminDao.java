package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.entity.Admin;
import com.util.JDBCUtil;

public class AdminDao {

	public Admin selectAdmin(Admin admin) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet result = null;
		Admin admin1 = null;
		try {
			conn = JDBCUtil.getConnection();
			int aid = admin.getAid();
			String aname = admin.getAname();
			String apsw = admin.getApsw();
			String sql = "select *from admin where aname=? and apsw=?";
			ps = conn.prepareStatement(sql);
			System.out.println("selectAdmin(Admin admin)" + sql);
			ps.setString(1, aname);
			ps.setString(2, apsw);
			result = ps.executeQuery();
			while (result.next()) {
				admin1 = new Admin();
				admin1.setAid(result.getInt(1));
				admin1.setAname(result.getString(2));
				admin1.setApsw(result.getString(3));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.closeResource(conn, ps, result);
			return admin1;
		}
	}

	public List<Admin> selectAdminList(Admin admin) {
		return null;
	}

}
