package Main.copy;

import java.util.*;

public class BeakJoon_15650 {

	static int[] arr;
	static boolean[] mark;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		arr = new int[m];
		mark = new boolean[n];
		
		dfs(n, m, 0, 0);

	}
	
	static void dfs(int n, int m, int depth, int start) {
		if(m==depth) {
			for(int val : arr) {
				System.out.print( val + " ");
			}
			System.out.println();
			return;
		}
		for(int i = start; i<n; i++) {
			if(mark[i]==false) {
				mark[i] = true;
				arr[depth] = i+1;
				dfs(n, m, depth +1, i+1);
				mark[i] = false;
			}
		}
	}
}