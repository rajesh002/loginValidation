package mainapp;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RegisterDao {
	public void addUser(RegisterPojo registerpojo) throws ClassNotFoundException, SQLException {
	String firstname=registerpojo.getFirstname();
	String lastname=registerpojo.getLastname();
	String username=registerpojo.getUsername();
	String password=registerpojo.getPassword();
	String email=registerpojo.getEmail();
	
	ConnectionManager cm=new ConnectionManager();
	
	String sql="insert into USERDETAILS(FIRSTNAME,LASTNAME,USERNAME,PASSWORD,EMAIL)VALUES(?,?,?,?,?)";
	
	PreparedStatement st=cm.getConnection().prepareStatement(sql);
	
	st.setString(1, firstname);
	st.setString(2,lastname);
	st.setString(3, username);
	st.setString(4, password);
	st.setString(5, email);
	
	st.executeUpdate();
	cm.getConnection().close();
	}
}
