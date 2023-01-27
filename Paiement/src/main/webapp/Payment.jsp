<%@page import="java.util.*" %>
<%@page import="java.time.*" %>
<%@page  language="java"   import="Model.*" %>

<%
Abonnee a=new Abonnee();
Facture f=new Facture();
LocalDate date=LocalDate.now();
  if(session.getAttribute("user")==null ){
	  response.sendRedirect("Login.jsp");
	  
  }
  else{
	 if(session.getAttribute("facture")==null){
		 response.sendRedirect("Index.jsp");
		 
	 }
	 else{
	   a=(Abonnee) session.getAttribute("user");
	   f=(Facture) session .getAttribute("facture");
	 }
	   
  }
  
%>


<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Payment</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<link rel="stylesheet" href="fonts/material-icon/css/material-design-iconic-font.min.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
 <link rel="stylesheet"  type="text/css" href="css/style.css" />
 <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
</head>
<body>
<input type="hidden" id="status" value="<%= request.getAttribute("status") %>"/>
<nav>
         <div class="logo">
           <a href="Index.jsp" style="text-decoration: none;font-size:3rem;color:white;left:50px;top:4px;position:absolute;" > Payment</a>
         </div>
      
         
         <ul>
            <li><form method="POST" action="LogoutServlet"> <button type="submit" style='font-size:25px;margin-top:10px;'>logout <i class='fas fa-sign-out-alt'></i></button></form></li>
         </ul>
      </nav>
      
      <div class="sidebar">
  <header class="avatar">
    <img  style="display: block;border-radius:50%; margin-left: auto;
  margin-right: auto;
  width: 60%;"src="img/client.png" />
  </header> 
<span><%=a.getFirstname() %> <%=a.getLastname() %></span>

<% if (a.getEtat().equals("abonné") ) { %>
<h1 style="color:#12c70c;margin-left:40px;">abonné</h1>
<% } else if (a.getEtat().equals("désabonné")) { %>
<h1  style="color:#ab0707;margin-left:10px">désabonné</h1>
<% } else if (a.getEtat().equals("suspendu")) { %>
<h1 style="color:#077fab;margin-left:30px;">suspendu</h1>
<% } %>

<% if (a.getEtat().equals("désabonné") ) { %>
<form action="ChangeStateServlet" method="post">
<input type="hidden" name="purpose" value="abonné">
<input type="submit" name="submit" value="abonné" style="margin-left:65px;margin-top:16px;background-color:#12c70c;color:white;font-size:2rem;border-radius: 8px;"/>
</form>
<% } else if (a.getEtat().equals("abonné")) { %>
<form action="ChangeStateServlet" method="post">
<input type="hidden" name="purpose" value="abonné">
<input type="submit" name="submit" value="désabonné" style="margin-left:35px;margin-top:16px;background-color:#ab0707;color:white;font-size:2rem;border-radius: 8px;"/>
</form>
<% } %>
</div>
 <div class="main">
 <center><important style="color: red;font-size: 2.4rem;font-weight:bold;"> Paiment De Factures en Ligne </important></center>
  <center><important style="color: black;font-size: 1.7rem;font-weight:bold;"> Mr :  <%=a.getFirstname() %> <%=a.getLastname() %> </important></center>
  <center><important style="color: #059e33;font-size: 1.7rem;font-weight:bold;"> Montant :  <%=f.getMontant() %>   $</important></center>
 
<section class="p-4 p-md-10" >
  <div class="row d-flex justify-content-center">
    <div class="col-md-10 col-lg-8 col-xl-7">
      <div class="card rounded-3">
        <div class="card-body p-4">
          <div class="text-center mb-4">
            <h1>Payment</h1>
          </div>
          <form action="PaymentServlet" mathod="post">
           <Input type="Hidden" name="idfacture"  id="name" value="<%=f.getId()%>"> 
           <Input type="Hidden" name="montant"  id="name" value="<%=f.getMontant()%>"> 
            <div class="d-flex flex-row align-items-center mb-4 pb-1">
              <img class="img-fluid"  style="width: 400px;height: 100px;display: block;border-radius:10%; margin-left: auto;
  margin-right: auto;" src="img/visa.jpeg" />           
            </div>
            <div class="d-flex flex-row align-items-center mb-4 pb-1"> 
              <div class="flex-fill mx-3">
                <div class="form-outline">
                  <input type="text" id="formControlLgXc" class="form-control form-control-lg"
                    value="**** **** **** ****"  name="cardnumber" minlength="16" maxlength="16" required/>
                  <label class="form-label" for="formControlLgXc" >Card Number</label>
                </div>
              </div>
              
            </div>

            <div class="row mb-4">             
              <div class="col-7">
                <div class="form-outline">
                  <input type="date" id="formControlLgExpk" class="form-control form-control-lg"
                     placeholder="dd-mm-yyyy" name="expire"  min="<%=date%>" required/>
                  <label class="form-label" for="formControlLgExpk">Expire</label>
                </div>
              </div>
              <div class="col-4">
                <div class="form-outline">
                  <input type="password" id="formControlLgcvv" name="cvv"  minlength="3" maxlength="3" class="form-control form-control-lg"
                    placeholder="***" required/>
                  <label class="form-label" for="formControlLgcvv">Cvv</label>
                </div>
              </div>
            </div>

            <input type="submit" class="btn btn-success btn-lg btn-block" value="Payment"></button>
          </form>
        </div>
      </div>
    </div>
  </div>
</section>
 
 
 </div>




</body>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
<script src="vendor/jquery/jquery.min.js"></script>
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
	<link rel="stylesheet" href="alert/dist/sweetalert.css">
		<script type="text/javascript">
	var status=document.getElementById("status").value;
	if(status=="abonné"){
		swal("congrats","vous etes maintenant abonnée","success");
		
	}
	
	else if(status=="désabonné"){
		swal("Attention","vous etes maintanant désabonnée","error");	
	}
	</script>
	
<style>
@import url('https://fonts.googleapis.com/css?family=Poppins:400,500,600,700&display=swap');
 
.main{
  margin-left: 280px;
  margin-top:10px;
}

nav{
  display: flex;
  height: 80px;
  width: 100%;
  background: #1b1b1b;
  align-items: center;
  justify-content: space-between;
  padding: 0 50px 0 100px;
  flex-wrap: wrap;
}
nav .logo{
  color: #fff;
  font-size: 35px;
  font-weight: 600;
}
nav ul{
  display: flex;
  flex-wrap: wrap;
  list-style: none;
}
nav ul li{
  margin: 0 5px;
}
nav ul li a{
  color: #f2f2f2;
  text-decoration: none;
  font-size: 18px;
  font-weight: 500;
  padding: 8px 15px;
  border-radius: 5px;
  letter-spacing: 1px;
  transition: all 0.3s ease;
}
nav ul li a.active,
nav ul li a:hover{
  color: #111;
  background: #fff;
}
nav .menu-btn i{
  color: #fff;
  font-size: 22px;
  cursor: pointer;
  display: none;
}
input[type="checkbox"]{
  display: none;
}
@media (max-width: 1000px){
  nav{
    padding: 0 40px 0 50px;
  }
}
@media (max-width: 920px) {
  nav .menu-btn i{
    display: block;
  }
  #click:checked ~ .menu-btn i:before{
    content: "\f00d";
  }
  nav ul{
    position: fixed;
    top: 80px;
    left: -100%;
    background: #111;
    height: 100vh;
    width: 100%;
    text-align: center;
    display: block;
    transition: all 0.3s ease;
  }
  #click:checked ~ ul{
    left: 0;
  }
  nav ul li{
    width: 100%;
    margin: 40px 0;
  }
  nav ul li a{
    width: 100%;
    margin-left: -100%;
    display: block;
    font-size: 20px;
    transition: 0.6s cubic-bezier(0.68, -0.55, 0.265, 1.55);
  }
  #click:checked ~ ul li a{
    margin-left: 0px;
  }
  nav ul li a.active,
  nav ul li a:hover{
    background: none;
    color: cyan;
  }
}
.sidebar{
   position: absolute;
   width: 280px;
    height: 720px;
   top:80px;
   left: 0;
   bottom:0;   
   background: #022745;
   padding-top: 50px;
}
.sidebar span{
text-align:center;
font-size:2.5rem;
color:white;
 margin-top:17px;
 margin-left:30px;
}
.sidebar h1{
margin-left:36px;
font-size:3rem;

}

 
</style>

<script src="~/lib/jquery/dist/jquery.min.js"></script>
 <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js" integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN" crossorigin="anonymous"></script>
</html>