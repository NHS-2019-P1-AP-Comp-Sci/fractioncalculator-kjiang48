/**
 * @author Mr. Rasmussen
 */

package fracCalc;
import java.util.*;
public class FracCalc {
    public static void main(String[] args) {
    	// This is the method which takes in user input and checks for quit to leave the program.
    	String cool = "";
    	Scanner input = new Scanner(System.in);
        String total = input.nextLine();
        int quitTest = total.indexOf("quit");
        while (quitTest == -1) {
        	cool = produceAnswer(total);
        	System.out.println(cool);
        	total = input.nextLine();
        	quitTest = total.indexOf("quit");
        }       
    }
    public static String produceAnswer(String input) {
    	// This is the method that checks for the operator and returns the answer.
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
    	// This is the method that finds and parses the whole number of a mixed fraction.
    	int findWholeNum = input.indexOf("_");
    	int findingFrac = input.indexOf("/");
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
    public static int findingNum(String input, int num) {
    	// This is the method that finds and parses the numerator of the fraction.
    	int findingFrac = input.indexOf("/");
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
    	// This is the method that finds and parses the denominator of the fraction.
    	int findingFrac = input.indexOf("/");
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
    	// This is the method that formats the fractions after the answers have been produced. It also reduces the fractions.
    	String cool = "";
    	int m = n3/d3;
    	num3 = m + num3;
    	n3 = n3 % d3;
    	int factor = gcd(n3,d3);
    	int c = Math.abs(factor);
    	n3 = n3/c;
    	d3 = d3/c;
    	if (d3 == 1) {
    		num3 = n3 + num3;
    		n3 = 0;
    	}
    	if (n3 < 0 && d3 < 0) {
    		n3 = n3 * -1;
    		d3 = d3 * -1;
    	}
    	if (n3 < 0 && num3 < 0) {
    		n3 = n3 * -1;
    	}
    	
    	if (num3 < 0 && d3 < 0) {
    		d3 *= -1;
    	}
    	
    	if (n3 > 0 && d3 < 0) {
    		n3 *= -1;
    		d3 *= -1;
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
    	// This is the method that subtracts the two fractions.
    	int num3 = num1 - num2;
    	n1 = n1 * d2;
    	n2 = n2 * d1;
    	int d3 = d1 * d2;
    	int n3 = n1 - n2;
    	int c = n3/d3;
    	if (num3 < 0 && c >= 0) {
    		num3 = num3 * d3;
    		n3 = n3 + num3;
    		num3 = 0;
    	}
    	String cool = format(num3, n3, d3);
    	return cool;
    }
    public static String add(int num1, int n1, int d1, int num2, int n2, int d2) {
    	// This is the method that adds the two fractions.
    	int num3 = num1 + num2;
    	n1 = n1 * d2;
    	n2 = n2 * d1;
    	int d3 = d1 * d2;
    	int n3 = n1 + n2;
    	String cool = format(num3, n3, d3);
    	return cool;
    }
    public static String multiply(int num1, int n1, int d1, int num2, int n2, int d2) {
    	// This is the method that multiplies the two fractions.
    	num1 = (num1 * d1) + n1;
    	num2 = (num2 * d2) + n2;
    	int num3 = num1 * num2;
    	int denom3 = d1 * d2;
    	String cool = format(0, num3, denom3);
    	return cool;
    }
    public static String divide(int num1, int n1, int d1, int num2, int n2, int d2) {
    	// This is the method that divides the two fractions.
    	num1 = (num1 * d1) + n1;
    	num2 = (num2 * d2) + n2;
    	int num3 = num1 * d2;
    	int denom3 = num2 * d1;
    	String cool = format(0, num3, denom3);
    	return cool;
    }
    public static int gcd(int a, int b) {
    	// This is the method that finds the greatest common denominator of the fraction so they can be reduced.
    	if (a == 0)  
	        return b;return gcd(b%a, a);  
    }
}