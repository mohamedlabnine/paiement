<%@page import="java.util.*" %>
<%@page  language="java"   import="Model.*" %>
<%
Agent agent=new Agent();
Abonnee abonnee=new Abonnee();
List<Facture>list=new ArrayList<Facture>();
int nb=0;
if(session.getAttribute("agent")==null){
	  response.sendRedirect("Login.jsp");
	  
}
else{
	 if(session.getAttribute("listfacture")==null){
		 response.sendRedirect("Agent.jsp");
		 
	 }
	 else{
	   abonnee=(Abonnee)session.getAttribute("abonnee");
	   agent=(Agent) session.getAttribute("agent");
	   list=(List<Facture>) session .getAttribute("listfacture");
	   nb=(int) session.getAttribute("nbfacture");
	 }
}
%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Details</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<link rel="stylesheet" href="fonts/material-icon/css/material-design-iconic-font.min.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
 <link rel="stylesheet"  type="text/css" href="css/style.css" />
 <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
</head>
<body>
<nav>
         <div class="logo">
           <a href="Agent.jsp" style="text-decoration: none;font-size:3rem;color:white;left:50px;top:4px;position:absolute;" > Payment</a>
         </div>
      
         
         <ul>
            <li><form method="POST" action="LogoutServlet"> <button type="submit" style='font-size:25px;margin-top:10px;'>logout <i class='fas fa-sign-out-alt'></i></button></form></li>
         </ul>
      </nav>
      
       <div class="sidebar">
  <header class="avatar">
    <img  style="display: block;border-radius:50%; margin-left: auto;
  margin-right: auto;
  width: 60%;"src="img/download.png" />
  </header> 
  <span> Agent </span>
  </div>
  <div  class="x" id="div1" style="position: relative;margin-left: 400px;margin-top:60px; height:490px;width:830px;border: solid black 1px;">
          <h1 style="border:1px solid black;width:829px;color:white;background-color: #0A3585;">ABONNEE RECORD </h1>
          <img  src="img/client.png"  alt="" style="height: 200px;width: 170px;position: absolute;right: 10px;margin-top:5px">
          
            <table width=640px height=80px  border=1 style="margin-top: 25px;">
              <tr>
                <td bgcolor="grey"  align=left>  <strong style="padding-left:8px">Abonnee ID</strong></td>
              </tr>
              <tr>
                <td align=left><strong style="padding-left:8px;font-size:1.5rem;"><%=abonnee.getId() %> </strong></td>
              </tr>
            </table>
            <div style="display:flex">
             <table width=320px height=80px  border=1 style="margin-top: 25px;">
              <tr>
                <td bgcolor="grey"  align=left>  <strong style="padding-left:8px">FIRST NAME</strong></td>
              </tr>
              <tr>
                <td align=left><strong style="padding-left:8px;font-size:1.5rem;"><%=abonnee.getFirstname() %></strong></td>
              </tr>
            </table>
             <table width=320px height=80px  border=1 style="margin-top: 25px;">
              <tr>
                <td bgcolor="grey"  align=left>  <strong style="padding-left:8px">LAST NAME</strong></td>
              </tr>
              <tr>
                <td align=left><strong style="padding-left:8px;font-size:1.5rem;"><%=abonnee.getLastname() %></strong></td>
              </tr>
            </table>
            </div>
             <div style="display:flex">
             <table width=274px height=80px  border=1 style="margin-top: 25px;">
              <tr>
                <td bgcolor="grey"  align=left>  <strong style="padding-left:8px">ETAT</strong></td>
              </tr>
              <tr>
                <td align=left><strong style="padding-left:8px;font-size:1.5rem;"><%=abonnee.getEtat() %></strong></td>
              </tr>
            </table>
             <table width=274px height=80px  border=1 style="margin-top: 25px;">
              <tr>
                <td bgcolor="grey"  align=left>  <strong style="padding-left:8px">EMAIL</strong></td>
              </tr>
              <tr>
                <td align=left><strong style="padding-left:8px;font-size:1.5rem;"> <%=abonnee.getEmail() %></strong></td>
              </tr>
            </table>
            <table width=274px height=80px  border=1 style="margin-top: 25px;">
              <tr>
                <td bgcolor="grey"  align=left>  <strong style="padding-left:8px">PHONE</strong></td>
              </tr>
              <tr>
                <td align=left><strong style="padding-left:8px;font-size:1.5rem;"><%=abonnee.getPhone() %></strong></td>
              </tr>
            </table>  
            </div>
            <div style="display:flex">
            <table width=340px height=100px  border=1 style="margin-top: 25px;">
              <tr>
                <td bgcolor="grey"  align=left>  <strong style="padding-left:8px">Nb de Factures Non payées</strong></td>
              </tr>
              <tr>
                <td align=left><strong style="padding-left:8px;color:red;font-size:2rem;"><%=nb %></strong></td>
              </tr>
            </table>
             <table width=340px height=100px  border=1 style="margin-top: 25px;">
              <tr>
               
                
<td><form action="ChangeStateServlet" method="post">
<input type="hidden" name="purpose" value="suspend">
<input type="submit" name="submit" value="suspendre" style="color:white;border-radius: 8px;font-size:2rem;background-color:#077fab;margin-left:80px;margin-top:15px;"/>
 <Input type="Hidden" name="id"  id="name" value="<%=abonnee.getId()%>"> 
</form></td>

              </tr>
              <tr>
                <td align=left><strong style="padding-left:8px"></strong></td>
              </tr>
            </table>
            </div>
            </div>
            
            <div class="main">
 <center><important style="color: red;font-size: 3rem;font-weight:bold;"> Liste Des Factures </important></center>
 
 
 
 <table class="table table-bordered table-striped" style="width:1000px;margin:20px;" HEIGHT=300>
    <thead class="thead-dark">
        <tr>
            <th>
               ID
            </th>
            <th>
               MOIS
            </th>
            <th>
                MONTANT
            </th>
            <th>
               ETAT
            </th>
        </tr>
    </thead>
    <tbody>
       <% for(Facture f:list){ %>
            <tr>
              <td width="10%">
                 <h4> <%=f.getId()%></h4>
              </td>
              <td width="36%">
                 <h4 style="font-family:Times new roman;"><%=f.getMois()%> </h4>
              </td >
              <td width="36%">
                  <h4 style="font-family:italic;"> <%=f.getMontant()%></h4>
              </td>
              <td width="18%">
              <% if (f.getEtat().equals("payée") ) { %>
              <strong style="padding-left:8px;color:#12c70c;font-size:1rem;">PAYEE</strong>
              <% } else if (f.getEtat().equals("non payée")) { %>
              <strong style="padding-left:8px;color:#d40831;font-size:1rem">NON PAYEE</strong>
              <% } %>
              </td>
               </tr> 
          <%} %>

    </tbody>
</table>
</div>
  
</body>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
<script src="vendor/jquery/jquery.min.js"></script>
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
	<link rel="stylesheet" href="alert/dist/sweetalert.css">
	
<style>
@import url('https://fonts.googleapis.com/css?family=Poppins:400,500,600,700&display=swap');
 table {
  caption-side: bottom;
  border-collapse: collapse;
}

caption {
  padding-top: 0.5rem;
  padding-bottom: 0.5rem;
  color: #919aa1;
  text-align: left;
}

 th {
  text-align: inherit;
  text-align: -webkit-match-parent;
}

thead,
tbody,
tfoot,
tr,
td,
th {
  border-color: inherit;
  border-style: solid;
  border-width: 0;
}

.main{
  margin-left: 300px;
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
   height: 1000px;
   top:80px;
   left: 0;
   bottom: 0;
   background: #022745;
   padding-top: 50px;
}
.sidebar span{
text-align:center;
font-size:2.5rem;
color:white;
 margin-top:17px;
 margin-left:80px;
}
.sidebar h1{
margin-left:36px;
font-size:3rem;

}

 
</style>

<script src="~/lib/jquery/dist/jquery.min.js"></script>
 <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js" integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN" crossorigin="anonymous"></script>
 </html>