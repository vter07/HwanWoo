package Main.copy;

import java.io.*;

public class BeakJoon_9663 {

	static int n;
	static int[] arr;
	static int count = 0;

	
	public static void queen(int depth) {
		if(depth == n) {
			count ++;
			return;
		}
		for(int i = 0; i<n; i++) {
			arr[depth] = i;
			if(Possibility(depth)) {
				queen(depth+1);
			}
		}
	}
	
	public static boolean Possibility(int colum) {
		for(int i = 0; i<colum; i++) {
			if(arr[i] == arr[colum]) {
				return false;
			}
			else if(Math.abs(i-colum)==Math.abs(arr[i]-arr[colum])) {
				return false;
			}
		}
		return true;
	}
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		n = Integer.parseInt(br.readLine());
		arr = new int[n];
		queen(0);
		bw.write(count + "\n");
		bw.close();

	}

}
