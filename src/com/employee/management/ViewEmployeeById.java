package com.employee.management;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.Color;

import java.awt.Choice;




public class ViewEmployeeById extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtid;
	private JTextField txtname;
	private JTextField txtphone;
	private JTextField txtsalary;
	private JTextField txtemail;
	private JTextField txtaddress;
	
	private Connection con = null;
	private Statement st = null;
	private ResultSet rs = null;

	
	private Choice choice;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewEmployeeById frame = new ViewEmployeeById();
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
	public ViewEmployeeById() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 746, 503);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Employee Details");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(233, 11, 238, 34);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Employee_id:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1.setBounds(91, 69, 145, 34);
		contentPane.add(lblNewLabel_1);
		
		JLabel label2 = new JLabel("");
		label2.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		label2.setBounds(203, 305, 152, 23);
		contentPane.add(label2);
		
		JLabel label5 = new JLabel("");
		label5.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		label5.setBounds(203, 393, 152, 23);
		contentPane.add(label5);
		
		JLabel lblNewLabel_2 = new JLabel("Id");
		lblNewLabel_2.setFont(new Font("Tw Cen MT", Font.BOLD, 15));
		lblNewLabel_2.setBounds(91, 173, 127, 34);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("Name");
		lblNewLabel_2_1.setFont(new Font("Tw Cen MT", Font.BOLD, 15));
		lblNewLabel_2_1.setBounds(91, 218, 127, 34);
		contentPane.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("Salary");
		lblNewLabel_2_1_1.setFont(new Font("Tw Cen MT", Font.BOLD, 15));
		lblNewLabel_2_1_1.setBounds(91, 328, 127, 34);
		contentPane.add(lblNewLabel_2_1_1);
		
		JLabel lblNewLabel_2_1_1_1 = new JLabel("Phone");
		lblNewLabel_2_1_1_1.setFont(new Font("Tw Cen MT", Font.BOLD, 15));
		lblNewLabel_2_1_1_1.setBounds(91, 283, 127, 34);
		contentPane.add(lblNewLabel_2_1_1_1);
		
		JLabel lblNewLabel_2_1_1_2 = new JLabel("Email");
		lblNewLabel_2_1_1_2.setFont(new Font("Tw Cen MT", Font.BOLD, 15));
		lblNewLabel_2_1_1_2.setBounds(91, 368, 127, 34);
		contentPane.add(lblNewLabel_2_1_1_2);
		
		JLabel lblNewLabel_2_1_1_2_1 = new JLabel("Address");
		lblNewLabel_2_1_1_2_1.setFont(new Font("Tw Cen MT", Font.BOLD, 15));
		lblNewLabel_2_1_1_2_1.setBounds(91, 413, 127, 34);
		contentPane.add(lblNewLabel_2_1_1_2_1);
		
		txtid = new JTextField();
		txtid.setColumns(10);
		txtid.setBounds(200, 173, 228, 34);
		contentPane.add(txtid);
		
		txtname = new JTextField();
		txtname.setColumns(10);
		txtname.setBounds(200, 226, 228, 34);
		contentPane.add(txtname);
		
		txtphone = new JTextField();
		txtphone.setColumns(10);
		txtphone.setBounds(200, 277, 228, 34);
		contentPane.add(txtphone);
		
		txtsalary = new JTextField();
		txtsalary.setColumns(10);
		txtsalary.setBounds(200, 330, 228, 34);
		contentPane.add(txtsalary);
		
		txtemail = new JTextField();
		txtemail.setColumns(10);
		txtemail.setBounds(200, 373, 228, 34);
		contentPane.add(txtemail);
		
		txtaddress = new JTextField();
		txtaddress.setColumns(10);
		txtaddress.setBounds(200, 416, 228, 34);
		contentPane.add(txtaddress);
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(0, 0, 0));
		btnNewButton.setFont(new Font("Trebuchet MS", Font.BOLD, 13));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Employee em = new Employee();
				em.setVisible(true);
			}
		});
		btnNewButton.setBounds(515, 294, 126, 34);
		contentPane.add(btnNewButton);
		

		choice = new Choice();
		choice.setBounds(242, 80, 145, 23);
		contentPane.add(choice);
		  
		 String sql = "select * from employee";
		try {
			 con = ConnectionDB.getConnection();
			 st = con.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()) {
				choice.add(rs.getString(1));
			}
			
		} catch(Exception e) {
			e.printStackTrace();	
			}
		
		
		
		
		
		JButton btnView = new JButton("Search");
		btnView.setForeground(new Color(255, 255, 255));
		btnView.setBackground(new Color(0, 0, 0));
		btnView.setFont(new Font("Trebuchet MS", Font.BOLD, 13));
		btnView.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 int id = Integer.parseInt(choice.getSelectedItem());
				String sql = "select * from employee where id = " +id;	
				boolean fo = false;
				try {
					
					Connection con = ConnectionDB.getConnection();
					 st = con.createStatement();
					 ResultSet rs = st.executeQuery(sql);
					 String val = "";
					 if(rs.next()) {
						 fo = true;
							int  i = rs.getInt(1);
							 val += i; 
							txtid.setText(val);	
							val = "";
					    String name =rs.getString(2);	
					    txtname.setText(name);
					    String phone = rs.getString(3);
					    txtphone.setText(phone);
					    int sal =rs.getInt(4);
					    val += sal; 
					    txtsalary.setText(val);
					    String em = rs.getString(5);
					    txtemail.setText(em);
					  String ad = rs.getString(6);
					    txtaddress.setText(ad);
					  
					 }
					 
					 if(fo == false) {
						 JOptionPane.showMessageDialog(null, "Please! Give Valid Id:");
					 }
				} catch(Exception e1) {
					e1.printStackTrace();
				}
				finally {
					if(con != null) {
						try {
							con.close();
							st.close();
							rs.close();
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				}
			}
		});
		btnView.setBounds(476, 69, 116, 40);
		contentPane.add(btnView);
		
		
	}
}
