package proxycomparator.utils;

import java.sql.Connection;
import java.sql.DriverManager;

import common.db.ConnectionProviderException;
import common.db.impl.JDBCConnectionProvider;
import common.util.ConfigPropertiesReader;

public class MyJDBCConnectionProvider extends JDBCConnectionProvider {

	private static Connection getConnection(String url, String user, String password) {
		Connection con=null;  
		try {  
			con=DriverManager.getConnection(url,user,password);
		} catch(Exception e){ 
			System.err.println("getConnection con error: " + e);
			e.printStackTrace();
		}
		return con;
	}

    public Connection getConnection() throws ConnectionProviderException {
        try {
            String url = ConfigPropertiesReader.getDbJdbcUrl();
            String user = ConfigPropertiesReader.getDbJdbcUser();
            String password = ConfigPropertiesReader.getDbJdbcPassword();
            return DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
        	e.printStackTrace();
            throw new ConnectionProviderException(e);
        }
    }

}
