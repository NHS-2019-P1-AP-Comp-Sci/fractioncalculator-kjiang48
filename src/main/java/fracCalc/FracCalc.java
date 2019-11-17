/**
 * @author Mr. Rasmussen
 */

package fracCalc;
import java.util.*;
public class FracCalc {
    public static void main(String[] args) {
    	String secondFrac = "";
    	Scanner input = new Scanner(System.in);
        String total = input.nextLine();
        int quitTest = total.indexOf("quit");
        while (quitTest == -1) {
        	secondFrac = produceAnswer(total);
        	System.out.println(secondFrac);
        	total = input.nextLine();
        	quitTest = total.indexOf("quit");
        }        
        
    }

    // ** IMPORTANT ** DO NOT DELETE THIS FUNCTION.  This function will be used to test your code
    // This function takes a String 'input' and produces the result
    //
    // input is a fraction string that needs to be evaluated.  For your program, this will be the user input.
    //      e.g. input ==> "1/2 + 3/4"
    //
    // The function should return the result of the fraction after it has been calculated
    //      e.g. return ==> "1_1/4"
    
    
    
    public static String produceAnswer(String input) {
        // TODO: Implement this function to produce the solution to the input
    	String totalAdded2 = "";
    	int function = input.indexOf(" ");
    	String secondFrac = input.substring(function + 3);
    	String firstFrac = input.substring(0, function);
    	int wholeNum1 = findingWholeNum(firstFrac);
    	int num1 = findingNum(firstFrac);
    	int denom1 = findingDenom(firstFrac);
    	int wholeNum2 = findingWholeNum(secondFrac);
    	int num2 = findingNum(secondFrac);
    	int denom2 = findingDenom(secondFrac);
    	totalAdded2 = "whole:" + wholeNum2 + " numerator:"+ num2 + " denominator:" +denom2;
        return totalAdded2;
    }
    public static int findingWholeNum(String input) {
    	int findWholeNum = input.indexOf("_");
    	int findingFrac = findingFrac(input);
    	String wholeNum = "";
    	if (findWholeNum != -1) {
    		wholeNum = input.substring(0, findWholeNum);
    	}
    	else if (findingFrac == -1){
    		wholeNum = input;
    	}
    	else {
    		wholeNum = "0";
    	}
    	int cool = Integer.parseInt(wholeNum);
    	return cool;
    }
    public static int findingFrac(String input) {
    	int frac = input.indexOf("/");
    	return frac;
    }
    
    public static int findingNum(String input) {
    	int findingFrac = findingFrac(input);
    	int findWholeNum = input.indexOf("_");
    	String numerator = "";
    	if (findingFrac != -1) {
    		numerator = input.substring(findWholeNum +1, findingFrac);
    	}
    	else {
    		numerator = "0";
    	}
    	int cool = Integer.parseInt(numerator);
    	return cool;
    }
    public static int findingDenom(String input) {
    	int findingFrac = findingFrac(input);
    	String denominator = "";
    	if (findingFrac != -1) {
    		denominator = input.substring(findingFrac + 1);
    	}
    	else {
    		denominator = "1";
    	}
    	int cool = Integer.parseInt(denominator);
    	return cool;
    }
    // TODO: Fill in the space below with any helper methods that you think you will need
}
