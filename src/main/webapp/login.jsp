<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <title>Login</title>
  <link rel="stylesheet" href="css/loginCss.css" />
</head>
<body class="body-bg">


  <div class="card">
    <h2 class="card-title">Login to Your Account</h2>
     <p style="color:red;">
        ${errorMessage}
    </p>
    <form action="/Item_Service/UserController" >
      <div class="form-group">
        <label  class="label">Username</label>
        <input type="text" id="username" name="UserName" required class="input" />
      </div>

      <div class="form-group">
        <label for="password" class="label">Password</label>
        <input type="password" id="password" name="password" required class="input" />
      </div>

      <div class="form-options">
        <label class="checkbox-label">
          <input type="checkbox" />
          <span>Remember me</span>
        </label>
        <a href="#" class="link-sm">Forgot password?</a>
      </div>
	<input type="hidden" required name="action" value="user-login">	
      <button type="submit" class="btn-submit">Log In</button>
    </form>

    <p class="footer-text">
      Don't have an account? 
      <a href="signUp-page.html" class="link">Sign up</a>
    </p>
  </div>

</body>
</html>