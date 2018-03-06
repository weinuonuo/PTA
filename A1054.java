package PTA;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

public class A1054 {
	public static class student{
		private String name;
		private String id;
		
		public student(String name, String id) {
			super();
			this.name = name;
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public String getId() {
			return id;
		}
	}
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int N = Integer.parseInt(in.nextLine());
//		LinkedList<student> students = new LinkedList();
		HashMap<Integer, student>students = new HashMap<Integer, student>();
		ArrayList<Integer> grade = new ArrayList<Integer>();
		for (int i = 0; i < N; i++) {
			String []line = in.nextLine().split(" ");
			students.put(Integer.parseInt(line[2]), new student(line[0],line[1]));
			grade.add(Integer.parseInt(line[2]));
		}
		int grade_up = in.nextInt();
		int grade_on = in.nextInt();
		Collections.sort(grade);
		boolean flag = true;
		for (int i = grade.size()-1; i >= 0; i--) {
			if(grade.get(i) <= grade_on && grade.get(i) >= grade_up){
				student stu = students.get(grade.get(i));
				System.out.println(stu.getName()+" "+stu.getId());
				flag = false;
			}
		}
		if(flag){
			System.out.println("NONE");
		}
	}
}
