package PTA;

import java.util.Scanner;

public class A1052 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int begin = 0;
		int time = 0;
		for (int i = 0; i < N; i++) {
			int now = in.nextInt();
			if(now > begin){
				int step = now -begin;
				time += step * 6 + 5;
			}else if(now < begin){
				int step = begin - now;
				time += step * 4 + 5;
			}else{
				time += 5;
			}
			begin = now;
		}
		System.out.println(time);
	}
}
