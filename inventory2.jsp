<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.Arrays,javax.servlet.http.HttpServletResponse,javax.servlet.http.HttpServletRequest,javax.servlet.http.HttpServlet"%>
<!DOCTYPE html>
<html>
<head>
<% 
String inString = String.valueOf(session.getAttribute("outArray"));
String[] displayArray = inString.split("_");
for(int i = 0; i<10; i++) //change empty values represented by *s into ""
{
	if(displayArray[i].equals("*"))
	{
		displayArray[i] = "";
	}
}
%>
<style>
body
{
	background-image: url("/final214/invbackground.png");
	color: #eaeaea;
	text-align:center;
}
table
{
	width: 30%
}
td
{
	background-color: #969696;
	color: black;
	width: 30%;
	text-align:center;
	transition: 0.3s;
}
#left
{
	width: 30%;
	padding-bottom: 175px;
	float: left;
}
#right
{
	width: 70%;
	float: left;
}
#bigButton
{
	position: fixed;
	width: 300px;
	height: 300px;
	top: 40%;
	left: 60%;
	background-color: #ff9600;
	color: white;
}
#bigButton:hover
{
	border-radius: 150px;
	background-color: #19ff90;
	color: #29b371;
}
#bigButton:active
{
  	border-radius: 50px;
  	background-color: #09ab5d;
 	color: #19ff90;
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
td:hover
{
	background-color: #d97f3c;
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
#pgButtonL
{
	padding-top: 5px;
	position: fixed;
	bottom: 0%;
	left: 0%;
	width: 250px;
	background-color: #363636;
	transition: 0.3s;
}
#pgButtonL:hover 
{
	background-color: #00ff84;
	color: white;
}
#pgButtonR
{
	padding-top: 5px;
	position: fixed;
	bottom: 0%;
	left: 250px;
	width: 250px;
	width: 250px;
	background-color: #363636;
	transition: 0.3s;
}
#pgButtonR:hover 
{
	background-color: #00ff84;
	color: white;
}
#itemList
{
	width: 500px;
	background-color: #363636;
}
#itemList-item
{
	display: block;
	text-align: center;
	padding: 10px;
	transition: 0.3s;
	color: white;
	font-size: 40px;
}
#itemList-head
{
	display: block;
	text-align: center;
	padding: 20px;
	background-color: #ff9600;
	transition: 0.3s;
	color: white;
	font-size: 30px;
}
#itemList-item:hover 
{
	background-color: #ffac36;
}
#itemList-item:active
{
	background-color: #00ff84;
}
#itemList-head:hover 
{
	background-color: #00ff84;
}
#ItemText
{
	color: white;
	font-size: 30px;
	text-decoration: none;
}
</style>
<meta charset="ISO-8859-1">
<title>Group 4 Final</title>
</head>
<body>
<div id="left">
<div id="itemList">
	<div id="itemList-head">
		<A id="ItemText" HREF="SortListServlet">Items</A>
	</div>
	<div id="itemList-item">
		<%=displayArray[0]%>
	</div>
	<div id="itemList-item">
		<%=displayArray[1]%>
	</div>
	<div id="itemList-item">
		<%=displayArray[2]%>
	</div>
	<div id="itemList-item">
		<%=displayArray[3]%>
	</div>
	<div id="itemList-item">
		<%=displayArray[4]%>
	</div>
	<div id="itemList-item">
		<%=displayArray[5]%>
	</div>
	<div id="itemList-item">
		<%=displayArray[6]%>
	</div>
	<div id="itemList-item">
		<%=displayArray[7]%>
	</div>
	<div id="itemList-item">
		<%=displayArray[8]%>
	</div>
	<div id="itemList-item">
		<%=displayArray[9]%>
	</div>
	<div>
	<form class="example" action="SearchListServlet">// attempt to create a search bar
  <input type="text" placeholder="Search.." name="search">
  <button type="submit"><i class="fa fa-search"></i></button>
</form>
	</div>
      <%
         Cookie cookie = null;
      	Cookie shoop = null;
         Cookie[] cookies = null;
         Cookie[] shoops = null;
         
         // Get an array of Cookies associated with the this domain
         cookies = request.getCookies();
         shoops = request.getCookies();
         if( cookies != null ) {
            out.println("<h2> Found Cookies Name and Value</h2>");
            
            for (int i = 0; i < 1; i++) {// displays the page number
                shoop = shoops[i];
                out.print(shoop.getName( ) + ".  ");
                out.print(shoop.getValue( )+" <br/>");
             }
            
            for (int i = 1; i < cookies.length; i++) {// displays all cookies(items) that have been generated, regardless of page
               cookie = cookies[i];
               out.print("Name : " + cookie.getName( ) + ",  ");
               out.print("Value: " + cookie.getValue( )+" <br/>");
            }// the intent was to have the search bar eliminate cookies that don't have the input from the display.
         } else {
            out.println("<h2>No cookies founds</h2>");
         }
      %>
</div>

				<form action="AddItemServlet">
					<button id="bigButton" class="button" type="submit">Get Another Item</button>
				</form>
				<form action="index.jsp">
					<button id="homeButton" class="button" type="submit">Main Menu</button>
				</form>
		<form action="SubPageNumServlet">
			<button id="pgButtonL" class="button" type="submit">Left</button>
		</form>
		<form action="AddPageNumServlet">
			<button id="pgButtonR" class="button" type="submit">Right</button>
		</form>
</div>
</body>
</html>
