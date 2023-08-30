import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int[][] matrix;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		matrix = new int[30][30];
		for(int[] m: matrix) Arrays.fill(m, -1);
		StringTokenizer st;
		for(int i=0; i<30; i++) {
			matrix[i][i] = 1;
			matrix[i][0] = 1;
		}
		
		for(int t=0; t<T; t++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			comb(M,N);
			sb.append(matrix[M][N]).append("\n");
		}
		System.out.println(sb);
	}
	
	static int comb(int n, int r) {
		if(matrix[n][r] != -1) return matrix[n][r];
		matrix[n][r] = comb(n-1,r-1) + comb(n-1,r);
		return matrix[n][r];
	}
	
}