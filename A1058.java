package PTA;

import java.math.BigDecimal;
import java.util.Scanner;
//注意负数的情况
public class A1058 {
	public static boolean Palindromic(String num) {
		if(num.startsWith("-")){
			num = num.substring(1);
		}
		int len = num.length()-1;
		for (int i = 0; i < num.length()/2; i++) {
			if(num.charAt(i) != num.charAt(len-i)){
				return false;
			}
		}
		return true;
	} 
	public static String reversed(int n,int k,String num){
		if(k > n){
			return num+"\n"+n;
		}
		String s = "";
		if(num.startsWith("-")){
			s += "-";
			s += new StringBuilder(num.substring(1)).reverse().toString();
		}else{
			s += new StringBuilder(num).reverse().toString();
		}
		String sum = String.valueOf(new BigDecimal(s).add(new BigDecimal(num)));
		if(Palindromic(sum)){
			return sum +"\n"+ k;
		}else{
			return reversed(n,k+1, sum);
		}
	}
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String num = in.next();
		int n = in.nextInt();
		int k = 0;
		if(Palindromic(num)){
			System.out.println(num + "\n" + k);
			return ;
		}
		String sum = reversed(n, k+1, num);
		System.out.println(sum);
	}
}
