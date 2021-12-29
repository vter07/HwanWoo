
import java.util.*;
import java.io.*;

public class BaekJoon_15651 {
	
	static int[] arr;
	static int n, m;
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		m = sc.nextInt();
		
		arr = new int[m];
		dfs(0);
		bw.close();

	}
	
	static void dfs(int depth) throws Exception {
		if(m==depth) {
			for(int val : arr) {
				bw.write(val + " ");
			}
			bw.write("\n");
			return;
		}
		for(int i = 0; i<n; i++) {
			arr[depth] = i+1;
			dfs(depth +1);
		}
	}
}
