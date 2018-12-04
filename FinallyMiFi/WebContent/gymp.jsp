<%@ page language="java" contentType="text/html; charset=ISO-8859-1" import=" com.beans.GymInfo,java.util.ArrayList,java.sql.PreparedStatement,java.sql.ResultSet,java.sql.Connection.*,com.mysql.jdbc.Connection,javax.servlet.*,com.listener.*,com.database.*;"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 <title>Gym's Under Us</title>
        <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
    
    
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<!------ Include the above in your HEAD tag ---------->
    
    <link rel = "stylesheet" href="index.css">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <style>
    /* Remove the navbar's default rounded borders and increase the bottom margin */ 
    .navbar {
      margin-bottom: 50px;
      border-radius: 0;
    }
    
    /* Remove the jumbotron's default bottom margin */ 
     .jumbotron {
      margin-bottom: 0;
    }
   
    /* Add a gray background color and some padding to the footer */
    footer {
      background-color: #f2f2f2;
      padding: 25px;
    }
  </style>
</head>
<body>

  <div class="jumbotron">
  <div class="container text-center">
    <h1>Gym-P</h1>      
    <p>Spreading fitness across nation</p>
  </div>
</div>

<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>                        
      </button>
      <!--<a class="navbar-brand" href="#"><img src="logo1.jpg"></a>-->
       <a class="navbar-brand" href="index.html" style="padding:0px;">
  <img src="logo1.png" style="height:100%;">
</a>
    </div>
    <div class="collapse navbar-collapse" id="myNavbar">
      <ul class="nav navbar-nav">
        <li ><a href="test.jsp">Home</a></li>
        <li><a href="#">About Us</a></li>
        <li class="active"><a href="#">Gym-P</a></li>
        <li><a href="contact_us.html">Contact Us</a></li>
        
      </ul>
      <ul class="nav navbar-nav navbar-right">
        <li><a href="#"><span class="glyphicon glyphicon-user"></span> Your Account</a></li>
        <li><a href="#"><span class="glyphicon glyphicon-shopping-cart"></span> Cart</a></li>
      </ul>
    </div>
  </div>
</nav>
    <style>
body {
  font-family: Arial, Helvetica, sans-serif;
  font-size: 20px;
}
    
    #myBtn {
  display: none;
  position: fixed;
  bottom: 20px;
  right: 30px;
  z-index: 99;
  font-size: 18px;
  border: none;
  outline: none;
  background-color: grey;
  color: white;
  cursor: pointer;
  padding: 15px;
  border-radius: 4px;
}

#myBtn:hover {
  background-color: #555;
}
</style>
        <div class = "container">   	
        	<%
        	ArrayList al = new ArrayList();
        	Connection con;
        	 con = (Connection)getServletContext().getAttribute("DbConnection");
        	Database do2 = new Database(con);
        	al = do2.extract();
        	%>
        	<%GymInfo g1; %>	
			<%for(int i = 0; i< al.size();i++)
				{
				System.out.println(al.get(i)+"inside jsp");
				g1=(GymInfo)al.get(i);
				
				%>
				<% %>
				
				      
        	<div class = "block">
            <hr>
                <div class = "row">
                    <div class = "col-sm-4">image:<img src = "<%=g1.getImage() %>"></div>
                    <div class = "col-sm-8"><br>
                     Name:<%= g1.getGymName()%>><br><br>
                     <img src = "locationicon.png" style = "width: 20px; height: 20px;"> Locality:<%= g1.getLocality() %><br><br>    
                    Address:<%= g1.getGAddress() %><br><br>
                    Gym-info:<%= g1.getGInfo() %><br><br><br>
                    Price:<%= g1.getPrice() %>
                        <input type = "submit" value = "booknow"><br><br>
                    </div>
                </div>
            <hr>
            </div>
			<%	}%> 
        
        </div>

</body>
</html>