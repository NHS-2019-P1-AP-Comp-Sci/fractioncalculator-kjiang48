/**
 * @author Mr. Rasmussen
 */

package fracCalc;
import java.util.*;
public class FracCalc {
    public static void main(String[] args) {
    	String cool = "";
    	Scanner input = new Scanner(System.in);
        String total = input.nextLine();
        int quitTest = total.indexOf("quit");
        while (quitTest == -1) {
        	cool = produceAnswer(total);
        	total = input.nextLine();
        	quitTest = total.indexOf("quit");
        }       
    }
    
    public static String produceAnswer(String input) {
        // TODO: Implement this function to produce the solution to the input
    	String finish = "";
    	int function = input.indexOf(" ");
    	String operator = input.substring(function + 1, function + 2);
    	String secondFrac = input.substring(function + 3);
    	String firstFrac = input.substring(0, function);
    	int wholeNum1 = findingWholeNum(firstFrac);
    	int num1 = findingNum(firstFrac, wholeNum1);
    	int denom1 = findingDenom(firstFrac);
    	int wholeNum2 = findingWholeNum(secondFrac);
    	int num2 = findingNum(secondFrac, wholeNum2);
    	int denom2 = findingDenom(secondFrac);
    	if (operator.indexOf("+") != -1) {
    		finish = add(wholeNum1, num1, denom1, wholeNum2, num2, denom2);
    	}
    	else if (operator.indexOf("-") != -1) {
    		finish = subtract(wholeNum1, num1, denom1, wholeNum2, num2, denom2);
    	}
    	else if (operator.indexOf("*") != -1) {
    		finish = multiply(wholeNum1, num1, denom1, wholeNum2, num2, denom2);
    	}
    	else {
    		finish = divide(wholeNum1, num1, denom1, wholeNum2, num2, denom2);
    	}
        return finish;
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
    public static int findingNum(String input, int num) {
    	int findingFrac = findingFrac(input);
    	int findWholeNum = input.indexOf("_");
    	int neg = input.indexOf("-");
    	String numerator = "";
    	if (findingFrac != -1) {
    		numerator = input.substring(findWholeNum +1, findingFrac);
    	}
    	else {
    		numerator = "0";
    	}
    	int cool = Integer.parseInt(numerator);
    	if (neg != -1 && num != 0) {
    		cool = cool * -1;
    	}
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
    public static String format(int num3, int n3, int d3) {
    	String cool = "";
    	if (d3 == 1) {
    		num3 = n3 + num3;
    		n3 = 0;
    	}
 //   	num3 = num3 + (n3%d3);
    	
    	if (n3 < 0 && num3 < 0) {
    		n3 = n3 * -1;
    	}
    	if (n3 != 0 && num3 != 0) {
    		cool = num3 + "_" + n3 + "/" + d3;
    	}
    	else if (num3 != 0 && n3 == 0) {
    		cool = "" + num3;
    	}
    	else if (n3 == 0 && num3 == 0) {
    		cool = "" + 0;
    	}
    	else if (num3 == 0 && n3 != 0){
    		cool = n3 + "/" + d3;
    	}
    	
    	return cool;
    }
    public static String subtract(int num1, int n1, int d1, int num2, int n2, int d2) {
    	int num3 = num1 - num2;
    	n1 = n1 * d2;
    	n2 = n2 * d1;
    	int d3 = d1 * d2;
    	int n3 = n1 - n2;
    	String cool = format(num3, n3, d3);
    	return cool;
    }
    public static String add(int num1, int n1, int d1, int num2, int n2, int d2) {
    	int num3 = num1 + num2;
    	n1 = n1 * d2;
    	n2 = n2 * d1;
    	int d3 = d1 * d2;
    	int n3 = n1 + n2;
    	String cool = format(num3, n3, d3);
    	return cool;
    }
    public static String multiply(int num1, int n1, int d1, int num2, int n2, int d2) {
    	num1 = (num1 * d1) + n1;
    	num2 = (num2 * d2) + n2;
    	int num3 = num1 * num2;
    	int denom3 = d1 * d2;
    	String cool = format(0, num3, denom3);
    	return cool;
    }
    public static String divide(int num1, int n1, int d1, int num2, int n2, int d2) {
    	num1 = (num1 * d1) + n1;
    	num2 = (num2 * d2) + n2;
    	int num3 = num1 * d2;
    	int denom3 = num2 * d1;
    	String cool = format(0, num3, denom3);
    	return cool;
    }
    
}
