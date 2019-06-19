package com.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/factorialCalcServlet")
public class factorialCalcServlet extends HttpServlet 
{
	public void service(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException
	{
		HttpSession session = req.getSession();	
		int i = Integer.parseInt(req.getParameter("inValue"));
		FactorialCalc x = new FactorialCalc();
		session.setAttribute("Factorial", x.calcFac(i));
		res.sendRedirect("factorialCalc.jsp");
	}
}
