package connectivity;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionClass {
	public Connection getConnection() {
		Connection connection = null;
		
		String username = "root";
		String password = "tanay123";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
				 connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC"
						,username,password);
				 
			//connection.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return connection;
	}
}
