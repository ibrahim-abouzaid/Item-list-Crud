package controller;

import java.io.IOException;
import java.util.Objects;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import model.User;
import service.UserService;
import service.implementation.UserServiceImpl;

/**
 * Servlet implementation class UserController
 */
@WebServlet("/UserController")
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	   @Resource( name = "jdbc/item")
	    private DataSource dataSource;
	   	UserService userService;
	   
		public void init() throws ServletException {
			userService=new UserServiceImpl(dataSource);
		}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		HttpSession session = request.getSession();
		if(Objects.nonNull(session.getAttribute("user"))) {
			response.sendRedirect("ItemController?action=load-items");
			return;

		}
		
		
		 String action = request.getParameter("action");
	        if (Objects.isNull(action)) {
	            action = "user-signup";
	        }
	        switch (action) {
	        
	        case "user-login":
	        	this.userLogin(request,response);
	        	 return;
	        case "user-signup":
	        	this.userSignUp(request,response);
	        	 return;
	        default :
	        	this.userSignUp(request,response);
	        	return;
	        }
		
		
	}

	private void userSignUp(HttpServletRequest request, HttpServletResponse response) {
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		
		
		if(userService.userNameValidation(username) && userService.userNameValidation(username)) {
			boolean isAdded=userService.signUp(new User(username,password));
			
			if(isAdded) {
				 try {
					response.sendRedirect("ItemController?action=load-items");
				 } catch (IOException e) {
					e.printStackTrace();
				 }
			}
		}
		else {
			System.out.println("not valid data");
		
		}
		
	
		
		
	}


	private void userLogin(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String username=request.getParameter("UserName");
		String password=request.getParameter("password");
		boolean isfound=userService.login(new User(username,password));
		if(isfound) {
			HttpSession session = request.getSession();
		    session.setAttribute("user", username);
			response.sendRedirect("ItemController?action=load-items");
		}
		
		else {
            request.setAttribute("errorMessage", "Invalid username or password!");

            request.getRequestDispatcher("login.jsp").forward(request, response);
		}
		
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
