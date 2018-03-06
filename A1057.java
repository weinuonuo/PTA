package PTA;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
//有一个点过不去，不知道为什么
public class A1057 {
	public static class Testee implements Comparable<Testee>{
		private long id;
		private int grade;
		private int local_num;
		private int local_rank;
		
		public Testee(long id, int grade,int local_num) {
			super();
			this.id = id;
			this.grade = grade;
			this.local_num = local_num;
		}

		@Override
		public int compareTo(Testee o) {
			// TODO Auto-generated method stub
			int i = o.grade - this.grade;
			if(i == 0){
				if(o.id > this.id){
					return -1;
				}else{
					return 1;
				}
			}
			return i;
		}


		public long getId() {
			return id;
		}

		public void setId(long id) {
			this.id = id;
		}

		public int getGrade() {
			return grade;
		}

		public void setGrade(int grade) {
			this.grade = grade;
		}

		public int getLocal_num() {
			return local_num;
		}

		public void setLocal_num(int local_num) {
			this.local_num = local_num;
		}

		public int getLocal_rank() {
			return local_rank;
		}

		public void setLocal_rank(int local_rank) {
			this.local_rank = local_rank;
		}
		
		
	}
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();//地址数
		ArrayList<Testee> testees = new ArrayList<Testee>();
		for (int i = 0; i < N; i++) {
			int K = in.nextInt();
			ArrayList<Testee> localer = new ArrayList<Testee>();
			for (int j = 0; j < K; j++) {
				localer.add(new Testee(in.nextLong(),in.nextInt(),i+1));
			}
			Collections.sort(localer);
			for (int j = 0; j < K; j++) {
				if(testees.size() != 0 && localer.get(0).getGrade() == testees.get(testees.size()-1).getGrade()){
					localer.get(0).setLocal_rank(testees.get(testees.size()-1).getLocal_rank());
				}else{
					localer.get(0).setLocal_rank(K-localer.size()+1);
				}
				testees.add(localer.remove(0));
			}
		}
		Collections.sort(testees);
		System.out.println(testees.size());
		int n = 1;
		for (int i = 0; i < testees.size(); i++) {
			if(i != 0 && testees.get(i).getGrade() != testees.get(i-1).getGrade()){
				n = i+1;
			}
			System.out.println(testees.get(i).getId()+" "+ n + " "+ testees.get(i).getLocal_num()+" "+testees.get(i).getLocal_rank());
		}
	}
}
