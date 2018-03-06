package PTA;

import java.util.Scanner;

public class A1048 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int num1 = scanner.nextInt();
		int num2 = scanner.nextInt();
		String sum = String.valueOf(num1 + num2);
		int index = 0;
		StringBuffer sumsb = new StringBuffer();
		for (int i = sum.length()-1; i >= 0 ; i--) {
			index ++;
			sumsb.insert(0, sum.charAt(i));
			if(index == 3 && i != 0 ){
				if(sum.charAt(i-1) != '-'){
					index = 0;
					sumsb.insert(0, ",");
				}
			}
		}
		System.out.println(sumsb.toString());
	}
}
