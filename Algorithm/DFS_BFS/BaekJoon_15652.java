/*
< 중복 조합 문제 >
서로다른 n개의 원소에서 m개를 중복 하여 순서에 상관없이 뽑는다.
*/

import java.io.*;
import java.util.*;

public class BaekJoon_15652 {
	
	static int[] arr;
	static int n, m;
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		m = sc.nextInt();
		
		arr = new int[m];
		dfs(0, 0);
		bw.close();

	}
	
	static void dfs(int depth, int start) throws Exception {
		if(m==depth) {
			for(int val : arr) {
				bw.write(val + " ");
			}
			bw.write("\n");
			return;
		}
		for(int i = start; i<n; i++) {
			arr[depth] = i+1;
			dfs(depth +1, i);
		}
	}
}

