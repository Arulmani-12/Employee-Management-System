package com.employee.management;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;


import javax.swing.JButton;
import java.awt.Color;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Employee extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel dashboard;

	/**
	 * Launch the application.
	 */

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Employee frame = new Employee();
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
	public Employee() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 200, 645, 422);
		dashboard = new JPanel();
		dashboard.setBackground(new Color(192, 192, 192));
		dashboard.setForeground(Color.WHITE);
		dashboard.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(dashboard);
		dashboard.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Employee Management System");
		lblNewLabel.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblNewLabel.setBounds(191, 11, 267, 27);
		dashboard.add(lblNewLabel);
		
		JButton btnview = new JButton("View Employees");
		btnview.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ViewEmployees();
				setVisible(false);
			}
		});
		btnview.setBackground(new Color(0, 128, 128));
		btnview.setForeground(new Color(0, 0, 0));
		btnview.setFont(new Font("Trebuchet MS", Font.BOLD, 13));
		btnview.setBounds(57, 86, 175, 45);
		dashboard.add(btnview);
		
		JButton btnviewid = new JButton("View Employee By Id");
		btnviewid.setBackground(new Color(0, 128, 128));
		btnviewid.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				ViewEmployeeById id = new ViewEmployeeById();
				id.setVisible(true);
			}
		});
		btnviewid.setFont(new Font("Trebuchet MS", Font.BOLD, 13));
		btnviewid.setBounds(345, 86, 180, 45);
		dashboard.add(btnviewid);
		
		JButton btnadd = new JButton("Add Employee");
		btnadd.setBackground(new Color(0, 128, 128));
		btnadd.setForeground(Color.BLACK);
		btnadd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
  			setVisible(false);
				new AddEmployee();
				
			}
		});
		btnadd.setFont(new Font("Trebuchet MS", Font.BOLD, 13));
		btnadd.setBounds(57, 168, 175, 45);
		dashboard.add(btnadd);
		
		JButton btndelete = new JButton("Delete Employee");
		btndelete.setBackground(new Color(0, 128, 128));
		btndelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				RemoveEmployee rm = new RemoveEmployee();
				rm.setVisible(true);
				
			}
		});
		btndelete.setFont(new Font("Trebuchet MS", Font.BOLD, 13));
		btndelete.setBounds(345, 168, 180, 45);
		dashboard.add(btndelete);
		
		JButton btnupdate = new JButton("Update Employee");
		btnupdate.setBackground(new Color(0, 128, 128));
		btnupdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				UpdateEmployee ep = new UpdateEmployee();
				ep.setVisible(true);
			}
		});
		btnupdate.setFont(new Font("Trebuchet MS", Font.BOLD, 13));
		btnupdate.setBounds(209, 263, 180, 45);
		dashboard.add(btnupdate);
		
		JButton btnLogout = new JButton("Log_Out");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Login lo = new Login();
				lo.setVisible(true);
			}
		});
		btnLogout.setForeground(Color.BLACK);
		btnLogout.setFont(new Font("Trebuchet MS", Font.BOLD, 13));
		btnLogout.setBackground(new Color(0, 128, 128));
		btnLogout.setBounds(506, 15, 113, 27);
		dashboard.add(btnLogout);
//		setVisible(rootPaneCheckingEnabled);
	}
}
