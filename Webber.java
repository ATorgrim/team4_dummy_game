package com.web;
import java.util.*;
public class Webber 
{
	static Items item = new Items();
	public static int num;
	
	public static int add(int x, int y)
	{
		return x + y;
	}
	public static int multiply(int a, int b)
	{
		return a*b;
	}
	public static String genName()
	{
		return item.name();
	}
	
	//This method isn't in use rn
	public static List<String> addToNameList(List<String> inputList)
	{
		inputList.add(item.name());
		return inputList;
	}
	
	public String testNameList(List<String> inputList,int testindex)
	{
		if(testindex < inputList.size())
		{
			return inputList.get(testindex);
		}
		return "";
	}
	
	public String displayItems(List<String> inputList)
	{
		String out = String.format("%s%n%s%n%s%n%s%n%s%n%s%n%s%n%s%n%s%n%s",
				testNameList(inputList,0),
				testNameList(inputList,1),
				testNameList(inputList,2),
				testNameList(inputList,3),
				testNameList(inputList,4),
				testNameList(inputList,5),
				testNameList(inputList,6),
				testNameList(inputList,7),
				testNameList(inputList,8),
				testNameList(inputList,9)
				);
		return out;
	}
	
	public int increaseNumber()
	{
		num++;
		System.out.println(num);
		return num;
	}
	
	public Webber()
	{
		this.num = 0;
	}
	public static void setNum(int input) 
	{
		num = input;
	}
	public static int getNum()
	{
		return num;
	}

}
