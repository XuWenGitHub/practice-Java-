package view;

import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import com.cn.dao.StudentDao;
import com.cn.model.Student;
import com.cn.util.StringUtil;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UpdateStudent extends JInternalFrame {
	private JTextField findname;
	private JTable table;
	private JTextField name;
	private JTextField age;
	private JTextField address;
	private JTextField tel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdateStudent frame = new UpdateStudent();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public UpdateStudent() {
		setTitle("维护学生信息");
		setIconifiable(true);
		setClosable(true);
		setBounds(100, 100, 792, 492);
		
		JScrollPane scrollPane = new JScrollPane();
		
		JLabel label = new JLabel("学生姓名：");
		
		findname = new JTextField();
		findname.setColumns(10);
		
		JButton button = new JButton("搜索");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				findStudent();
			}
		});
		button.setIcon(new ImageIcon(UpdateStudent.class.getResource("/images/搜索.png")));
		
		JLabel label_1 = new JLabel("姓名：");
		
		name = new JTextField();
		name.setEditable(false);
		name.setColumns(10);
		
		JLabel label_2 = new JLabel("年龄：");
		
		age = new JTextField();
		age.setColumns(10);
		
		JLabel label_3 = new JLabel("地址：");
		
		address = new JTextField();
		address.setColumns(10);
		
		JLabel label_4 = new JLabel("课程：");
		
		tel = new JTextField();
		tel.setColumns(10);
		
		JButton button_1 = new JButton("修改");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateStudent();
			}
		});
		button_1.setIcon(new ImageIcon(UpdateStudent.class.getResource("/images/submit.png")));
		
		JButton button_2 = new JButton("删除");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				delStudent();
			}
		});
		button_2.setIcon(new ImageIcon(UpdateStudent.class.getResource("/images/删除(1).png")));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(109)
							.addComponent(label)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(findname, GroupLayout.PREFERRED_SIZE, 158, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(button))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(101)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(label_1)
									.addGap(7)
									.addComponent(name, GroupLayout.PREFERRED_SIZE, 145, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(label_2)
									.addGap(8)
									.addComponent(age, GroupLayout.PREFERRED_SIZE, 146, GroupLayout.PREFERRED_SIZE))
								.addComponent(button_1))
							.addGap(85)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(button_2)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
									.addGroup(groupLayout.createSequentialGroup()
										.addComponent(label_4)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(tel))
									.addGroup(groupLayout.createSequentialGroup()
										.addComponent(label_3)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(address, GroupLayout.PREFERRED_SIZE, 169, GroupLayout.PREFERRED_SIZE)))))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(71)
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 633, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(72, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(47)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(label)
								.addComponent(findname, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(button))
							.addGap(122)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addGroup(groupLayout.createSequentialGroup()
											.addGap(45)
											.addComponent(label_1))
										.addGroup(groupLayout.createSequentialGroup()
											.addGap(43)
											.addComponent(name, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addGroup(groupLayout.createSequentialGroup()
											.addGap(36)
											.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
												.addComponent(age, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addComponent(label_4)
												.addComponent(tel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
										.addGroup(groupLayout.createSequentialGroup()
											.addGap(39)
											.addComponent(label_2))))
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(44)
									.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
										.addComponent(label_3)
										.addComponent(address, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
							.addGap(62)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(button_1)
								.addComponent(button_2)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(90)
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(60, Short.MAX_VALUE))
		);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				pickRow();
			}
		});
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
			},
			new String[] {
				"\u59D3\u540D", "\u5E74\u9F84", "\u5730\u5740", "\u8bfe\u7a0b"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(table);
		getContentPane().setLayout(groupLayout);
		
		filltable("");
	}

	private void updateStudent() {
		// TODO Auto-generated method stub
		String name = this.name.getText();
		String age = this.age.getText();
		String address = this.address.getText();
		String tel = this.tel.getText();
		
		if (StringUtil.isNull(name)) {
			JOptionPane.showMessageDialog(null, "姓名不能为空!");
			return;
		}
		if (StringUtil.isNull(age)) {
			JOptionPane.showMessageDialog(null, "年龄不能为空!");
			return;
		}
		if (StringUtil.isNull(address)) {
			JOptionPane.showMessageDialog(null, "地址不能为空!");
			return;
		}
		if (StringUtil.isNull(tel)) {
			JOptionPane.showMessageDialog(null, "课程不能为空!");
			return;
		}
		
		Student student = new Student(0, name, age, address, tel);
		StudentDao studentDao = new StudentDao();
		studentDao.delStudent(name);
		int num = studentDao.writeStudent(student);
		if (num != 0) {
			JOptionPane.showMessageDialog(null, "修改成功！");
			filltable("");
		}else {
			JOptionPane.showMessageDialog(null, "修改失败！");
		}
	}

	private void findStudent() {
		// TODO Auto-generated method stub
		String name = this.findname.getText();
		filltable(name);
	}

	private void delStudent() {
		// TODO Auto-generated method stub
		int result = JOptionPane.showConfirmDialog(null, "是否删除该学生？");
		if (result == 0) {
			String name = this.name.getText();
			StudentDao studentDao = new StudentDao();
			int num = studentDao.delStudent(name);
			if (num != 0) {
				JOptionPane.showMessageDialog(null, "删除成功！");
				filltable("");
				cleanPickRow();
			}else {
				JOptionPane.showMessageDialog(null, "删除失败！");
			}
		}
	}

	private void cleanPickRow() {
		// TODO Auto-generated method stub
		this.name.setText("");
		this.age.setText("");
		this.address.setText("");
		this.tel.setText("");
	}

	private void pickRow() {
		// TODO Auto-generated method stub
		int row = table.getSelectedRow();
		this.name.setText((String) table.getValueAt(row, 0));
		this.age.setText((String) table.getValueAt(row, 1));
		this.address.setText((String) table.getValueAt(row, 2));
		this.tel.setText((String) table.getValueAt(row, 3));
	}

	private void filltable(String name) {
		// TODO Auto-generated method stub
		DefaultTableModel dtm = (DefaultTableModel) table.getModel();
		dtm.setRowCount(0);
		
		StudentDao studentDao = new StudentDao();
		ArrayList<Student> list = studentDao.findStudent(name);
		for (int i = 0; i < list.size(); i++) {
			Vector<Object> v = new Vector<>();
			v.add(list.get(i).getName());
			v.add(list.get(i).getAge());
			v.add(list.get(i).getAddress());
			v.add(list.get(i).getTel());

			dtm.addRow(v);
		}
	}
}
