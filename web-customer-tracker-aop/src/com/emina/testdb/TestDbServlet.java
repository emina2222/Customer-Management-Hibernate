package com.emina.testdb;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestDbServlet
 */
@WebServlet("/TestDbServlet")
public class TestDbServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String jdbcUrl="jdbc:sqlserver://localhost:1433;databaseName=turisticka_agencija5;integratedSecurity=true;";
		String driver="com.microsoft.sqlserver.jdbc.SQLServerDriver";
		
		try {
			PrintWriter out=response.getWriter();
			out.println(jdbcUrl);
			Class.forName(driver);
			Connection conn=DriverManager.getConnection(jdbcUrl);
			out.println("Connection successful!");
			conn.close();
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}

}
