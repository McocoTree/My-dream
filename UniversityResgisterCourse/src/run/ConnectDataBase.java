package run;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectDataBase {
	public static Connection makeConnection() throws FileNotFoundException, IOException {
			// Need oracle database info(address,user,password)
			String filePath = "D:/all/all/doitjava3/UniversityResgisterCourse/src/run/db.properties";
			Properties properties = new Properties();
			properties.load(new FileReader(filePath));
			String url = properties.getProperty("url");
			String user = properties.getProperty("user");
			String password = properties.getProperty("password");
			// oracle database Object Reference Variables
			Connection con = null;
			
			

			// oracle jdbc library class load
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				System.out.println("jdbc driver load success");
				con = DriverManager.getConnection(url, user, password);
				System.out.println("connect to database success");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
				System.out.println("jdbc driver load fail");
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("deconnet database");
			}
			return con;
		}

		
		}

