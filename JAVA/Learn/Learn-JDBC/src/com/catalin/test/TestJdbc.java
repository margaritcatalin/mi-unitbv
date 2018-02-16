package com.catalin.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestJdbc {
public static void main(String[] args) {
	String url="jdbc:mysql://localhost:3306/learn";
	try {
		Connection con=DriverManager.getConnection(url,"root","1q2w3e");
		String sql="DELETE FROM persoane";
		Statement stmt=con.createStatement();
		stmt.executeUpdate(sql);
		int n=10;
		sql="INSERT INTO persoane VALUES(?, ?, ?)";
		PreparedStatement pstmt=con.prepareStatement(sql);
		for(int i=0;i<n;i++) {
			int cod=i;
			String nume="Persoana "+i;
			double salariu=100+Math.round(Math.random()*900);
			pstmt.setInt(1, cod);
			pstmt.setString(2, nume);
			pstmt.setDouble(3, salariu);
			pstmt.executeUpdate();
		}
		sql="SELECT * FROM persoane ORDER BY salariu";
		ResultSet rs=stmt.executeQuery(sql);
		while(rs.next()) {
			System.out.println(rs.getInt("cod")+", "+rs.getString("nume")+", "+rs.getDouble("salariu"));
			
		}
		sql="SELECT avg(salariu) FROM persoane";
		rs=stmt.executeQuery(sql);
		rs.next();
		System.out.println("Media:"+rs.getDouble(1));
		con.close();
	}catch(SQLException e) {
		e.printStackTrace();
	}
}
}
