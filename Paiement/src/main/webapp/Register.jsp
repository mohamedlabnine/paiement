<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registration</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<link rel="stylesheet" href="fonts/material-icon/css/material-design-iconic-font.min.css">
<!-- Main css -->
<link rel="stylesheet" href="css/style.css">
</head>
<body>
<section class="vh-100">
  <div class="container-fluid h-custom">
    <div class="row d-flex justify-content-center align-items-center h-100">
      <div class="col-md-9 col-lg-6 col-xl-5">
        <img src="img/bill.jpg" style="margin-top:10px;width:500px;height:500px;"
          class="img-fluid" alt="Sample image">
      </div>
      <div class="col-md-8 col-lg-6 col-xl-4 offset-xl-1">
        <form method="POST" action="RegistrationServlet">
          <div class="d-flex flex-row align-items-center justify-content-center justify-content-lg-start">
            <p class="lead fw-normal mb-0 me-3" style="margin-top:10px;color:red;font-size:2.5em;font-weight:bold;">Register</p>
           
          </div>

          <div class="divider d-flex align-items-center my-4">
            <p class="text-center fw-bold mx-3 mb-0" style="color:blue;font-size:1.4em;font-weight:bold;">Fields</p>
          </div>

          <!-- Email input -->
           <div class="form-outline mb-2">
            <input type="text" id="form3Example3" name="firstname"class="form-control form-control-lg"
              placeholder="Enter First Name" required />
            <label class="form-label" for="form3Example3">First name</label>
          </div>
          
           <div class="form-outline mb-2">
            <input type="text" id="form3Example3" name="lastname" class="form-control form-control-lg"
              placeholder="Enter Last Name" required />
            <label class="form-label" for="form3Example3">Last name</label>
          </div>
          
          
          <div class="form-outline mb-2">
            <input type="email" id="form3Example3" name="email" class="form-control form-control-lg"
              placeholder="Enter a valid email address" required />
            <label class="form-label" for="form3Example3">Email address</label>
          </div>
          <div class="form-outline mb-2">
            <input type="number" id="form3Example3" name="phone" class="form-control form-control-lg"
              placeholder="Enter a valid Phone Number" required />
            <label class="form-label" for="form3Example3">Phone Number</label>
          </div>
          <!-- Password input -->
          <div class="form-outline mb-2">
            <input type="password" id="form3Example4" name="password" class="form-control form-control-lg"
              placeholder="Enter password" />
            <label class="form-label" for="form3Example4">Password</label>
          </div>
          <div class="text-center text-lg-start mt-2 pt-2">
            <button type="submit" class="btn btn-primary btn-lg"
              style="padding-left: 2.5rem; padding-right: 2.5rem;">Register</button>
            <p class="small fw-bold mt-2 pt-1 mb-2" style="margin-top:20px;font-size:2em;">Already Member? <a href="Login.jsp"
                class="link-danger">Login</a></p>
          </div>

        </form>
      </div>
    </div>
  </div>
  
</section>
<script src="vendor/jquery/jquery.min.js"></script>
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>

	

</body>
</html>