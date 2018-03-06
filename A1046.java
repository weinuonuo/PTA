package PTA;

import java.util.HashMap;
import java.util.Scanner;

public class A1046 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int M = scanner.nextInt();//ÁÐ
		int N = scanner.nextInt();//ÐÐ
		HashMap<String,Integer> map = new  HashMap<String,Integer>();
		int size = N*M/2;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				String num = scanner.next();
				if(map.containsKey(num)){
					int time = map.get(num);
					map.remove(num);
					map.put(num, time+1);
				}else{
					map.put(num, 1);
				}
			}
		}
		for(String num : map.keySet()){
			if(map.get(num) > size){
				System.out.println(num);
			}
		}
	}
}
