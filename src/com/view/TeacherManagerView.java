package com.view;

import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import com.dao.TeacherDao;
import com.entity.Teacher;
import com.util.CommboxData;
import com.util.MyFont;
import com.util.TabelSetting;
import com.util.TableColums;

public class TeacherManagerView extends JPanel implements MouseListener {
	public static void main(String args[])
	{
		
	}

	private JPanel contentPane;
	private JTextField jtf_name;
	JLabel jl_del;
	JLabel jl_add;
	JLabel jl_update;
	JTable jt_teacher;
	JLabel jl_refresh;
	DefaultTableModel dm;
	JComboBox jc_department;
	JComboBox jc_place;
	int flag = -1;

	/**
	 * Launch the application.
	 */
	public void fillTable(Teacher teacher) {
		dm = (DefaultTableModel) jt_teacher.getModel();
		dm.setRowCount(0);

		List<Teacher> list = new TeacherDao().selectTeacherList(teacher);
		for (Teacher t : list) {
			Vector<Object> v = new Vector<>();
			v.add(t.getTno());
			v.add(t.getTname());
			int i = t.getSex();
			String sex = null;
			if (i == 0)
				sex = "Å®";
			else
				sex = "ÄÐ";
			v.add(sex);
			v.add(t.getTbirth());
			v.add(t.getTelephone());
			v.add(t.getDepartment());
			v.add(t.getNationality());
			v.add(t.getNativeplace());
			dm.addRow(v);
		}

	}

	/**
	 * Create the frame.
	 */
	public TeacherManagerView() {
		;
		setBounds(100, 100, 960, 550);

		this.setLayout(new BorderLayout(0, 0));

		JPanel jp_tool = new JPanel();
		jp_tool.setFont(MyFont.getMyFont());
		jp_tool.setPreferredSize(new Dimension(950, 50));
		this.add(jp_tool, BorderLayout.NORTH);
		jp_tool.setLayout(null);

		jl_add = new JLabel("\u6DFB\u52A0");
		jl_add.setBounds(0, 10, 54, 30);
		jp_tool.add(jl_add);
		jl_add.setFont(MyFont.getMyFont());
		jl_add.setIcon(new ImageIcon("image/add.png"));
		jl_add.addMouseListener(this);

		jl_del = new JLabel("\u5220\u9664");
		jl_del.setBounds(73, 10, 54, 30);
		jp_tool.add(jl_del);
		jl_del.setFont(MyFont.getMyFont());
		jl_del.setIcon(new ImageIcon("image/delete.png"));
		jl_del.addMouseListener(this);

		jl_update = new JLabel("\u4FEE\u6539");
		jl_update.setBounds(145, 10, 54, 30);
		jp_tool.add(jl_update);
		jl_update.setFont(MyFont.getMyFont());
		jl_update.setIcon(new ImageIcon("image/update.png"));
		jl_update.addMouseListener(this);

		JButton jb_submit = new JButton("\u67E5\u8BE2");
		jb_submit.setFont(MyFont.getMyFont());

		jb_submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		jb_submit.setBounds(880, 10, 80, 30);
		jp_tool.add(jb_submit);

		jc_place = new JComboBox();
		jc_place.setBounds(745, 10, 100, 30);
		jp_tool.add(jc_place);
		jc_place.setFont(MyFont.getMyFont());
		jc_place.addItem("--ÇëÑ¡Ôñ--");
		String[] provinces = CommboxData.getProvinces();
		for (String data : provinces) {
			jc_place.addItem(data);
		}

		JLabel jl_place = new JLabel("\u7C4D\u8D2F:");
		jl_place.setBounds(690, 10, 46, 30);
		jp_tool.add(jl_place);
		jl_place.setFont(MyFont.getMyFont());

		jc_department = new JComboBox();
		jc_department.setBounds(565, 10, 100, 30);
		jp_tool.add(jc_department);
		jc_department.setFont(MyFont.getMyFont());
		jc_department.addItem("--ÇëÑ¡Ôñ--");
		String[] departments = CommboxData.getDepartments();
		for (String data : departments) {
			jc_department.addItem(data);
		}

		JLabel jl_department = new JLabel("\u9662\u7CFB:");
		jl_department.setBounds(520, 10, 46, 30);
		jp_tool.add(jl_department);
		jl_department.setFont(MyFont.getMyFont());

		jtf_name = new JTextField();
		jtf_name.setBounds(400, 10, 100, 30);
		jp_tool.add(jtf_name);
		jtf_name.setColumns(10);
		jtf_name.setFont(MyFont.getMyFont());

		JLabel jl_name = new JLabel("\u59D3\u540D:");
		jl_name.setBounds(350, 11, 46, 30);
		jp_tool.add(jl_name);
		jl_name.setFont(MyFont.getMyFont());

		jl_refresh = new JLabel("\u5237\u65B0");
		jl_refresh.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 14));
		jl_refresh.setBounds(209, 10, 54, 30);
		jl_refresh.setIcon(new ImageIcon("image/refresh.png"));
		jp_tool.add(jl_refresh);
		jl_refresh.addMouseListener(this);

		jt_teacher = new JTable(new DefaultTableModel(TableColums.getTeacherColums(), 0) {
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		});
		jt_teacher.setRowHeight(30);
		DefaultTableCellRenderer r = new DefaultTableCellRenderer();
		r.setHorizontalAlignment(JLabel.CENTER);
		jt_teacher.setDefaultRenderer(Object.class, r);
		TabelSetting.makeFace(jt_teacher);

		fillTable(new Teacher());
		JScrollPane js = new JScrollPane(jt_teacher);
		this.add(js, BorderLayout.CENTER);

		jb_submit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				String tname = jtf_name.getText().trim();
				String department = ((String) jc_department.getSelectedItem()).trim();
				String provinces = ((String) jc_place.getSelectedItem()).trim();

				Teacher teacher = new Teacher();
				teacher.setTname(tname);
				if (!("--ÇëÑ¡Ôñ--").equals(department))
					teacher.setDepartment(department);
				if (!("--ÇëÑ¡Ôñ--").equals(provinces))
					teacher.setNativeplace(provinces);
				fillTable(teacher);
			}

		});
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
			jl_add.setText("<html><font color='#336699' style='font-weight:bold'>" + "Ìí¼Ó" + "</font></html>");
		} else if (e.getSource() == jl_del) {
			jl_del.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			jl_del.setText("<html><font color='#336699' style='font-weight:bold'>" + "É¾³ý" + "</font></html>");
		} else if (e.getSource() == jl_update) {
			jl_update.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			jl_update.setText("<html><font color='#336699' style='font-weight:bold'>" + "ÐÞ¸Ä" + "</font></html>");
		} else if (e.getSource() == jl_refresh) {
			jl_refresh.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			jl_refresh.setText("<html><font color='#336699' style='font-weight:bold'>" + "Ë¢ÐÂ" + "</font></html>");
		}
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == jl_add) {
			jl_add.setText("Ìí¼Ó");
		} else if (e.getSource() == jl_del) {
			jl_del.setText("É¾³ý");
		} else if (e.getSource() == jl_update) {
			jl_update.setText("ÐÞ¸Ä");
		} else if (e.getSource() == jl_refresh) {
			jl_refresh.setIcon(new ImageIcon("image/refresh.png"));
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		int row = jt_teacher.getSelectedRow();
		if (e.getSource() == jl_add) {
			Teacher teacher = new Teacher();
			new TeacherDialogView(teacher, 0);
		} else if (e.getSource() == jl_del && row >= 0) {
			String tno = (String) jt_teacher.getValueAt(row, 0);
			Teacher te = new Teacher();
			te.setTno(tno);
			Teacher t = new TeacherDao().selectTeacher(te);
			new TeacherDialogView(t, 1);
		} else if (e.getSource() == jl_update && row >= 0) {
			String tno = (String) jt_teacher.getValueAt(row, 0);
			Teacher te = new Teacher();
			te.setTno(tno);
			Teacher t = new TeacherDao().selectTeacher(te);
			new TeacherDialogView(t, 2);
		} else if (e.getSource() == jl_refresh) {
			fillTable(new Teacher());
		}

	}
}
