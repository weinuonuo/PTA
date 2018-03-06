package PTA;

import java.util.Scanner;

public class A1055 {
	public static class Student{
		private String name;
		private String id;
		private int grade;
		public Student(){
			
		}
		public Student(String name, String id, int grade) {
			super();
			this.name = name;
			this.id = id;
			this.grade = grade;
		}

		public String getName() {
			return name;
		}

		public String getId() {
			return id;
		}
		
		public int getGrade(){
			return grade;
		}
		
		public void setName(String name) {
			this.name = name;
		}
		public void setId(String id) {
			this.id = id;
		}
		public void setGrade(int grade) {
			this.grade = grade;
		}
		
	}
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		Student female = new Student();
		Student male = new Student();
		boolean flag_M = false,flag_F = false;
		for (int i = 0; i < N; i++) {
			String name = in.next();
			String gender = in.next();
			String id = in.next();
			int grade = in.nextInt();
			if(gender.equals("M")){//如果是男孩子，求最低分
				if(male.getName() == null || grade < male.getGrade()){
					male.setName(name);
					male.setId(id);
					male.setGrade(grade);
					flag_M = true;
				}
			}else{//如果是女孩子
				if(female.getName() == null || grade > female.getGrade()){
					female.setName(name);
					female.setId(id);
					female.setGrade(grade);
					flag_F = true;
				}
			}
		}
		if(flag_F){
			System.out.println(female.getName()+" "+female.getId());
		}else{
			System.out.println("Absent");
		}
		if(flag_M){
			System.out.println(male.getName()+" "+male.getId());
		}else{
			System.out.println("Absent");
		}
		if(flag_M && flag_F){
			System.out.println(female.getGrade()-male.getGrade());
		}else {
			System.out.println("NA");
		}
	}
}
