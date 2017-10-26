package fracCalc;
import java.util.Scanner;
public class FracCalc
{
	public static void main(String[] args)
	{
		System.out.println("Type an expression: ");
		Scanner console = new Scanner(System.in);
		for (int count = 0; count < 1; count--)
		{
			String input = console.nextLine();
			if (input.equals("quit"))
			{
				count = 2;
			}
			else
			{
				System.out.println(produceAnswer(input));
			}
		}
		return;
	}
	// ** IMPORTANT ** DO NOT DELETE THIS METHOD.
	// ** IMPORTANT ** DO NOT CHANGE THE SIGNATURE OF THIS METHOD.
	// 
	// This method will be used to test your code.  It takes a String parameter
	// and RETURNS (not prints) the result
	//
	// Parameter is a fraction string that needs to be evaluated.  For your program, this will be
	// the user input obtained by main.
	//      e.g. input ==> "1/2 + 3/4"
	//        
	// The method should return the result of the fraction after it has been calculated
	//      e.g. return ==> "1_1/4"
	
	public static String produceAnswer(String input)
	{
		// !!!! Checkpoint 1 stuff !!!!
		int space = input.indexOf(" ");
		String operand = input.substring(0, space);	
		String operator = input.substring(space + 1, space + 3); 
		String operand2 = input.substring(space + 3, input.length());
		
		
		
		
		// !!!! Checkpoint 2 stuff !!!!
		//operand1 section
		int op1w; 
		int op1n;
		int op1d;
		if (operand.indexOf("_") > 0) //if mixed fraction
		{
			op1w = Integer.parseInt(operand.substring(0, operand.indexOf("_")));
			op1n = Integer.parseInt(operand.substring(operand.indexOf("_") + 1, operand.indexOf("/")));
			op1d = Integer.parseInt(operand.substring(operand.indexOf("/") + 1, operand.length()));
		}
		else if (operand.indexOf("_") == -1 && operand.indexOf("/") > 0) //if the format is like: 10/4, not a mixed fraction
		{
			int slash = operand.indexOf("/");
			op1w = 0;
			op1n = Integer.parseInt(operand.substring(0, slash));
			op1d = Integer.parseInt(operand.substring(slash + 1, operand.length()));
		}
		else //first operand if only whole number
		{
			op1w = Integer.parseInt(operand); //operand1's whole number
			op1n = 0;
			op1d = 1;
		}
		//operand2 section
		int op2w;
		int op2n;
		int op2d;
		if (operand2.indexOf("_") > 0) //if mixed fraction
		{
			op2w = Integer.parseInt(operand2.substring(0, operand2.indexOf("_")));
			op2n = Integer.parseInt(operand2.substring(operand2.indexOf("_") + 1, operand2.indexOf("/")));
			op2d = Integer.parseInt(operand2.substring(operand2.indexOf("/") + 1, operand2.length()));
		}
		else if (operand2.indexOf("_") == -1 && operand2.indexOf("/") > 0) //if the format is like: 10/4, not a mixed fraction
		{
			int slash = operand2.indexOf("/");
			op2w = 0;
			op2n = Integer.parseInt(operand2.substring(0, slash));
			op2d = Integer.parseInt(operand2.substring(slash + 1, operand2.length()));
		}
		else //second operand if only whole number
		{
			op2w = Integer.parseInt(operand2); //operand2's whole number
			op2n = 0;
			op2d = 1;
		}
		String op2result = "whole:" + op2w + " numerator:" + op2n + " denominator:" + op2d;
		
		
		
		// !!!Checkpoint 3 stuff!!!
					//TODO: negative mixed fractions are failing...
		String result = null;
		if (operand.indexOf("_") != -1) //if operand1 is mixed fraction
		{
			if (operand.indexOf("-") != -1) //checks if it is a negative
			{
				op1w = ((op1w*op1d)*-1 + op1n) * -1; 
			}
			else
			{
				op1w = op1w*op1d + op1n;
			}
		}
		else if (operand.indexOf("/") != -1) //if op1 is fraction
		{
			op1w = op1n;
		}
		
		if (operand2.indexOf("_") != -1) //if op2 is mixed fraction
		{
			if (operand2.indexOf("-") != -1)
			{
				op2w = ((op2w*op2d)*-1 + op2n) * -1;
			}
			else
			{
				op2w = op2w*op2d + op2n; 
			}
		}
		else if (operand2.indexOf("/") != -1) //if op2 is just a fraction
		{
			op2w = op2n;
		}
		
		if (operator.indexOf("*") != -1) //multiplication FIXED
		{
			int newnum = op1w*op2w;
			int newdenom = op1d*op2d;
			result = newnum + "/" + newdenom;
		}
		else if (operator.indexOf("/") != -1) //division FIXED
		{
			int newnum = op1w*op2d;
			int newdenom = op1d*op2w; //ex: 22 / 2, newnum = 22*1, newdemon = 1*2 --> 22 / 2
			result = newnum + "/" + newdenom;
		}
		else if (operator.indexOf("+") != -1) //addition FIXED
		{
			int newnum = ((op1w*op2d) + (op2w*op1d)); 
			int newdenom = op1d*op2d; //lowest common denominator, example: 1/2 + 1/2 = (2+2)/4 = 4/4 
			result = newnum + "/" + newdenom;
		}
		else //subtraction
		{
			int newnum = ((op1w*op2d) - (op2w*op1d)); //ex: 222 - 0 = ((222*1) - (0*1)) = 222
			int newdenom = op1d*op2d; //lowest common denominator, example: 1/2 - 1/2 = (2-2)/4 = 0/4 = 0
			result = newnum + "/" + newdenom; 
		}
		
		return result;
		
	}

	// TODO: Fill in the space below with any helper methods that you think you will need

}
