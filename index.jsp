<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="Web.Web,java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<%

Web w = new Web();
List<String> nameList = new ArrayList<String>();
int num = 0;
%>
<script type="text/javascript">
function addItem()
{
	nameList.add(w.genName());
	document.getElementById("list").innerHTML = w.displayItems(nameList);
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

<table>

<tr><td>Search:<form><input type="text" value="Enter Seach Here"></form></td></tr>

<tr><td>Here's a button to Generate another item<br><button onclick="increaseNumber">Generate New Item</button></td></tr>


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

<p id="list"></p>

</body>
</html>