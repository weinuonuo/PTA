package PTA;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class A1053 {
	public static class Tree{
		private int data;
		private Tree lchild;
		private Tree rchild;
		
		public Tree(int root){
			this.data = root;
		}
	}
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int []postorder = new int[N];
		for (int i = 0; i < N; i++) {
			postorder[i] = in.nextInt();
		}
		int []inorder = new int[N];
		for (int i = 0; i < N; i++) {
			inorder[i] = in.nextInt();
		}
		Tree tree = rebuild(postorder, 0, N-1, inorder, 0, N-1);
		Queue<Tree> queue = new LinkedList<Tree>();
		queue.add(tree);
		ArrayList<Integer> list = new ArrayList<Integer>();
		while(!queue.isEmpty()){
			Tree tmp = queue.poll();
			list.add(tmp.data);
			if(tmp.lchild != null){
				queue.add(tmp.lchild);
			}
			if(tmp.rchild != null){
				queue.add(tmp.rchild);
			}
		}
		for (int i = 0; i < list.size()-1; i++) {
			System.out.print(list.get(i) + " ");
		}
		System.out.print(list.get(list.size()-1));
	}
	public static Tree rebuild(int []postorder,int lbegin,int lend,int []inorder,int rbegin,int rend){
		if(lbegin > lend){
			return null;
		}
		Tree tree = new Tree(postorder[lend]);
		int index = 0;
		for (int i = 0; i < inorder.length; i++) {
			if(inorder[i] == postorder[lend]){//根据根节点区分左右子树
				index = i;
				break;
			}
		}
		int leftnum = index - rbegin;
		
		tree.lchild = rebuild(postorder, lbegin, lbegin+leftnum-1, inorder, rbegin, index-1);
		tree.rchild = rebuild(postorder, lbegin+leftnum, lend-1, inorder, index+1, rend);
		return tree;
	}
}
