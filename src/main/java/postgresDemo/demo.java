package postgresDemo;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class demo {
	private static String user="postgres";
	private static String pswd="123";
	private static String url="jdbc:postgresql://localhost:5432/postgres";

	public static void main(String[] args) {
		try {
			//----------step-1 -----------------------------------------------
			Class.forName("org.postgresql.Driver");
			//----------step-2-------
			Connection connection =DriverManager.getConnection(url, user,pswd);
			//---step-3---------------------
			Statement statement = connection.createStatement();
			//----------step-4-----
			String sql="update student set age=20 where id=103";
			statement.execute(sql);
			//---step-5-------
			connection.close();
			System.out.println("connection  close");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}