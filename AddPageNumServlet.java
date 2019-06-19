package com.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/AddPageNumServlet")
public class AddPageNumServlet extends HttpServlet 
{
	public void service(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException
	{	
		int PageNumber = 0;
		Cookie cookies[] = req.getCookies();
		for(int i = 0; i<cookies.length; i++)
		{
			if(cookies[i].getName().equals("Pg"))
			{
				PageNumber = Integer.parseInt(cookies[i].getValue());
				PageNumber++;
				break;
			}
			else
			{
				PageNumber = 0;
			}
		}
		Cookie cookie = new Cookie("Pg", Integer.toString(PageNumber));
		res.addCookie(cookie);
		res.sendRedirect("ListCompServlet");
	}
}
