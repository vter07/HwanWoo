package Main.copy;

import java.io.*;

public class BaekJoon_1003 {
	
	public static int[] dp = new int[41];
	public static int[] count1 = new int[41];
	public static int[] count0 = new int[41];

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		
		for(int i = 0; i<n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		} 
		count0[0] = 1;
		count1[1] = 1;
		for(int i = 2; i<=40; i++) {
			count0[i] = count0[i-1] + count0[i-2];
			count1[i] = count1[i-1] + count1[i-2];
		}
		for(int i = 0; i<n; i++) {
			bw.write(count0[arr[i]] + " " + count1[arr[i]] + "\n");
		}
		bw.flush();
	}
}
