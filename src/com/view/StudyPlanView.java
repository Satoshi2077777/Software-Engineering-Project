package com.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.List;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import com.dao.CourseDao;
import com.dao.DepartDao;
import com.dao.PlanDao;
import com.entity.Course;
import com.entity.Depart;
import com.entity.Plan;
import com.util.CommboxData;
import com.util.TabelSetting;
import com.util.TableColums;

public class StudyPlanView extends JPanel implements ActionListener {
	JComboBox jcb_term = null;
	JComboBox jcb_coll = null;
	JComboBox jcb_major = null;
	JComboBox jcb_year = null;
	JPanel jp_tool = null;
	DefaultTableModel dm;
	private JTable jt_plan;

	public void fillTable(Plan plan) {
		dm = (DefaultTableModel) jt_plan.getModel();
		dm.setRowCount(0);
		Course c = null;

		List<Plan> list = new PlanDao().selectPlanList(plan);
		for (Plan rm : list) {
			c = new Course();
			c.setCno(rm.getCno());
			c = new CourseDao().selectCourse(c);
			Vector<Object> v = new Vector<>();
			v.add(rm.getPid());
			v.add(rm.getYear());
			v.add(rm.getTerm());
			v.add(c.getCname());
			v.add(c.getCmark());
			v.add(c.getCkind());
			v.add(rm.getRL());

			dm.addRow(v);
		}
	}

	public static void main(String args[]) {
		JFrame jf = new JFrame();
		StudyPlanView a = new StudyPlanView();
		jf.getContentPane().add(a);
		jf.setSize(1000, 600);
		jf.setVisible(true);

	}

	public StudyPlanView() {

		setLayout(new BorderLayout(0, 0));

		jp_tool = new JPanel();
		add(jp_tool, BorderLayout.NORTH);
		jp_tool.setPreferredSize(new Dimension(960, 50));
		// jp_tool.setLayout(null);

		JLabel jlb_coll = new JLabel("\u5B66\u9662");
		jp_tool.add(jlb_coll);

		jcb_coll = new JComboBox();
		jp_tool.add(jcb_coll);
		String[] kinds = CommboxData.getDepartments();
		jcb_coll.addItem("---------«Î—°‘Ò---------");
		for (String data : kinds) {
			jcb_coll.addItem(data);
		}

		JLabel jlb_year = new JLabel("\u5B66\u5E74");
		jp_tool.add(jlb_year);

		jcb_year = new JComboBox();
		jp_tool.add(jcb_year);
		String[] yearkinds = CommboxData.getPlanYear();
		jcb_year.addItem("---------«Î—°‘Ò---------");
		for (String data : yearkinds) {
			jcb_year.addItem(data);
		}

		JLabel jlb_term = new JLabel("\u5B66\u671F");
		jp_tool.add(jlb_term);

		jcb_term = new JComboBox();
		jp_tool.add(jcb_term);

		jcb_term.addItem("---------«Î—°‘Ò---------");
		String[] termkinds = CommboxData.getPlanTerm();
		for (String data : termkinds) {
			jcb_term.addItem(data);
		}

		JLabel jlb_major = new JLabel("\u4E13\u4E1A");
		jp_tool.add(jlb_major);

		jcb_major = new JComboBox();
		jp_tool.add(jcb_major);
		jcb_major.addItem("---------«Î—°‘Ò---------");

		jcb_coll.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void focusLost(FocusEvent arg0) {
				String gets = (String) jcb_coll.getSelectedItem();

				String majoritem = (String) jcb_coll.getSelectedItem();
				jcb_major.removeAllItems();
				jcb_major.addItem("---------«Î—°‘Ò---------");
				List<Depart> list = new DepartDao().selectDepartListByDname2(majoritem);
				for (Depart data : list) {
					jcb_major.addItem(data.getDname());
				}
			}

		});

		JButton btn_submit = new JButton("\u67E5\u8BE2");
		jp_tool.add(btn_submit);
		btn_submit.addActionListener(this);

		jt_plan = new JTable();
		jp_tool.add(jt_plan);

		// jt_plan=new JTable(new DefaultTableModel(TableColums.getPlanColums(),0){
		// public boolean isCellEditable(int row, int column) {
		// return false;
		// }
		// });
		jt_plan = new JTable(new DefaultTableModel(TableColums.getPlanColums(), 0));
		jt_plan.setRowHeight(30);
		DefaultTableCellRenderer r = new DefaultTableCellRenderer();
		r.setHorizontalAlignment(JLabel.CENTER);
		jt_plan.setDefaultRenderer(Object.class, r);
		TabelSetting.makeFace(jt_plan);

		fillTable(new Plan());
		JScrollPane js = new JScrollPane(jt_plan);
		js.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		this.add(js);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Plan p = new Plan();
		if (!((String) jcb_major.getSelectedItem()).equals("---------«Î—°‘Ò---------"))
			p.setPid((String) jcb_major.getSelectedItem());
		if (!((String) jcb_term.getSelectedItem()).equals("---------«Î—°‘Ò---------"))
			p.setTerm((String) jcb_term.getSelectedItem());
		if (!((String) jcb_year.getSelectedItem()).equals("---------«Î—°‘Ò---------"))
			p.setYear((String) jcb_year.getSelectedItem());
		fillTable(p);
	}

}
