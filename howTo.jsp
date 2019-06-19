<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
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
#mainStuff
{
	background-color: #4e4e4e;
	width: 50%;
	position: relative;
	top: 2%;
	left: 25%;
}
img{
	width:98%;
	height:500px;
}
</style>
<meta charset="ISO-8859-1">
<title>Group 4 Final</title>
</head>
<body>
				<form action="index.jsp">
					<button id="homeButton" class="button" type="submit">Main Menu</button>
				</form>
<div id="mainStuff">
<img src="/final214/step0.PNG">
<br>
First, click "Start Playing" to access the game screen.

<br>
<img src="/final214/step1.PNG">
<br>
Click "Get Another Item" to get more items.

<br>
<img src="/final214/step2.PNG">
<br>
You can navigate through your items with the left and right buttons

<br>
<img src="/final214/step3.PNG">
<br>
You can toggle how your items are sorted between ascending and descending order
<br>
by clicking "Items".

<br>
<img src="/final214/step4.PNG">
<br>
You can return to the main menu at any time by clicking "Main Menu"
</div>
</body>
</html>