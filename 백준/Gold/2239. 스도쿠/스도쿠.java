import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int[][] sudoku = new int[9][9];
	static List<Point> zeroList = new ArrayList<>();
	static Point[] zero;
	static StringBuilder sb;
	static int flag = 0;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int i=0; i<9; i++) {
			char[] arr = br.readLine().toCharArray();
			for(int j=0; j<9; j++) {
				sudoku[i][j] = arr[j] -'0';
				if(sudoku[i][j]==0) zeroList.add(new Point(i,j));  // 채워야 하는 부분 zero에 저장
			}
		}
		zero = zeroList.toArray(new Point[zeroList.size()]);
		find(0);
		System.out.println(sb);
	}
	
	static void find(int start) {
		if(flag == 1) return;
		if(start == zero.length) {
			sb = new StringBuilder();
			for(int i=0; i<9; i++) {
				for(int j=0; j<9; j++) {
					sb.append(sudoku[i][j]);
				}
				sb.append("\n");
			}
			flag = 1;
			return;
		}
		Point p = zero[start]; // 채워야 하는 부분
		for(int i=1; i<=9; i++) {
			if(check(p,i)) {
				sudoku[p.x][p.y] = i;
				find(start+1);
				sudoku[p.x][p.y] = 0;
			}
		}
	}
	
	static boolean check(Point p, int num) {
		// 가로 확인 (x값 동일)
		for(int i=0; i<9; i++) {
			if(sudoku[p.x][i] == num) return false;
		}
		// 세로 확인 (y값 동일)
		for(int i=0; i<9; i++) {
			if(sudoku[i][p.y] == num) return false;
		}
		// 3*3 확인
		int nx = p.x/3;
		int ny = p.y/3;
		for(int i=nx*3; i<nx*3+3; i++) {
			for(int j=ny*3; j<ny*3+3; j++) {
				if(sudoku[i][j] == num) return false;
			}
		}
		return true;
	}
}