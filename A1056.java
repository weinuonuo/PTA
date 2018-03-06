package PTA;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Stack;
import java.util.TreeMap;
//ע���������ʽϵ�����Ϊ0�������
//ע��λ������
//�Ժ�ʹ��TreeMap����HashMap
public class A1056 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int NA = in.nextInt();
		TreeMap<Integer, Double> poly = new TreeMap();
		for (int i = 0; i < NA; i++) {
			int exp = in.nextInt();
			double coe = in.nextDouble();
			poly.put(exp, coe);
		}
		int NB = in.nextInt();
		for (int i = 0; i < NB; i++) {
			int exp = in.nextInt();
			double coe = in.nextDouble();
			if(poly.containsKey(exp)){
				double coe_a = poly.remove(exp);
				if(coe_a + coe != 0){
					poly.put(exp, Math.round((coe_a + coe)*10)/10.0);
				}
			}else{
				poly.put(exp, coe);
			}
		}
		//�������key�������
		Iterator<Integer> it = poly.keySet().iterator();
		Stack<Integer> keys = new Stack<Integer>();
		while(it.hasNext()){
			keys.push(it.next());
		}
		
		System.out.print(poly.size());
		for (int i = 0; i < poly.size(); i++) {
			System.out.print(" "+keys.peek()+" "+poly.get(keys.pop()));
		}
	}
}
