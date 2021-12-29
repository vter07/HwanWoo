
import java.util.*;
import java.io.*;

public class BeakJoon_2580 {

	public static int[][] arr = new int[9][9];
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws Exception{
		
		Scanner sc = new Scanner(System.in);
		for(int i = 0; i<arr.length; i++) {
			for(int j = 0; j<arr.length; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		sudoku(0, 0);
	}
	
	public static void sudoku(int row, int colum) throws Exception{
		if(colum==9) {
			sudoku(row + 1, 0);
			return;
		}
		
		if(row==9) {
			for(int i = 0; i<9; i++) {
				for(int j =0; j<9; j++) {
					bw.write(arr[i][j] + " ");
				}
				bw.write("\n");
			}
			bw.close();
			System.exit(0);
		}
		if(arr[row][colum]==0) {
			for(int i = 1; i<=9; i++) {
				if(possibility(row, colum, i)) {
					arr[row][colum] = i;
					sudoku(row, colum + 1);
				}
			}
			arr[row][colum] = 0;
			return;
		}
		sudoku(row, colum + 1);
	}
	
	public static boolean possibility(int row, int colum, int value) {
		for(int i = 0; i<9; i++) {
			if(arr[row][i] == value) {
				return false;
			}
		}
		
		for(int i = 0; i<9; i++) {
			if(arr[i][colum] == value) {
				return false;
			}
		}
		
		int row2 = (row/3)*3;
		int colum2= (colum/3)*3;
		
		for(int i = row2; i<row2+3; i++) {
			for(int j = colum2; j<colum2+3; j++) {
				if(arr[i][j] == value) {
					return false;
				}
			}
		}
		return true;
	}

}
