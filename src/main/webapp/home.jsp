<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<link href="<c:url value="loancss.css" />" rel="stylesheet">
	<meta charset="ISO-8859-1">
	<br>
	<div class="container">
  		<img src="fss_img2.png" width = "100%" height = "400">
  		<div class="content">
   		<h1>LOAN REPAYMENT CALCULATOR &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp <a href="infodetails2.html"><img src="info.jpg" width="40" height="40" title="info" alt="info"></a></h1></div>
	</div>
</head>

<body bgcolor = "black" width = "100%">
<br>
<center><form method="post" action="/saveDetails"  align = "center">   
   <font face = "Georgia" size = "5" color = "grey"> How much would you like to borrow?  &nbsp </font><input type="number" name="lamount"><font face = "Georgia" size = "5" color = "grey">&nbsp &pound</font><br><br>
   <font face = "Georgia" size = "5" color = "grey"> Annual Interest Rate &nbsp</font><input type="number" name="annrate" step=".01"><font face = "Georgia" size = "5" color = "grey"> &nbsp %</font><br><br>
   <font face = "Georgia" size = "5" color = "grey">How long would you like to borrow it for? &nbsp</font><input type="number" name="lperiod"><font face = "Georgia" size = "5" color = "grey"> &nbsp months</font><br><br>
   <input type="image" src="submit2.png" value="Submit"  align="middle" width="80" height="30">
</form>
</center>
</body>
</html>