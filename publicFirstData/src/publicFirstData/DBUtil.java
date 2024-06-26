package publicFirstData;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBUtil {
	public static Connection makeConnection()  {
		//db.properties 파일경로
       // String filePath = "D:/all/all/doitjava3/mireproject/src/db.properties";
        String filePath = "D:/all/all/doitjava3/publicFirstData/src/db.properties";
        Connection con = null;
        try {
        	//db.properties 디비주소, 사용자명,암호 가져오기
        	Properties properties = new Properties();
        	properties.load(new FileReader(filePath));
        	String url = properties.getProperty("url");
        	String user = properties.getProperty("user");
        	String password = properties.getProperty("password");
        	//ORACLE LOAD JDBC
        	Class.forName("oracle.jdbc.driver.OracleDriver");
            System.out.println("데이타베이스 드라이버 로드 성공");
            con = DriverManager.getConnection(url, user, password);
            System.out.println("데이타베이스 접속 성공");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("데이타베이스 드라이버 로드 실패");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("데이타베이스 연결 실패");
        } catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("DB.PROPERTIES 연결 실패");
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("DB.PROPERTIES 실패");
		}
        return con;
    }

}
