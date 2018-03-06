package PTA;

import java.util.Scanner;

public class A1049 {
	public static void main(String[] args) {
		String []symbol = {"zero","one","two","three","four","five","six","seven","eight","nine"};
		Scanner scanner = new Scanner(System.in);
		String nums = scanner.next();
		int s = 0;
		for (int i = 0; i < nums.length(); i++) {
			int num = nums.charAt(i)-'0';
			s += num;
		}
		String sum = String.valueOf(s);
		for (int i = 0; i < sum.length(); i++) {
			System.out.print(symbol[sum.charAt(i)-'0']);
			if(i != sum.length()-1){
				System.out.print(" ");
			}
		}
	}
}
