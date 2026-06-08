package JDBC_Practice;
import java.security.interfaces.RSAKey;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Service {
	static Connection connection;
	private static String user="postgres";
	private static String pswd="123";
	private static String url="jdbc:postgresql://localhost:5432/postgres";
	private static PreparedStatement pstm;
	static {
		try {
			Class.forName("org.postgresql.Driver");
			connection=DriverManager.getConnection(url,user,pswd);
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public static int add(Student s) {
		String query="INSERT into student values(?,?,?);";
		
		int res=0;
		try {
			pstm = connection.prepareStatement(query);
			pstm.setInt(1,s.getId());
			pstm.setString(2, s.getName());
			pstm.setInt(3, s.getAge());
			res=pstm.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res;
	}
	public static int removeById(int id) {
		String query = "DELETE FROM student where id=?";
		int res=0;
		try {
			pstm=connection.prepareStatement(query);
			pstm.setInt(1, id);
			res=pstm.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res;
	}
	public static int updateById(Student s,int id) {
		String query="UPDATE student SET id=?,name=?,age=? where id=?";
		int res=0;
		try {
			pstm=connection.prepareStatement(query);
			pstm.setInt(1, s.getId());
			pstm.setString(2, s.getName());
			pstm.setInt(3, s.getAge());
			pstm.setInt(4, id);
			res=pstm.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res;
	}
	public static int getMaxId() {
		String query="SELECT MAX(id) FROM student;";
		try {
			pstm=connection.prepareStatement(query);
			ResultSet res=pstm.executeQuery();
			if(res.next())return res.getInt(1)+1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	public static void selectAll() {
		String query="SELECT * FROM student";
		try {
			pstm=connection.prepareStatement(query);
			ResultSet res=pstm.executeQuery();
			System.out.println("Id\tName\tAge");
			while(res.next()) {
				System.out.println(res.getInt(1)+"\t"+res.getString(2)+"\t"+res.getInt(3));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static boolean closeConnection() {
		try {
			connection.close();
			return true;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
}
