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
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class UpdateEmployee extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField upid;
	private JTextField txtaddress;
	private JTextField txtname;
	private JTextField txtphone;
	private JTextField txtsalary;
	private JTextField txtemail;
	private JCheckBox chsalary;
	private JCheckBox chname;
	private JCheckBox chemail;
	private JCheckBox chphone;
	private JCheckBox chaddress;
	private JLabel label1;
	private ResultSet rs = null;
	private Connection con =null;
	private Statement st =null;
	private int id;
	private PreparedStatement ps = null;
	boolean name1;
	boolean phone1;
	boolean salary1;
	boolean email1;
	boolean ad1 ;
	boolean idcheck;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdateEmployee frame = new UpdateEmployee();
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
	public UpdateEmployee() {
		try {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 742, 558);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Update Employee Details");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(245, 0, 182, 42);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Employee ID To Update:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setBounds(79, 74, 172, 24);
		contentPane.add(lblNewLabel_1);
		
		upid = new JTextField();
		upid.setBounds(273, 70, 219, 35);
		contentPane.add(upid);
		upid.setColumns(10);
		
		
		
		 chsalary = new JCheckBox("Salary:");
		chsalary.setFont(new Font("Tahoma", Font.BOLD, 12));
		chsalary.setBounds(178, 178, 97, 23);
		contentPane.add(chsalary);
		
		 chemail = new JCheckBox("Email:");
		chemail.setFont(new Font("Tahoma", Font.BOLD, 12));
		chemail.setBounds(272, 178, 106, 23);
		contentPane.add(chemail);
		
		 chphone = new JCheckBox("Phone:");
		chphone.setFont(new Font("Tahoma", Font.BOLD, 12));
		chphone.setBounds(382, 178, 97, 23);
		contentPane.add(chphone);
		
		 chaddress = new JCheckBox("Address:");
		chaddress.setFont(new Font("Tahoma", Font.BOLD, 12));
		chaddress.setBounds(502, 178, 97, 23);
		contentPane.add(chaddress);
		
		 chname = new JCheckBox("Name:");
		chname.setFont(new Font("Tahoma", Font.BOLD, 12));
		chname.setBounds(79, 178, 97, 23);
		contentPane.add(chname);
		
		txtaddress = new JTextField();
		txtaddress.setBounds(224, 473, 219, 35);
		contentPane.add(txtaddress);
		txtaddress.setColumns(10);
		
		txtname = new JTextField();
		txtname.setColumns(10);
		txtname.setBounds(224, 259, 219, 35);
		contentPane.add(txtname);
		
		txtphone = new JTextField();
		txtphone.setColumns(10);
		txtphone.setBounds(224, 305, 219, 35);
		contentPane.add(txtphone);
		
		txtsalary = new JTextField();
		txtsalary.setColumns(10);
		txtsalary.setBounds(224, 365, 219, 35);
		contentPane.add(txtsalary);
		
		txtemail = new JTextField();
		txtemail.setColumns(10);
		txtemail.setBounds(224, 411, 219, 35);
		contentPane.add(txtemail);
		
		txtaddress.setEditable(false);
		txtemail.setEditable(false);
		txtname.setEditable(false);
		txtphone.setEditable(false);
		txtsalary.setEditable(false);
		
		chname.setEnabled(false);
		chaddress.setEnabled(false);
		chemail.setEnabled(false);
		chphone.setEnabled(false);
		chsalary.setEnabled(false);
		
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				 
				 
				if(chname.isSelected()) {
					
					txtname.setEditable(true);
				name1 = true;
				
//					ps.setInt(1, );
				}if(chphone.isSelected()) {
					txtphone.setEditable(true);
					phone1 = true;
					
				
					
				}if(chsalary.isSelected()) {
					txtsalary.setEditable(true);
					salary1 = true;
					
					
				}if(chemail.isSelected()) {
					txtemail.setEditable(true);
					email1 = true;
					
					
				}if(chaddress.isSelected()) {
					txtaddress.setEditable(true);
					ad1 = true;
					
					
				}
			}catch (Exception e1) {
				e1.printStackTrace();
				
			}
				}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton.setBounds(245, 206, 133, 42);
		contentPane.add(btnNewButton);
		
		
		JButton btnNewButton_1 = new JButton("Update");
		btnNewButton_1.addActionListener(new ActionListener() {
//			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				try {
					if(idcheck == true) {
					 con = ConnectionDB.getConnection();
					if(name1 == true) {
						String name = txtname.getText();
						String sql1 = "update employee set name = ? where id=?";
						 ps = con.prepareStatement(sql1);
						 ps.setString(1, name);
						 ps.setInt(2, id);
						  ps.executeUpdate();
						
					}
					
					//condition
					if(phone1 == true) {
						String phone = txtphone.getText();
						String sql2 = "update employee set phone = ? where id=?";
						 ps = con.prepareStatement(sql2);
						ps.setString(1, phone);
						ps.setInt(2,id);
						 ps.executeUpdate();
					}
					
					//Condition
					if(salary1 == true) {

						int salary = Integer.parseInt(txtsalary.getText());
						String sql3 = "update employee set salary = ? where id=?";
						 ps = con.prepareStatement(sql3);
						ps.setInt(1, salary);
						ps.setInt(2,id);
						ps.executeUpdate();
					}
					//condition
					
					if(email1 == true) {
						String email = txtemail.getText();
						String sql5 = "update employee set email = ? where id=?";
						 ps = con.prepareStatement(sql5);
						ps.setString(1,email);
						ps.setInt(2,id);
						ps.executeUpdate();
					}
					
					if(ad1 = true) {
						String ad = txtaddress.getText();
						String sql4 = "update employee set address = ? where id=?";
						 ps = con.prepareStatement(sql4);
						ps.setString(1,ad);
						ps.setInt(2,id);
						ps.executeUpdate();
					}
					
					
						JOptionPane.showMessageDialog(null, "Update Success.");
						txtaddress.setText(" ");
						txtemail.setText(" ");
						txtname.setText(" ");
						txtphone.setText(" ");
						txtsalary.setText(" ");
						
				}
					else {
						JOptionPane.showMessageDialog(null, "Please Give Id First!");
					}
				
				
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				finally {
					try {
						if(con != null) {
						con.close();
						ps.close();
						st.close();
						rs.close();
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_1.setBounds(510, 339, 157, 46);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_2 = new JLabel("Name");
		lblNewLabel_2.setFont(new Font("Tw Cen MT", Font.BOLD, 12));
		lblNewLabel_2.setBounds(79, 264, 80, 25);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("phone");
		lblNewLabel_2_1.setFont(new Font("Trebuchet MS", Font.BOLD, 12));
		lblNewLabel_2_1.setBounds(79, 309, 80, 25);
		contentPane.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("salary");
		lblNewLabel_2_1_1.setFont(new Font("Trebuchet MS", Font.BOLD, 12));
		lblNewLabel_2_1_1.setBounds(79, 369, 80, 25);
		contentPane.add(lblNewLabel_2_1_1);
		
		JLabel lblNewLabel_2_1_1_1 = new JLabel("Email");
		lblNewLabel_2_1_1_1.setFont(new Font("Trebuchet MS", Font.BOLD, 12));
		lblNewLabel_2_1_1_1.setBounds(79, 415, 80, 25);
		contentPane.add(lblNewLabel_2_1_1_1);
		
		JLabel lblNewLabel_2_1_1_1_1 = new JLabel("Address");
		lblNewLabel_2_1_1_1_1.setFont(new Font("Trebuchet MS", Font.BOLD, 12));
		lblNewLabel_2_1_1_1_1.setBounds(79, 477, 80, 25);
		contentPane.add(lblNewLabel_2_1_1_1_1);
		
		JButton btnNewButton_1_1 = new JButton("Back");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Employee em = new Employee();
				em.setVisible(true);
			}
		});
		btnNewButton_1_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_1_1.setBounds(510, 250, 157, 46);
		contentPane.add(btnNewButton_1_1);
		
		JButton btnView = new JButton("View");
		btnView.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				   id = Integer.parseInt(upid.getText());
				String sql = "select * from employee where id =" +id;
				
				try {
					 con = ConnectionDB.getConnection();
					 st= con.createStatement();
					 rs = st.executeQuery(sql);
					if(rs.next()) {
						idcheck = true;
						chname.setEnabled(true);
						chaddress.setEnabled(true);
						chemail.setEnabled(true);
						chphone.setEnabled(true);
						chsalary.setEnabled(true);
					}
					else {
					 JOptionPane.showMessageDialog(null, "Invalid Id");
	
					}
				}catch (Exception e1) {
					e1.printStackTrace();
					
				}
				finally {
					try {
						con.close();
						st.close();
						rs.close();
					} catch (SQLException e1) {
						
						e1.printStackTrace();
					}
				}
			}
		});
		btnView.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnView.setBounds(525, 70, 133, 42);
		contentPane.add(btnView);
		
		 label1 = new JLabel("");
		label1.setFont(new Font("Tw Cen MT", Font.BOLD, 12));
		label1.setBounds(296, 129, 229, 25);
		contentPane.add(label1);
		}catch (NullPointerException e) {
			JOptionPane.showMessageDialog(null, "Please Give Id First!");
		}
	}
}
