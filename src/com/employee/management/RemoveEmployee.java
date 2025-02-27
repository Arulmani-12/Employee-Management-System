package com.employee.management;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.*;
import java.awt.event.ActionEvent;

public class RemoveEmployee extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField rid;
	private JTextField txtid;
	private JTextField txtname;
	private JTextField txtphone;
	private JTextField txtemail;
	private JTextField txtaddress;
	private JTextField txtsalary;
	private Connection con = null;
	private Statement st = null;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RemoveEmployee frame = new RemoveEmployee();
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
	public RemoveEmployee() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 773, 552);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Remove Employee");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(283, 11, 199, 30);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Employee_Id :");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1.setBounds(102, 69, 123, 30);
		contentPane.add(lblNewLabel_1);
		
		rid = new JTextField();
		rid.setBackground(new Color(255, 250, 250));
		rid.setBounds(224, 68, 207, 35);
		contentPane.add(rid);
		rid.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Id");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_2.setBounds(130, 136, 143, 30);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("Name");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_2_1.setBounds(130, 177, 143, 30);
		contentPane.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("Salary");
		lblNewLabel_2_1_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_2_1_1.setBounds(130, 262, 143, 30);
		contentPane.add(lblNewLabel_2_1_1);
		
		JButton btnNewButton = new JButton("Remove_Data");
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 int id =Integer.parseInt(rid.getText());
				String sql = "delete from employee where id =" +id;
				try {
					
					con= ConnectionDB.getConnection();
				st = con.createStatement();
				int row = st.executeUpdate(sql);
				 if(row == 1) {
					 JOptionPane.showMessageDialog(null, "Emp_data Deleted Successfully");
					 txtid.setText(" ");
					 txtemail.setText(" ");
				 txtaddress.setText(" ");
				 txtname.setText(" ");
				 txtphone.setText(" ");
				 txtsalary.setText(" ");
				 }
					
				}catch (Exception e1) {
					e1.printStackTrace();
				}
				finally {
					try {
						con.close();
						st.close();
						
					}catch (Exception e1) {
					e1.printStackTrace();
					}
				}
			}
		});
		btnNewButton.setBackground(new Color(0, 0, 0));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton.setBounds(234, 438, 137, 47);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_2_1_1_1 = new JLabel("Email");
		lblNewLabel_2_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_2_1_1_1.setBounds(130, 303, 143, 30);
		contentPane.add(lblNewLabel_2_1_1_1);
		
		JLabel lblNewLabel_2_1_1_1_1 = new JLabel("Address");
		lblNewLabel_2_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_2_1_1_1_1.setBounds(130, 369, 143, 30);
		contentPane.add(lblNewLabel_2_1_1_1_1);
		
		txtid = new JTextField();
		txtid.setBackground(new Color(255, 250, 250));
		txtid.setColumns(10);
		txtid.setBounds(234, 137, 207, 30);
		contentPane.add(txtid);
		
		txtname = new JTextField();
		txtname.setBackground(new Color(255, 250, 250));
		txtname.setColumns(10);
		txtname.setBounds(233, 183, 207, 30);
		contentPane.add(txtname);
		
		txtphone = new JTextField();
		txtphone.setBackground(new Color(255, 250, 250));
		txtphone.setColumns(10);
		txtphone.setBounds(233, 224, 207, 30);
		contentPane.add(txtphone);
		
		txtemail = new JTextField();
		txtemail.setBackground(new Color(255, 250, 250));
		txtemail.setColumns(10);
		txtemail.setBounds(234, 318, 207, 30);
		contentPane.add(txtemail);
		
		txtaddress = new JTextField();
		txtaddress.setBackground(new Color(255, 250, 250));
		txtaddress.setColumns(10);
		txtaddress.setBounds(234, 370, 207, 30);
		contentPane.add(txtaddress);
		
		JButton btnBack = new JButton("Back");
		btnBack.setForeground(new Color(255, 255, 255));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Employee em = new Employee();
				em.setVisible(true);
			}
		});
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnBack.setBackground(new Color(0, 0, 0));
		btnBack.setBounds(432, 438, 132, 47);
		contentPane.add(btnBack);
		
		JButton btnNewButton_1 = new JButton("View");
		btnNewButton_1.setBackground(new Color(0, 0, 0));
		btnNewButton_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1.setFont(new Font("Verdana", Font.BOLD, 13));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean fo = false;
				int id = Integer.parseInt(rid.getText()); 
				String sql = "select * from employee where id ="+id;
				try {
				Connection con = ConnectionDB.getConnection();
				Statement st = con.createStatement();
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
					JOptionPane.showMessageDialog(null, "Please! Give Valid ID:");
				 }
					
				}catch (Exception e1) {
					e1.printStackTrace();
					
				}
			}
		});
		btnNewButton_1.setBounds(466, 66, 132, 35);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_2_1_1_2 = new JLabel("Phone");
		lblNewLabel_2_1_1_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_2_1_1_2.setBounds(130, 218, 143, 30);
		contentPane.add(lblNewLabel_2_1_1_2);
		
		txtsalary = new JTextField();
		txtsalary.setBackground(new Color(255, 250, 250));
		txtsalary.setColumns(10);
		txtsalary.setBounds(234, 265, 207, 30);
		contentPane.add(txtsalary);
	}
}
