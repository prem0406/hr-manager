<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>HR Home</title>
 <style type="text/css">
    
        body {
            font-family: sans-serif;
        }
        
        table, td, tr, th {
            padding: 10px;
            border-collapse: collapse;
            border: 1px solid #444;
            letter-spacing: 1px;
        }
        
        table {
            width: 100%;
        }
        
        button {
            margin: 5px;
        }

        .container {
            border: 1px solid #333;
            height: 70%;
            width: 60%
            
           
        }
        .header {
            padding: 10px; 
            font-size: 18px; 
            letter-spacing: 1px;
             border-bottom: 1px solid #333;
        }
        </style>
</head>
<body>
	 <div class="container">
            <div class="header">
                <b>HR Home</b>
                
            </div>

            <br>
           <div style="text-align: right; margin-right: 5px;">
            <form action="logout" method="get">
                <b>Welcome : ${name}</b> &nbsp; <input type="submit" value="Logout" >
            </form>
        </div>
            <br>
            
            
            <div style="text-align: right;">
                <a href="add"><button type="submit" >Upload Employee Details</button> </a>  

                <a href="download"><button type="submit" >Download Employee Details</button> </a>  
            </div>
        
            <br>
            <table>
                <tr>
                    <th>Employee Code</th>
                    <th>Employee Name</th>
                    <th>Location</th>
                    <th>Email</th>
                    <th>Date Of Birth</th>
                    <th>Action</th>
                </tr>
                
                <c:forEach var="emp" items="${list}">
                    <tr>
                
	                    <td>${emp.getEcode()}  </td>
	                    
	                    <td> ${emp.getName()} </td>
	                    <td> ${emp.getLoc()}</td>
	                    
	                    <td>${emp.getEmail()}</td>
	                    <td>${emp.getDob()}</td>
	                    
	                    <td> <a href="edit?id=${emp.getEcode()}"> Edit</a>  </td>
                                       
                    </tr>  
                    
               
                </c:forEach>
                
            </table>


            <div class="header">
                
                
            </div>
        </div>
        
    </body>
</body>
</html>