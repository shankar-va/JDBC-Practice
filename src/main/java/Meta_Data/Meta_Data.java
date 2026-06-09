package Meta_Data;

import java.security.PrivateKey;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class Meta_Data {
	private static String url="jdbc:postgresql://localhost:5432/postgres";
	private static String username="postgres";
	private static String pswd="123";
	public static void main(String[] args) {
		try {
			Class.forName("org.postgresql.Driver");
			Connection conn=DriverManager.getConnection(url,username,pswd);
			
			String query="Select * from student";
			PreparedStatement pstm=conn.prepareStatement(query);
			DatabaseMetaData data=conn.getMetaData();
			System.out.println(data.getDatabaseProductName());
			System.out.println(data.getDatabaseProductVersion());
			ResultSet resultSet=pstm.executeQuery();
			while(resultSet.next()) {
				System.out.println(resultSet.getInt(1)+"\t"+resultSet.getString(2)+"\t"+resultSet.getInt(3));
			}
		    ResultSetMetaData resultSetMetaData=resultSet.getMetaData();
		    System.out.println(resultSetMetaData.getColumnCount());
		    System.out.println(resultSetMetaData.getTableName(2));
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
