package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.entity.Course;
import com.entity.Plan;
import com.util.JDBCUtil;

public class PlanDao {

	public int insertPlan(Plan Plan) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet result = null;
		int flag = 0;
		Course c = null;
		try {
			conn = JDBCUtil.getConnection();
			String sql = "insert into plan (PLANID, TERM, YEAR, RL, CNO) values(?,?,?,?,?)";

			ps = conn.prepareStatement(sql);
			ps.setString(1, Plan.getPid());
			ps.setString(2, Plan.getTerm());
			ps.setString(3, Plan.getYear());
			ps.setString(4, Plan.getRL());
			ps.setString(5, Plan.getCno());
			flag = ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.closeResource(conn, ps, result);
			return flag;
		}
	}

	public int updatePlan(Plan Plan) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet result = null;
		int flag = 0;
		try {
			conn = JDBCUtil.getConnection();
			String sql = "update plan set YEAR=?,CNO=?,TERM=?," + "RL=? where PLANID=?";
			ps = conn.prepareStatement(sql);

			ps.setString(1, Plan.getYear());
			ps.setString(2, Plan.getCno());
			ps.setString(3, Plan.getTerm());
			ps.setString(4, Plan.getRL());
			ps.setString(5, Plan.getPid());
			flag = ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.closeResource(conn, ps, result);
			return flag;
		}
	}

	public int delPlan(Plan Plan) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet result = null;
		int flag = 0;
		try {
			conn = JDBCUtil.getConnection();
			String sql = "delete from Plan where PLANID=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, Plan.getPid());
			flag = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.closeResource(conn, ps, result);
			return flag;
		}
	}

	public Plan selectPlan(Plan Plan) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet result = null;
		Plan r = null;
		try {
			conn = JDBCUtil.getConnection();
			String sql = "select * from Plan where PLANID=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, Plan.getPid());
			System.out.println(ps.toString());
			result = ps.executeQuery();
			while (result.next()) {
				r = new Plan();
				r.setPid(result.getString("PLANID"));
				r.setYear(result.getString("YEAR"));
				r.setTerm(result.getString("TERM"));
				r.setCno(result.getString("CNO"));
				r.setRL(result.getString("RL"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.closeResource(conn, ps, result);
			return r;
		}
	}

	public List<Plan> selectPlanList(Plan Plan) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet result = null;
		ArrayList<Plan> list = new ArrayList<Plan>();
		try {

			conn = JDBCUtil.getConnection();
			String pid = Plan.getPid();
			System.out.println("5" + pid + "4");
			String year = Plan.getYear();
			String cno = Plan.getCno();
			String pstatu = Plan.getRL();
			String term = Plan.getTerm();
			System.out.println(Plan.getTerm() + "gtf");
			StringBuffer sql = new StringBuffer("select *from Plan where 1=1");
			if (!("".equals(pid)) && pid != null) {
				sql.append(" and PLANID= '" + pid + "'");
			}
			if (!("".equals(year)) && year != null) {
				sql.append(" and YEAR= '" + year + "'");
			}
			if (!("").equals(cno) && cno != null) {
				sql.append(" and CNO like '" + cno + "'");
			}
			if (!("").equals(pstatu) && pstatu != null) {
				sql.append(" and RL like '" + pstatu + "'");
			}
			if (!("").equals(term) && term != null) {
				sql.append(" and TERM like '" + term + "'");
			}
			ps = conn.prepareStatement(String.valueOf(sql));
			result = ps.executeQuery();
			System.out.println(ps.toString());
			while (result.next()) {

				Plan r = new Plan();
				r.setPid(result.getString("PLANID"));
				r.setRL(result.getString("RL"));
				r.setYear(result.getString("YEAR"));
				r.setCno(result.getString("CNO"));
				r.setTerm(result.getString("TERM"));
				list.add(r);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.closeResource(conn, ps, result);
			return list;
		}
	}

	public int checkPlanList(Plan Plan) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet result = null;
		ArrayList<Plan> list = new ArrayList<Plan>();
		try {

			conn = JDBCUtil.getConnection();
			String pid = Plan.getPid();
			String year = Plan.getYear();
			String cno = Plan.getCno();
			String pstatu = Plan.getRL();
			String term = Plan.getTerm();
			StringBuffer sql = new StringBuffer("select *from Plan where 1=1");
			if (!("".equals(pid)) && pid != null) {
				sql.append(" and PLANID= '" + pid + "'");
			}
			if (!("".equals(year)) && year != null) {
				sql.append(" and YEAR= '" + year + "'");
			}
			if (!("").equals(cno) && cno != null) {
				sql.append(" and CNO like '" + cno + "'");
			}
			if (!("").equals(pstatu) && pstatu != null) {
				sql.append(" and RL like '" + pstatu + "'");
			}
			if (!("").equals(term) && term != null) {
				sql.append(" and TERM like '" + term + "'");
			}
			ps = conn.prepareStatement(String.valueOf(sql));
			result = ps.executeQuery();
			System.out.println(ps.toString());
			while (result.next()) {

				return 1;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.closeResource(conn, ps, result);

		}
		return 0;
	}

	public boolean checkPlanName(String rn) throws SQLException {
		Connection conn = JDBCUtil.getConnection();
		String sql = new String("select *from Planname where Planname ='" + rn + "'");
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
		// Plan r=new Plan("53", "term", "year","cno", "pstatu");
		// PlanDao roo=new PlanDao();
		// roo.insertPlan(r);
		//
		// Plan r=new Plan("53", "rwname", "year","cno", "pstatu");
		// PlanDao roo=new PlanDao();
		// roo.updatePlan(r);
		//
		Plan r = new Plan("53", "rwname", "year", "cno", "pstatu");
		PlanDao roo = new PlanDao();
		roo.delPlan(r);

	}
}
