<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="Web.Web,java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<%
Web w = new Web();
List<String> nameList = new ArrayList<String>();
%>

<script>
var x = new Web()
function addNumber()
{
	x.num++;
	document.getElementById('number').innerHTML = 'litterly any result';
}
</script>

<style>
body {
	background-color: #383838;
	color: #eaeaea;
}
table {
	background-color: #7b7b7b;
	hight: 100%;
	width: 35%;
	padding-bottom: 100%;
}
</style>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<button onclick="addNumber()">Increase Number</button>
<p><output id="number"></output></p>

<table>

<tr><td>Search:<form><input type="text" value="Enter Seach Here"></form></td></tr>

<tr><td>Here's a button to Generate another item<br></td></tr>

<tr><td></td></tr>
<tr><td><%=w.testNameList(nameList,0)%></td></tr>
<tr><td><%=w.testNameList(nameList,1)%></td></tr>
<tr><td><%=w.testNameList(nameList,2)%></td></tr>
<tr><td><%=w.testNameList(nameList,3)%></td></tr>
<tr><td><%=w.testNameList(nameList,4)%></td></tr>
<tr><td><%=w.testNameList(nameList,5)%></td></tr>
<tr><td><%=w.testNameList(nameList,6)%></td></tr>
<tr><td><%=w.testNameList(nameList,7)%></td></tr>
<tr><td><%=w.testNameList(nameList,8)%></td></tr>
<tr><td><%=w.testNameList(nameList,9)%></td></tr>

</table>

</body>
</html>