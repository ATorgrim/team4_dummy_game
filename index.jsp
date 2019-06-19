<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="com.web.Webber,java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<style>
body 
{
	background-image: url("/final214/background.png");
	color: #eaeaea;
	text-align:center;
}
#menu 
{
	width: 500px;
	background-color: #363636;
}
#menu menu-item
{
	display: block;
	text-align: center;
	padding: 20px;
	transition: 0.3s;
	color: white;
	font-size: 40px;
}
#menu form:hover 
{
	background-color: #dc6800;
}
button
{
    height:40px; 
    width:100%; 
}
.button {
  background-color: #363636; 
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
  background-color: #dc6800;
  width: 110%;
  color: #ffbba6;

</style>
<meta charset="ISO-8859-1">
<title>Group 4 Final</title>
</head>
<body>
	<div id="menu">
		<div id="menu-item">
			<form action="AddPageNumServlet">
				<button class="button" type="submit">Start Playing</button>
			</form>
		</div>
		<div id="menu-item">
			<form action="credits">
						<button class="button" type="submit">Credits</button>
			</form>
		</div>
		<div id="menu-item">
			<form action="factorialCalc.jsp">
				<button class="button" type="submit">Factorial Calculator</button>
			</form>
		</div>
		<div id="menu-item">
			<form action="howTo.jsp">
				<button class="button" type="submit">How To Play</button>
			</form>
		</div>
	</div>
</body>
</html>