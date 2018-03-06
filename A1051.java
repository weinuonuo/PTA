package PTA;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class A1051 {
	public static void main(String[] args) throws ParseException {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		in.nextLine(); 
		DateFormat df = new SimpleDateFormat("HH:mm:ss");
		String[] number1 = in.nextLine().split(" ");
		Date sign_in = df.parse(number1[1]);
		Date sign_out = df.parse(number1[2]);
		String in_number = number1[0];
		String out_number = number1[0];
		for (int i = 1; i < N; i++) {
			String[] number = in.nextLine().split(" ");
			Date tmp_in = df.parse(number[1]);
			Date tmp_out = df.parse(number[2]);
			if(tmp_in.getTime() < sign_in.getTime()){
				in_number = number[0];
				sign_in.setTime(tmp_in.getTime());
			}
			if(tmp_out.getTime() > sign_out.getTime()){
				out_number = number[0];
				sign_out.setTime(tmp_out.getTime());
			}
		}
		System.out.println(in_number + " " +out_number);
	}
}
