package com.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Cookie;

@WebServlet("/ItemButtonServlet")
public class ItemButtonServlet extends HttpServlet
{
	public void service(HttpServletRequest req, HttpServletResponse res) throws IOException
	{
		Items item = new Items();
		String name = item.name();
		String [] arrOfname = name.split(" "); 
		String cookieName = arrOfname[0] + "_" + arrOfname[1];
		Cookie cookie = new Cookie(cookieName, cookieName);
		res.addCookie(cookie);
		res.sendRedirect("inventory.jsp");
	}
}
