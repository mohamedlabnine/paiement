<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ForgetPassword</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<link rel="stylesheet" href="fonts/material-icon/css/material-design-iconic-font.min.css">
</head>
<body>
<input type="hidden" id="status" value="<%= request.getAttribute("status") %>"/>
<div class="card text-center" style="width: 500px;height:400px;  position:fixed; top:80px; left:450px; ">
    <div class="card-header h5 text-white bg-primary">Password Reset</div>
    <div class="card-body px-5">
        <p class="card-text py-2" style="color:red;font-size:1.2em">
            Enter your email address and we'll send you a Verification Code to reset your password.
        </p>
        <form method="POST" action="ForgetPasswordServlet">
        <div class="form-outline" >
         <label class="form-label" for="typeEmail">Email input</label>
            <input type="email" id="typeEmail" name="email" class="form-control my-3" required />
        </div>
        <button type="submit" class="btn btn-primary w-100">Send Code</button>
        </form>
        <div class="d-flex justify-content-between mt-4">
            <a class="link-danger" href="Login.jsp">Login</a>
            <a class="link-danger" href="Register.jsp">Register</a>
        </div>
    </div>
</div>
<script src="vendor/jquery/jquery.min.js"></script>
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
	<link rel="stylesheet" href="alert/dist/sweetalert.css">
	<script type="text/javascript">
	var status=document.getElementById("status").value;
	if(status=="email doesn't exist"){
		swal("error","This email doesn't Exist","error");
	}
	</script>
</body>
</html>