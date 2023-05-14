package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.entity.Room;
import com.util.JDBCUtil;

public class RoomDao {

	public int insertRoom(Room room) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet result = null;
		int flag = 0;
		try {
			conn = JDBCUtil.getConnection();
			String sql = "insert into room (RID, RNAME, PNAME, PSTATU, PTIME) values(?,?,?,?,?)";
			System.out.println("insertCourse(Course course)" + sql);
			ps = conn.prepareStatement(sql);
			ps.setInt(1, room.getRid());
			ps.setString(2, room.getRname());
			ps.setString(3, room.getPname());
			ps.setString(4, room.getPstatu());
			ps.setString(5, room.getPtime());
			flag = ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.closeResource(conn, ps, result);
			return flag;
		}
	}

	public int updateRoom(Room room) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet result = null;
		int flag = 0;
		try {
			conn = JDBCUtil.getConnection();
			String sql = "update room set PNAME=?,PTIME=?,RNAME=?," + "PSTATU=? where RID=?";
			ps = conn.prepareStatement(sql);

			ps.setString(1, room.getPname());
			ps.setString(2, room.getPtime());
			ps.setString(3, room.getRname());
			ps.setString(4, room.getPstatu());
			ps.setInt(5, room.getRid());
			flag = ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.closeResource(conn, ps, result);
			return flag;
		}
	}

	public int delRoom(Room room) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet result = null;
		int flag = 0;
		try {
			conn = JDBCUtil.getConnection();
			String sql = "delete from Room where RID=?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, room.getRid());
			flag = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.closeResource(conn, ps, result);
			return flag;
		}
	}

	public Room selectRoom(Room room) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet result = null;
		Room r = null;
		try {
			conn = JDBCUtil.getConnection();
			String sql = "select * from room where RID=?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, room.getRid());
			System.out.println(ps.toString());
			result = ps.executeQuery();
			while (result.next()) {
				r = new Room();
				r.setRid(result.getInt("RID"));
				r.setPname(result.getString("PNAME"));
				r.setRname(result.getString("RNAME"));
				r.setPtime(result.getString("PTIME"));
				r.setPstatu(result.getString("PSTATU"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.closeResource(conn, ps, result);
			return r;
		}
	}

	public List<Room> selectRoomList(Room room) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet result = null;
		ArrayList<Room> list = new ArrayList<Room>();
		try {
			conn = JDBCUtil.getConnection();
			int rid = room.getRid();
			String pname = room.getPname();
			String ptime = room.getPtime();
			String pstatu = room.getPstatu();
			String rname = room.getRname();
			StringBuffer sql = new StringBuffer("select *from room where 1=1");
			if (rid != 0) {
				sql.append(" and RID= '" + rid + "'");
			}
			if (!("".equals(pname)) && pname != null) {
				sql.append(" and PNAME= '" + pname + "'");
			}
			if (!("").equals(ptime) && ptime != null) {
				sql.append(" and PTIME like '" + ptime + "'");
			}
			if (!("").equals(pstatu) && pstatu != null) {
				sql.append(" and PSTATU like '" + pstatu + "'");
			}
			if (!("").equals(rname) && rname != null) {
				sql.append(" and RNAME like '" + rname + "'");
			}
			ps = conn.prepareStatement(String.valueOf(sql));
			result = ps.executeQuery();
			System.out.println(ps.toString());
			while (result.next()) {

				Room r = new Room();
				r.setRid(result.getInt("RID"));
				r.setPstatu(result.getString("PSTATU"));
				r.setPname(result.getString("PNAME"));
				r.setPtime(result.getString("PTIME"));
				r.setRname(result.getString("RNAME"));
				list.add(r);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.closeResource(conn, ps, result);
			return list;
		}
	}

	public String checkRoomList(Room room) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet result = null;
		String flag = null;
		ArrayList<Room> list = new ArrayList<Room>();
		try {
			conn = JDBCUtil.getConnection();
			int rid = room.getRid();
			String pname = room.getPname();
			String ptime = room.getPtime();
			String pstatu = room.getPstatu();
			String rname = room.getRname();
			StringBuffer sql = new StringBuffer("select *from room where 1=1");
			if (rid != 0) {
				sql.append(" and RID= '" + rid + "'");
			}
			if (!("".equals(pname)) && pname != null) {
				sql.append(" and PNAME= '" + pname + "'");
			}
			if (!("").equals(ptime) && ptime != null) {
				sql.append(" and PTIME like '" + ptime + "'");
			}
			if (!("").equals(pstatu) && pstatu != null) {
				sql.append(" and PSTATU like '" + pstatu + "'");
			}
			if (!("").equals(rname) && rname != null) {
				sql.append(" and RNAME like '" + rname + "'");
			}
			ps = conn.prepareStatement(String.valueOf(sql));
			result = ps.executeQuery();
			System.out.println(ps.toString());
			while (result.next()) {

				flag = "1";
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.closeResource(conn, ps, result);
			return flag;
		}
	}

	public boolean checkRoomName(String rn) throws SQLException {
		Connection conn = JDBCUtil.getConnection();
		String sql = new String("select *from roomname where roomname ='" + rn + "'");
		System.out.println(sql);
		PreparedStatement ps = null;
		ResultSet flag = null;
		ps = conn.prepareStatement(sql);
		flag = ps.executeQuery(sql);
		while (flag.next()) {
			conn.close();
			ps.close();
			flag.close();
			return true;
		}
		return false;

	}

	public static void main(String args[]) {
		// Room r=new Room(51, "rname", "pname","ptime", "pstatu");
		// RoomDao roo=new RoomDao();
		// roo.insertRoom(r);

		// Room r=new Room(11, "rwname", "pname","ptime", "pstatu");
		// RoomDao roo=new RoomDao();
		// roo.updateRoom(r);

		// Room r=new Room(11, "rwname", "pname","ptime", "pstatu");
		// RoomDao roo=new RoomDao();
		// roo.delRoom(r);

	}
}
