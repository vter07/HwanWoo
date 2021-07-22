package GitHub;

import java.io.*;
import java.util.*;

public class BaekJoon_11650 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		Point[] arr = new Point[N];
		
		for(int i = 0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr[i] = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		Arrays.sort(arr, new Comparator<Point>(){
			@Override
            public int compare(Point o1, Point o2) {
                if(o1.x > o2.x) {
                    return 1;
                }
                else if (o1.x == o2.x){
                    if(o1.y < o2.y) {
                        return -1;
                    }
                    else {
                    	return 1;
                    }
                }
                else {
                	return -1;
                }
            }
		});
		
//		Comparator<Point> comparator = new Comparator<>() {
//			@Override
//            public int compare(Point o1, Point o2) {
//                if(o1.x > o2.x) {
//                    return 1;
//                }
//                else if (o1.x == o2.x){
//                    if(o1.y < o2.y) {
//                        return -1;
//                    }
//                    else {
//                    	return 1;
//                    }
//                }
//                else {
//                	return -1;
//                }
//            }
//		};
//		Arrays.sort(arr, comparator);
		for(Point point : arr) {
			System.out.println(point.x + " " + point.y);
		}
		
	}
	
	static class Point{
		int x;
		int y;
		
		Point(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
}
