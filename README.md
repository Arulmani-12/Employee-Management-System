# Employee Management System

## Overview
The Employee Management System is a standalone application that allows an admin to manage employee details efficiently. The admin can log in with valid credentials and perform operations such as adding, deleting, updating, and viewing employee records.

## Features

- **Admin Login:** Admin can log in using a valid username and password.
- **View Employees:** Admin can view the list of all employees.
- **View Employee by ID:** Admin can search for an employee using their ID.
- **Add Employee:** Admin can add a new employee with relevant details.
- **Update Employee:** Admin can update only necessary details about an employee.
- **Delete Employee:** Admin can delete an employee using their ID.

## How It Works

1. **Admin Login:**

   - The admin enters a valid username and password.
   - If valid, the system redirects to the Employee Dashboard.
   - If invalid, a warning message appears: *"Invalid name or password"*.

2. **Employee Dashboard:**

   - The dashboard contains five options:
     - **View Employees**: Redirects to a page displaying all employees.
     - **View Employee by ID**: Redirects to a search page to find employees using their ID.
     - **Add Employee**: Redirects to a form to add new employees.
     - **Update Employee**: Redirects to a page where necessary details of an employee can be updated.
     - **Delete Employee**: Redirects to a page where an employee can be removed by ID.

## Technologies Used

- **Java Swing & AWT** – For the graphical user interface.
- **Java** – For backend logic implementation.
- **MySQL** – For storing employee details.
- **JDBC (Java Database Connectivity)** – For connecting Java and MySQL.

## Setup Instructions

1. Clone the repository from GitHub.
2. Set up MySQL database and import the required schema.
3. Update database connection details in the project.
4. Compile and run the Java application.

## Screenshot
![Emp](https://github.com/user-attachments/assets/b5870b80-e622-4687-b6da-caa3baf3c919)

