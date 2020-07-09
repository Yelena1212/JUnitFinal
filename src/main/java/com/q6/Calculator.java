package com.q6;

public class Calculator
{
	private int value;
	
	public void switchOn()
	{
		value = 0;
	}
	
	public void add(int a)
	{
		value += a;
	}
	
	
	public void setValue(int value) {
		this.value = value;
	}

	public void minus(int a)
	{
		value -= a;
	}
	
	
	public void multiply(int a)
	{
		value *= a;
	}
	
	
	public void divide(int a)
	{
		value /= a;
	}
	
	

	public int getValue() {
		return value;
	}
}
