package com.web;

public class FactorialCalc {
	int calcFac(int x)
	{
		if(x == 1)
		{
			return x;
		}
		else {
			return x * calcFac(x-1);
		}
	}
}
