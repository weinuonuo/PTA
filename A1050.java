package PTA;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class A1050 {
	//广度优先搜索
	public static void BFS(int M ,int N ,ArrayList<Integer> []family) {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(1);
		int depth = 0;
		StringBuffer sum = new StringBuffer();
		while(!queue.isEmpty()){
			int tmp = 0;
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				int j = queue.remove();
				if(family[j].size() == 0){
					tmp++;
				}
				for (int j2 = 0; j2 < family[j].size(); j2++) {
					queue.add(family[j].get(j2));
				}
			}
			depth ++;
			sum.append(String.valueOf(tmp)+" ");
		}
//		sum.deleteCharAt(sum.length()-1);
		System.out.print(sum.toString());
	}
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int N = scanner.nextInt();//节点个数
		int M = scanner.nextInt();//非叶子节点个数
		/*if(M == 0){
			System.out.println(1);
			return;
		}*/
		//建立邻接表
		ArrayList<Integer>[] tree = new ArrayList[N+1];
		for (int i = 0; i < tree.length; i++) {
			tree[i] = new ArrayList<Integer>();
		}
		scanner.nextLine();
		for (int i = 0; i < M; i++) {
			String []line = scanner.nextLine().split(" ");
			int father =Integer.parseInt(line[0]);
			for (int j = 2; j < Integer.parseInt(line[1])+2; j++) {
				tree[father].add(Integer.parseInt(line[j]));
			}
			
		}
		BFS(M, N, tree);
	}
}
