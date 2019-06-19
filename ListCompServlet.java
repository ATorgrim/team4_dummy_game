package com.web;

import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
@WebServlet("/ListCompServlet")
public class ListCompServlet extends HttpServlet
{
	int PageNumber;
	public void service(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException
	{
		HttpSession session = req.getSession();	
		int index = 0;
		String[] outArray = new String[10];
		Cookie cookies[] = req.getCookies();
		String[] inArray = new String[cookies.length];
		
		for(int i = 0; i<cookies.length; i++) //for ever item in cookies[]
		{
			if(cookies[i].getName().equals("Pg"))
			{
				PageNumber = Integer.parseInt(cookies[i].getValue());
			}
			else if(cookies[i].getName().equals("JSESSIONID"))
			{
			}
			else
			{
				String holder = cookies[i].getValue();
				String[] holderArray = holder.split("_");
				try 
				{
				holder = holderArray[0]+" "+holderArray[1];
				}
				catch(Exception e)
				{
					continue;
				}
				inArray[index] = holder;
				index++;
			}
		}
		String inString = String.valueOf(session.getAttribute("Order"));
		if(inString.equals("AlphaSort"))
		{
			Arrays.sort(inArray,Comparator.nullsLast(String.CASE_INSENSITIVE_ORDER));
		}
		else if(inString.equals("Reverse"))
		{
			for(int i = 0; i<inArray.length; i++)
			{
				if(inArray[i] == null)
				{
					inArray[i] = "*";
				}
			}
			Arrays.sort(inArray, Collections.reverseOrder());
		}
		for(int i = 0 + (10*PageNumber); i<10 + (10*PageNumber); i++) //fills outArray with 10 items, depending on what page it's on
		{
			try
			{
				String x = inArray[i]; //this just tests if i is in the range of indexes for inArray[]
			}
			catch(Exception e)
			{
				continue;
			}
			outArray[i - (10*PageNumber)] = inArray[i];
		}
		for(int i = 0; i<10; i++) //replaces null spots in outArray with * to mark an empty place
		{
			if(outArray[i] == null)
			{
				outArray[i] = "*";
			}
		}
		String out = "";
		for(int i = 0; i<10; i++)
		{
			out = out + "_" + outArray[i]; // name_name_name_...
		}
		RequestDispatcher rd = req.getRequestDispatcher("inventory.jsp");
		session.setAttribute("outArray", out);
		rd.forward(req, res);
	}
}
