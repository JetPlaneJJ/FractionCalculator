package fracCalc;
import java.util.Scanner;
public class FracCalc
{
	public static void main(String[] args)
	{
		// TODO: Read the input from the user and call produceAnswer
		// with that input, printing the result
		Scanner console = new Scanner(System.in);
		String input = console.nextLine();
		System.out.println(produceAnswer(input));
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
	
	public static int produceAnswer(String input)
	{
		// TODO: Implement this method to produce and return the solution to the input
		// produceAnswer breaks up that line of input into three Strings
		// the first operand (fraction), the operator (+ - * /), and the second operand (fraction).
		// Each of these Strings should be stored in variables inside produceAnswer.  
		String operand = input.substring(0, 3);
		String operator = input.substring(3, 4);
		String operand2 = input.substring(4, 6);
		int result = Integer.parseInt(operand);
		return result;
	}

	// TODO: Fill in the space below with any helper methods that you think you will need

}
