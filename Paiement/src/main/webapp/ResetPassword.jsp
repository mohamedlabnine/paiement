<%
  if(request.getSession().getAttribute("code")==null){
	  response.sendRedirect("Login.jsp");
	  
  }
%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Reset Password</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<link rel="stylesheet" href="fonts/material-icon/css/material-design-iconic-font.min.css">
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css"
    integrity="sha512-KfkfwYDsLkIlwQp6LFnl8zNdLGxu9YAA1QvwINks4PhcElQSvqcyVLLD9aMhXd13uQjoXtEKNosOWaZqXgel0g=="
    crossorigin="anonymous" referrerpolicy="no-referrer" />

<style type="text/css">
.form-gap {
    padding-top: 70px;
}
</style>
</head>
<body>
	<div class="form-gap"></div>
	<div class="container">
		<div class="row">
			<div class="col-md-5 col-md-offset-3" style="margin-left:340px;">
				<div class="panel panel-default">
					<div class="panel-body">
						<div class="text-center">
							<h3>
								<i class="fa-solid fa-key fa-3x"></i>
							</h3>
							<h2 class="text-center">Enter New Password</h2>
							<%
		  			if(request.getAttribute("status")!=null)
		  			{
		  				out.print("<p class='text-danger ml-1'>"+request.getAttribute("status")+"</p>");
		  			}
		  %>
							<div class="panel-body">

								<form id="register-form" action="ResetPasswordServlet" role="form" autocomplete="off"
									class="form" method="post">

									<div class="form-group">
										<div class="input-group">
											<span class="input-group-addon"><i
												class="glyphicon glyphicon-envelope color-blue"></i></span> <input
												id="code" name="password1" placeholder="Enter New Password"
												class="form-control" type="text" required="required">
										</div>
									</div>
									<div class="form-group">
										<div class="input-group">
											<span class="input-group-addon"><i
												class="glyphicon glyphicon-envelope color-blue"></i></span> <input
												id="code" name="password2" placeholder="Confirm New Password"
												class="form-control" type="text" required="required">
										</div>
									</div>
									<div class="form-group">
										<input name="code"
											class="btn btn-lg btn-primary btn-block"
											value="Reset Password" type="submit">
									</div>

									
								</form>

							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	
</body>
</body>
</html>