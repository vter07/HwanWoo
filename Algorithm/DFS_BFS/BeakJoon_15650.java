/*
< 조합 문제 >
서로 다른 n 개의 원소에서 m 개를 중복 없이 순서에 상관 없이 뽑는 문제이다.
*/

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
