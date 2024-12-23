package com.klu.register;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RegisterDao {
	private String dburl="jdbc:mysql://localhost:3306/servlet";
	private String dbname="root";
	private String dbpwd="Vamsi@123";	
	private String dbDriver="com.mysql.cj.jdbc.Driver";
	private String result="Data inserted successfully";
	public String insert(Student s) throws ClassNotFoundException, SQLException
	{
		Class.forName(dbDriver);
		Connection con=DriverManager.getConnection(dburl, dbname, dbpwd);
		String sql="insert into htmltodb values(?,?,?)";
		PreparedStatement ps=con.prepareStatement(sql);
		ps.setString(1, s.getName());
		ps.setString(2, s.getPassword());
		ps.setString(3, s.getEmail());
		ps.executeUpdate();
		return result;
	}
}
