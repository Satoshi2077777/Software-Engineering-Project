package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.entity.Depart;
import com.util.JDBCUtil;

public class DepartDao {

	public int insertDepart(Depart depart) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int delDepart(Depart depart) {
		// TODO Auto-generated method stub
		return 0;
	}

	public Depart selectDepart(Depart depart) {
		// TODO Auto-generated method stub
		return null;
	}

	public int updateDepart(Depart depart) {
		// TODO Auto-generated method stub
		return 0;
	}

	public List<Depart> selectDepartListByDname(String name) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet result = null;
		ArrayList<Depart> list = new ArrayList<Depart>();
		try {
			conn = JDBCUtil.getConnection();

			String sql = new String("select distinct dname from departs");
			ps = conn.prepareStatement(sql);
			result = ps.executeQuery();

			while (result.next()) {
				Depart d = new Depart();
				d.setDname(result.getString(1));
				list.add(d);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.closeResource(conn, ps, result);
			return list;
		}
	}

	public List<Depart> selectDepartListByDname2(String name) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet result = null;
		ArrayList<Depart> list = new ArrayList<Depart>();
		try {
			conn = JDBCUtil.getConnection();

			String sql = new String("select  major from departs where dname=? group by major");
			ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			result = ps.executeQuery();

			while (result.next()) {
				Depart d = new Depart();
				d.setDname(result.getString(1));
				list.add(d);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.closeResource(conn, ps, result);
			return list;
		}
	}

	public List<Depart> selectDepartlistByMajor(String major) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet result = null;
		ArrayList<Depart> list = new ArrayList<Depart>();
		try {
			conn = JDBCUtil.getConnection();

			String sql = new String("select  dclass from departs where major=? group by dclass");
			ps = conn.prepareStatement(sql);
			ps.setString(1, major);
			result = ps.executeQuery();

			while (result.next()) {
				Depart d = new Depart();
				d.setMajor(result.getString(1));
				list.add(d);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.closeResource(conn, ps, result);
			return list;
		}
	}

}
