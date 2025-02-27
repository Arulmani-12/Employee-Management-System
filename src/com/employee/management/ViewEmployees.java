package com.employee.management;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class ViewEmployees extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private Connection con = null;
	private Statement st =null;
	private ResultSet rs =null;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewEmployees frame = new ViewEmployees();
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
	public ViewEmployees() {
		try {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 706, 417);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		table = new JTable();
		table.setBounds(392, 21, 0, 0);
		contentPane.add(table);
		
		
		String sql = "select * from employee";
		try {
		 con	= ConnectionDB.getConnection();
			 st = con.createStatement();
			 rs = st.executeQuery(sql);
			table.setModel(DbUtils.resultSetToTableModel(rs));
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		
		JScrollPane jsp = new JScrollPane(table);
		jsp.setBounds(0, 43, 690, 113);
		getContentPane().add(jsp);
		
		JButton btnNewButton = new JButton("print");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					table.print();
				} catch (PrinterException e1) {
					
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(291, 253, 89, 29);
		contentPane.add(btnNewButton);
		
		JButton Back = new JButton("Back");
		Back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Employee em= new Employee();
				em.setVisible(true);
				setVisible(false);
			}
		});
		Back.setBounds(144, 259, 101, 23);
		contentPane.add(Back);
		setVisible(true);
		}catch (Exception e) {
			e.printStackTrace();
		}
			finally {
				if(con != null) {
					try {
						con.close();
						st.close();
						rs.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		
	}
}
