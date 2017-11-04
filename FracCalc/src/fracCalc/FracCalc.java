package fracCalc;
import java.util.Scanner;
public class FracCalc
{
	public static void main(String[] args)
	{
		System.out.println("Type an expression: ");
		Scanner console = new Scanner(System.in);
		int count = 0;
		while (count < 1)
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
	
	public static String produceAnswer(String input)
	{
	// !!!! Checkpoint 1 stuff !!!! //
		int space = input.indexOf(" ");
		String operand = input.substring(0, space);	
		String operator = input.substring(space + 1, space + 3); 
		String operand2 = input.substring(space + 3, input.length());
		
		
	// !!!! Checkpoint 2 stuff !!!! //
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
		
		
		
	// !!!Checkpoint 3 stuff!!! //
		String result = null;
		//converting everything into a fraction Section
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
			if (operand2.indexOf("-") != -1) //checks if negative
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
		
		//actually doing the math Section
		int newnum;
		int newdenom;
		if (operator.indexOf("*") != -1) //multiplication 
		{
			newnum = op1w*op2w;
			newdenom = op1d*op2d;
			result = newnum + "/" + newdenom;
		}
		else if (operator.indexOf("/") != -1) //division 
		{
			newnum = op1w*op2d;
			newdenom = op1d*op2w; //ex: 22 / 2, newnum = 22*1, newdemon = 1*2 --> 22 / 2
			result = newnum + "/" + newdenom;
		}
		else if (operator.indexOf("+") != -1) //addition FIXED
		{
			newnum = ((op1w*op2d) + (op2w*op1d)); 
			newdenom = op1d*op2d; //lowest common denominator, example: 1/2 + 1/2 = (2+2)/4 = 4/4 
			result = newnum + "/" + newdenom;
		}
		else //subtraction
		{
			newnum = ((op1w*op2d) - (op2w*op1d)); //ex: 222 - 0 = ((222*1) - (0*1)) = 222
			newdenom = op1d*op2d; //lowest common denominator, example: 1/2 - 1/2 = (2-2)/4 = 0/4 = 0
			result = newnum + "/" + newdenom; 
		}
		
// !!!final checkpoint!!! //
		//if (Math.abs(newnum) < newdenom) //if numerator smaller than denominator
		//{
			//if (newnum == 0)
			//{
				//result = 0 + "";
			//}
			//return result;
		//}
		if (newnum < 0 && newdenom < 0)
		{
			newnum = Math.abs(newnum);
			newdenom = Math.abs(newdenom);
		}
		if (newnum == 0) //0 divided by anything
		{
			result = 0 + "";
			return result;
		}
		if (newdenom == 1) // just a whole number
		{
			return newnum + "";
		}
		if (newdenom % newnum == 0) // if something like -5/30 --> -1/6
		{
			newnum = newnum/newnum;
			newdenom = newdenom/newnum;
			return newnum + "/" + newdenom;
		}
		else
		{
			int whole = 0;
			if (newnum < 0) // if the new numerator is a negative
			{
				int n = Math.abs(newnum); //turns into positive temporarily
				while (n >= newdenom) //simplifying
				{
					whole++;
					n -= newdenom;
				}
				if (whole == 0)
				{ 
					return "-" + n + "/" + newdenom; //puts the negative back
				}
				else if (n == 0) 
				{
					return "-" + whole;
				}
				else
				{
					return "-"+ whole + "_" + n + "/" + newdenom; //puts the negative back
				}
			}
			else //if newnum is positive
			{
				while (newnum >= newdenom) //simplifying
				{
					whole++;
					newnum -= newdenom;
				}
				if (newnum == 0)
				{
					return whole + "";
				}
				else if (whole == 0)
				{
					return newnum + "/" + newdenom; 
				}
				else
				{
					return whole + "_" + newnum + "/" + newdenom; 
				}
			}
			
		}
	
		//POSSIBLE WRONG STUFF 
		//else if (newnum % newdenom == 0) //if there is no more to simplify
		//{
			//newnum = newnum/newdenom;
			//result = newnum + "";
			//return result;
		//}
		
		//else //if not simplified
		//{
			//op1w = newnum/newdenom;
			//op1d = newdenom;
			//op1n = Math.abs(newnum%newdenom);
			//result = op1w + "_" + op1n + "/" + op1d;
			
			//return result;
		//}
	}

	// TODO: Fill in the space below with any helper methods that you think you will need

}
