package com.q6;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

class TestCalculator {
	
	private Calculator calculator = new Calculator();
	
	@ParameterizedTest
	@CsvFileSource(resources = "calc.csv", numLinesToSkip = 1)
	void calculatorTest(int test, int operand1, 
			String sign, int operand2, int exp)
	{
		
		calculator.switchOn();
		System.out.println(test + ". " + operand1 + " " + sign + " " + operand2 + " = " + exp);
		int result = 0;
		calculator.setValue(operand1);
		switch(sign) {
			case "+": 
				calculator.add(operand2);
				break;
			case "-": 
				calculator.minus(operand2);
				break;
			case "*": 
				calculator.multiply(operand2);
				break;
			case "/": 
				calculator.divide(operand2);
				break;
		}
		result = calculator.getValue();
		assertEquals(result, exp);
	}




	@Test
	void exceptionTest() 
	{
	calculator.add(1);
	var exception = assertThrows(ArithmeticException.class,  // lambda expression
			() -> {calculator.divide(0);});
	assertEquals("/ by zero", exception.getMessage());
	}
}
	

/* class TestCalculator
{
	private Calculator calc;
	
	@BeforeEach
	void setUp()
	{
		calc = new Calculator();
		calc.switchOn();
	}
	
	@ParameterizedTest
	@CsvFileSource(resources = "calc.csv", numLinesToSkip = 1)
	void ddtTest(int num, int op1, char sign, int op2, int exp)
	{
		calc.add(op1);
		switch(sign)
		{
			case '+' -> calc.add(op2);
			case '-' -> calc.subtract(op2);
			case '*' -> calc.multiply(op2);
			case '/' -> calc.division(op2);
		}
		assertEquals(exp, calc.getValue());
	}
} *///*