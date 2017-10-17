package fracCalc;
import java.util.Scanner;
public class FracCalc
{
	public static void main(String[] args)
	{
		// TODO: Read the input from the user and call produceAnswer
		// with that input, printing the result
		int count = 1;
		Scanner console = new Scanner(System.in);
		while (count > 0) //while Statements, then exit when user types "quit"
		{
			String input = console.nextLine();
			if (!input.equals("quit"))
			{
				System.out.println(produceAnswer(input));
			}
			else
			{
				count = 0;
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
		// TODO: Implement this method to produce and return the solution to the input
		// produceAnswer breaks up that line of input into three Strings
		// the first operand (fraction), the operator (+ - * /), and the second operand (fraction).
		// Each of these Strings should be stored in variables inside produceAnswer.  
		
		//Checkpoint 1 stuff
		int space = input.indexOf(" ");
		String operand = input.substring(0, space+1);	
		String operator = input.substring(space + 1, space + 3); 
		String operand2 = input.substring(space + 3, input.length());
		
		//Checkpoint 2 stuff
		
		//operand1 section
		if (operand.indexOf("_") > -1) //if mixed fraction
		{
			int op1w = 0;
			int op1n = Integer.parseInt(operand.substring(0));
			int op1d = 0;
		}
		else if (operand.indexOf("_") == -1 && operand.indexOf("/") != 0) //if the format is like: 10/4, not a mixed fraction
		{
			int slash = operand.indexOf("/");
			int op1w = 0;
			int op1n = Integer.parseInt(operand.substring(0));
			int op1d = 0;
		}
		else //first operand if only whole number
		{
			int op1w = Integer.parseInt(operand); //operand1's whole number
			int op1n = 0;
			int op1d = 0;
		}
		return operand2;
	}

	// TODO: Fill in the space below with any helper methods that you think you will need

}
