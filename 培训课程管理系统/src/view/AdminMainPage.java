package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.TabableView;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JDesktopPane;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AdminMainPage extends JFrame {

	private JPanel contentPane;
	private JDesktopPane table;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminMainPage frame = new AdminMainPage();
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
	public AdminMainPage() {
		setTitle("管理员主页");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 931, 705);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu menu = new JMenu("新增学生信息");
		menu.setIcon(new ImageIcon(AdminMainPage.class.getResource("/images/register.png")));
		menuBar.add(menu);
		
		JMenuItem menuItem_1 = new JMenuItem("新增");
		menuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddStudent addStudent = new AddStudent();
				addStudent.setVisible(true);
				table.add(addStudent);
			}
		});
		menu.add(menuItem_1);
		
		JMenu menu_1 = new JMenu("维护学生信息");
		menu_1.setIcon(new ImageIcon(AdminMainPage.class.getResource("/images/用户.png")));
		menuBar.add(menu_1);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("维护");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UpdateStudent updateStudent = new UpdateStudent();
				updateStudent.setVisible(true);
				table.add(updateStudent);
			}
		});
		menu_1.add(mntmNewMenuItem);
		
		JMenu menu_2 = new JMenu("安全退出");
		menu_2.setIcon(new ImageIcon(AdminMainPage.class.getResource("/images/login.png")));
		menuBar.add(menu_2);
		
		JMenuItem menuItem = new JMenuItem("退出");
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				exit();
			}
		});
		menu_2.add(menuItem);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		table = new JDesktopPane();
		table.setBackground(new Color(0, 128, 128));
		contentPane.add(table, BorderLayout.CENTER);
		
		// 窗口居中
		this.setLocationRelativeTo(null);
	}

	private void exit() {
		// TODO Auto-generated method stub
		dispose();
	}

}
