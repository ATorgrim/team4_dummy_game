package com.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/SortListServlet")
public class SortListServlet extends HttpServlet {
	public void service(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException
	{	
		
		RequestDispatcher rd = req.getRequestDispatcher("ListCompServlet");
		HttpSession session = req.getSession();	
		if(session.getAttribute("Order") == null)
		{
			session.setAttribute("Order", "AlphaSort");
		}
		else if(session.getAttribute("Order").equals("Reverse"))
		{
			session.setAttribute("Order", "AlphaSort");
		}
		else if(session.getAttribute("Order").equals("AlphaSort"))
		{
			session.setAttribute("Order", "Reverse");
		}
		rd.forward(req, res);
	}
}
