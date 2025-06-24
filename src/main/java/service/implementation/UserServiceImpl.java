package service.implementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.regex.Pattern;

import javax.sql.DataSource;

import model.User;
import service.UserService;

public class UserServiceImpl implements UserService {
	
private DataSource dataSource;
	
	

	public UserServiceImpl(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	
	//TODO need to enhance
	@Override
	public boolean login(User user) {
		try {
			Connection connection=this.dataSource.getConnection();
			String query="Select * from User_table where username=?";
			
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1,user.getUserName());
		
			ResultSet result= ps.executeQuery();
			if(result.next()) {
				//if username 
				return user.getUserName().equals(result.getString("username")) && user.getPassWord().equals(result.getString("password"));
			}
		    return result.next();
			}catch(Exception e) {
				   System.out.println(e.getMessage());
				   return false;
				   }
			
		
	}

	@Override
	public boolean signUp(User user) {
		try {
			
			Connection connection=this.dataSource.getConnection();
			String query = "INSERT INTO User_table (username, password) VALUES (?, ?)";
			
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1,user.getUserName());
			ps.setString(2,user.getPassWord());
			
			int result= ps.executeUpdate();
		
		
		    return result==1;
			}catch(Exception e) {
				   System.out.println(e.getMessage()+ "sign up fun");
				   return false;
			}
	}

	@Override
	public boolean userNameValidation(String userName) {
		//Check if username is exist in DB or not AND if username size is less than 5 char
		
		return(!this.getUserByUserName(userName) && userName.length()>5);

	}

	@Override
	public boolean passWordValidation(String passWord) {
		
        return Pattern.matches("^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$ %^&*_-]).{6,}$", passWord);


	}

	@Override
	public boolean getUserByUserName(String userName) {
		try {
			Connection connection=this.dataSource.getConnection();
			String query="Select * from User_table where username=?";
			
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1,userName);
		
			ResultSet result= ps.executeQuery();
		
		    return result.next();
			}catch(Exception e) {
				   System.out.println(e.getMessage()+"get user by name");
				   return false;
			}
	}

}
