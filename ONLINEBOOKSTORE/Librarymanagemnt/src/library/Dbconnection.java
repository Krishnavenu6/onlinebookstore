package library;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Dbconnection {
	 private static final String driver_path="com.mysql.cj.jdbc.Driver";
		private static final String url = "jdbc:mysql://localhost:3306/library";
		private static final String userName = "root";
		private static final String passWord = "root";
		
		public Dbconnection () {
			try {
				Class.forName(driver_path);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

public Connection getConnection() throws SQLException{
		return DriverManager.getConnection(url,userName,passWord);
	}

	public Statement createStatement() {
	// TODO Auto-generated method stub
	return null;
}
}

