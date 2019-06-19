<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<%
session = request.getSession();
String result = String.valueOf(session.getAttribute("Factorial"));
%>
<style>
body 
{
	background-color: #2f2f2f;
	color: #eaeaea;
	text-align:center;
}
#homeButton
{
	position: fixed;
	width: 10%;
	height: 5%;
	top: 0%;
	right: 0%;
	padding-top: 0px;
	font-size: 18px;
	background-color: #585858;
}
#homeButton:hover
{
	background-color: #c60000;
	color: #f95151;
}
button
{
    height:40px; 
    width:100%; 
}
.button {
  background-color: #bdbdbd; 
  border: none;
  color: white;
  padding: 40px 40px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 25px;
  transition: 0.3s;
}
button:hover {
  background-color: #ff5f2e;
  color: #ffbba6;
}
#subButton {
  background-color: #363636; 
  border: none;
  color: white;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 25px;
  transition: 0.3s;
}
#subButton:hover {
  background-color: #ff5f2e;
  color: #ffbba6;
}
#result
{
	position: relative;
	color:white;
	background-color: #363636;
	top: 50%;
	left: 0%;
	font-size: 30px;
	  transition: 0.3s;
}
#result:hover
{
	background-color: #19ff90;
	color: #29b371;
}
</style>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="factorialCalcServlet">
		<button id="subButton" type="submit" value="1" name="inValue">!1</button>
	</form>
	<form action="factorialCalcServlet">
		<button id="subButton"type="submit" value="2" name="inValue">!2</button>
	</form>
	<form action="factorialCalcServlet">
		<button id="subButton"type="submit" value="3" name="inValue">!3</button>
	</form>
	<form action="factorialCalcServlet">
		<button id="subButton"type="submit" value="4" name="inValue">!4</button>
	</form>
	<form action="factorialCalcServlet">
		<button id="subButton"type="submit" value="5" name="inValue">!5</button>
	</form>
	<form action="factorialCalcServlet">
		<button id="subButton"type="submit" value="6" name="inValue">!6</button>
	</form>
	<form action="factorialCalcServlet">
		<button id="subButton"type="submit" value="7" name="inValue">!7</button>
	</form>
	<form action="factorialCalcServlet">
		<button id="subButton"type="submit" value="8" name="inValue">!8</button>
	</form>
	<form action="factorialCalcServlet">
		<button id="subButton"type="submit" value="9" name="inValue">!9</button>
	</form>
	<div id="result">
		Result: <%=result%>
	</div>
	<form action="index.jsp">
					<button id="homeButton" class="button" type="submit">Main Menu</button>
				</form>
</body>
</html>