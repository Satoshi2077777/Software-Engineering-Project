package com.view;

import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import com.dao.ThingDao;
import com.entity.Admin;
import com.entity.Student;
import com.entity.Teacher;
import com.entity.Thing;
import com.util.CommboxData;
import com.util.MyFont;
import com.util.TabelSetting;
import com.util.TableColums;

public class ThingView extends JPanel implements MouseListener {
	JTable jt_Thing;
	// JComboBox jc_kind;
	JLabel jl_add;
	JLabel jl_del;
	JLabel jl_update;
	DefaultTableModel dm;
	private JLabel jl_refresh;
	private Admin a1;
	private Student s1;
	private Teacher t1;

	public void fillTable(Thing Thing) {
		System.out.println("now is ThingView.fillTable");
		dm = (DefaultTableModel) jt_Thing.getModel();
		dm.setRowCount(0);

		List<Thing> list = new ThingDao().selectThingList(new Thing());
		for (Thing th : list) {
			Vector<Object> v = new Vector<>();
			v.add(th.getThingno());
			v.add(th.getThingtext());
			v.add(th.getThingtime());
			dm.addRow(v);
		}
	}

	public JPanel getThingView() {
		return new ThingView();
	}

	public ThingView() {
		System.out.println("now is ThingView");

		setLayout(new BorderLayout(0, 0));
		JPanel jp_tool = new JPanel();
		add(jp_tool, BorderLayout.NORTH);
		jp_tool.setPreferredSize(new Dimension(960, 50));
		jp_tool.setLayout(null);

		jl_add = new JLabel("\u6DFB\u52A0");
		jl_add.setBounds(10, 10, 60, 30);
		jp_tool.add(jl_add);
		jl_add.setIcon(new ImageIcon("image/add.png"));
		jl_add.addMouseListener(this);

		jl_del = new JLabel("\u5220\u9664");
		jl_del.setBounds(80, 10, 60, 30);
		jp_tool.add(jl_del);
		jl_del.setFont(MyFont.getMyFont());
		jl_del.setIcon(new ImageIcon("image/delete.png"));
		jl_del.addMouseListener(this);

		jl_update = new JLabel("\u4FEE\u6539");
		jl_update.setBounds(150, 10, 60, 30);
		jp_tool.add(jl_update);
		jl_update.setFont(MyFont.getMyFont());
		jl_update.setIcon(new ImageIcon("image/update.png"));
		jl_update.addMouseListener(this);

		jl_refresh = new JLabel("\u5237\u65B0");
		jl_refresh.setBounds(217, 11, 60, 30);
		jl_refresh.setFont(MyFont.getMyFont());
		jl_refresh.setIcon(new ImageIcon("image/refresh.png"));
		jl_refresh.addMouseListener(this);
		jp_tool.add(jl_refresh);
		String[] subjects = CommboxData.getSubjects();

		jt_Thing = new JTable(new DefaultTableModel(TableColums.getAdminThingColums(), 0) {
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		});
		jt_Thing.setRowHeight(30);
		DefaultTableCellRenderer r = new DefaultTableCellRenderer();
		r.setHorizontalAlignment(JLabel.CENTER);
		jt_Thing.setDefaultRenderer(Object.class, r);
		TabelSetting.makeFace(jt_Thing);

		fillTable(new Thing());
		JScrollPane js = new JScrollPane(jt_Thing);
		this.add(js, BorderLayout.CENTER);

	}

	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		int row = jt_Thing.getSelectedRow();
		if (e.getSource() == jl_add) {
			Thing r = new Thing();
			new ThingDialogView(r, 0).setVisible(true);
		} else if (e.getSource() == jl_del && row >= 0) {

			Thing r = new Thing();
			r.setThingno(jt_Thing.getValueAt(row, 0).toString());
			Thing s = new ThingDao().selectThing(r);
			new ThingDialogView(r, 1).setVisible(true);
		} else if (e.getSource() == jl_update && row >= 0) {
			Thing r = new Thing();
			r.setThingno(jt_Thing.getValueAt(row, 0).toString());
			Thing s = new ThingDao().selectThing(r);
			System.out.print("修改");
			new ThingDialogView(r, 2).setVisible(true);
		} else if (e.getSource() == jl_refresh) {
			fillTable(new Thing());
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == jl_add) {
			jl_add.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			jl_add.setText("<html><font color='#336699' style='font-weight:bold'>" + "发布通知" + "</font></html>");
		} else if (e.getSource() == jl_del) {
			jl_del.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			jl_del.setText("<html><font color='#336699' style='font-weight:bold'>" + "删除通知" + "</font></html>");
		} else if (e.getSource() == jl_update) {
			jl_update.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			jl_update.setText("<html><font color='#336699' style='font-weight:bold'>" + "修改通知" + "</font></html>");
		} else if (e.getSource() == jl_refresh) {
			jl_refresh.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			jl_refresh.setText("<html><font color='#336699' style='font-weight:bold'>" + "刷新通知" + "</font></html>");
		}
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == jl_add) {
			jl_add.setText("发布");
		} else if (e.getSource() == jl_del) {
			jl_del.setText("删除");
		} else if (e.getSource() == jl_update) {
			jl_update.setText("修改");
		} else if (e.getSource() == jl_refresh) {
			jl_refresh.setText("刷新");
		}
	}

	public static void main(String args[])

	{
		JFrame jf = new JFrame();
		Student s = new Student();
		s.setSno("2012214324325");
		ThingView cmv = new ThingView();
		jf.add(cmv);
		jf.setSize(700, 700);
		jf.setVisible(true);

	}
}
