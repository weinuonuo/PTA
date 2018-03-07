package pat201712;

import java.math.BigInteger;
import java.util.Scanner;
//令人窒息的操作，输出的时候两个数顺序搞反了
//回文数，一个数的倒置等于原来的数
public class A1136 {
	public static boolean Palindrome(String num){
		int len = num.length()-1;
		for (int i = 0; i*i < num.length(); i++) {
			if(num.charAt(i) != num.charAt(len-i)){
				return false;
			}
		}
		return true;
	}
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String num = in.next();
		for(int i = 0; i < 10; i++){
			if(num.equals(new StringBuilder(num).reverse().toString())){
				System.out.println(num+" is a palindromic number.");
				return ;
			}else{
				BigInteger num1 = new BigInteger(new StringBuilder(num).reverse().toString());
				BigInteger num2 = new BigInteger(num);
				BigInteger sum = num1.add(num2);
				System.out.println(num2+" + "+num1+" = "+sum);
				num = sum.toString();
			}
		}
		System.out.println("Not found in 10 iterations.");
		return ;
	}
}
