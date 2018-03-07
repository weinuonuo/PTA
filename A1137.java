package pat201712;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
//最后一个点一直超时，java太慢了，难受
public class A1137 {
	public static class Student implements Comparable<Student>{
		private String name;
		private int p_grade;
		private int m_grade;
		private int n_grade;
		private int grade;
		
		public Student(String name,int p_grade) {
			this.name = name;
			this.p_grade = p_grade;
			this.m_grade = -1;
			this.n_grade = -1;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public void setP_grade(int p_grade) {
			this.p_grade = p_grade;
		}

		public void setM_grade(int m_grade) {
			this.m_grade = m_grade;
		}

		public void setN_grade(int n_grade) {
			this.n_grade = n_grade;
		}

		public void setGrade(int grade) {
			this.grade = grade;
		}

		@Override
		public int compareTo(Student o) {
			int i =  o.grade - this.grade;
			if(i == 0){
				return this.name.compareTo(o.name);
			}
			return i;
		}

		
	}
	public static void main(String[] args) throws IOException {
//		Scanner in = new Scanner(System.in);
//		Scanner in = new Scanner(new InputStreamReader(System.in));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String []line1 = in.readLine().split(" ");
		int P = Integer.parseInt(line1[0]);
		int M = Integer.parseInt(line1[1]);
		int N = Integer.parseInt(line1[2]);
		Map<String,Student> students = new HashMap<>();
		ArrayList<Student> sum = new ArrayList<>();
		for (int i = 0; i < P; i++) {
			String []line = in.readLine().split(" ");
			String name = line[0];
			int grade = Integer.parseInt(line[1]);
			if(grade >= 200){
				Student stu = new Student(name,grade);
				students.put(name, stu);
			}
			
		}
		
		for (int i = 0; i < M; i++) {
			String []line = in.readLine().split(" ");
			String name = line[0];
			int grade = Integer.parseInt(line[1]);
			if(students.containsKey(name)){
				students.get(name).setM_grade(grade);
			}
		}
		
		for (int i = 0; i < N; i++) {
			String []line = in.readLine().split(" ");
			String name = line[0];
			int grade = Integer.parseInt(line[1]);
			if (students.containsKey(name)){
				students.get(name).setN_grade(grade);
				Student stu = students.remove(name);
				if(stu.m_grade > stu.n_grade){
					stu.setGrade((int)(stu.m_grade*0.4+stu.n_grade*0.6+0.5));
//					stu.setGrade(new Long(Math.round(stu.m_grade*0.4+stu.n_grade*0.6)).intValue());
				}else{
					stu.setGrade(stu.n_grade);
				}
				if(stu.grade >=60 && stu.grade <= 100){
					sum.add(stu);
				}
				
			}
			
		}
		
		Collections.sort(sum);
		for (Student student : sum) {
			System.out.println(student.name+" "+student.p_grade+" "+student.m_grade+" "+student.n_grade+" "+student.grade);
		}
	}
}
