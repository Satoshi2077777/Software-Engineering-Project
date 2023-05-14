package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.entity.Thing;
import com.util.JDBCUtil;

public class ThingDao {
	public int insertThing(Thing th) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet result = null;
		int flag = 0;
		try {
			conn = JDBCUtil.getConnection();
			String thno = th.getThingno();
			String thtime = th.getThingtime();
			String thtext = th.getThingtext();
			String sql = "insert into thing (thingtext,addtime,thingno) values(?,?,?)";

			ps = conn.prepareStatement(sql);
			ps.setString(1, thtext);
			ps.setString(2, thtime);
			ps.setString(3, thno);
			System.out.println(ps.toString());
			flag = ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.closeResource(conn, ps, result);
			return flag;
		}
	}

	public int updateThing(Thing th) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet result = null;
		int flag = 0;
		try {
			conn = JDBCUtil.getConnection();
			String thno = th.getThingno();
			String thtime = th.getThingtime();
			String thtext = th.getThingtext();

			String sql = "update thing set thingtext=?,addtime=?,thingno=? where thingno=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, thtext);
			ps.setString(2, thtime);
			ps.setString(3, thno);
			ps.setString(4, thno);
			flag = ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.closeResource(conn, ps, result);
			return flag;
		}
	}

	public int delThing(Thing th) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet result = null;
		int flag = 0;
		try {
			conn = JDBCUtil.getConnection();
			String tno = th.getThingno();
			String sql = "delete from thing where thingno=?";

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

	public Thing selectThing(Thing th) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet result = null;
		Thing th1 = null;
		try {
			conn = JDBCUtil.getConnection();
			String sql = "select * from thing where thingno=?";

			ps = conn.prepareStatement(sql);
			String tno = th.getThingno();
			ps.setString(1, tno);
			result = ps.executeQuery();
			while (result.next()) {
				th1 = new Thing();
				th1.setThingno(result.getString("thingno"));
				th1.setThingtext(result.getString("thingtext"));
				th1.setThingtime(result.getString("addtime"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.closeResource(conn, ps, result);
			return th1;
		}
	}

	public List<Thing> selectThingList(Thing th) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet result = null;
		ArrayList<Thing> list = new ArrayList<Thing>();
		Thing th1 = null;
		try {
			conn = JDBCUtil.getConnection();
			String thno = th.getThingno();
			String thtime = th.getThingtime();
			String thtext = th.getThingtext();

			StringBuffer sql = new StringBuffer("select *from thing where 1=1");

			if (!("".equals(thno)) & thno != null) {
				sql.append(" and thingno= '" + thno + "'");
			}
			if (!("".equals(thtime)) && thtime != null) {
				sql.append(" and addtime= '" + thtime + "'");
			}
			if (!("").equals(thtext) && thtext != null) {
				sql.append(" and thingtext like '" + thtext + "'");
			}
			ps = conn.prepareStatement(String.valueOf(sql));
			result = ps.executeQuery();
			while (result.next()) {
				th1 = new Thing();
				th1 = new Thing();
				th1.setThingno(result.getString("thingno"));
				th1.setThingtext(result.getString("thingtext"));
				th1.setThingtime(result.getString("addtime"));
				list.add(th1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.closeResource(conn, ps, result);
			return list;
		}
	}

}
