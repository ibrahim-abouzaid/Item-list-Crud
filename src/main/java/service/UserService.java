package service;

import model.User;

public interface UserService {
	
	boolean login(User user);
	boolean signUp(User user);
	boolean userNameValidation(String userName);
	boolean passWordValidation(String passWord);
	boolean getUserByUserName(String userName);

}
