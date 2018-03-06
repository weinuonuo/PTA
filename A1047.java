package PTA;

import java.util.Scanner;

public class A1047 {
	public static void main(String[] args) {
		String []Marn = {"A","B","C"};
		Scanner scanner = new Scanner(System.in);
		int []nums = new int[3];
		for (int i = 0; i < nums.length; i++) {
			nums[i] = scanner.nextInt();
		}
		StringBuffer Marn_num = new StringBuffer();
		Marn_num.append("#");
		for (int j = 0; j < nums.length; j++) {
			if(nums[j]/13 > 9){
				Marn_num.append(String.valueOf(Marn[(nums[j]/13)%10]));
			}else if (nums[j]/13 == 0){
				Marn_num.append("0");
			}else{
				Marn_num.append(String.valueOf(nums[j]/13));
			}
			
			if(nums[j]%13 > 9){
				Marn_num.append(String.valueOf(Marn[(nums[j]%13)%10]));
			}else if (nums[j]%13 == 0){
				Marn_num.append("0");
			}else{
				Marn_num.append(String.valueOf(nums[j]%13));
			}
		}
		System.out.println(Marn_num.toString());
	}
}
