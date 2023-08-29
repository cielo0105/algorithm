import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
/*
 * 집 빨강, 초록, 파랑으로 칠하는 비용
 * 인접한 집과 색 같으면 안됨
 * 
 */
public class Main {
	static int[][] color;
	static int[][] dp;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		color = new int[N][N];
		dp = new int[N][3];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<3; j++) {
				color[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=0; i<3; i++) {
			dp[0][i] = color[0][i];
		}
		for(int i=1; i<N; i++) {
			dp[i][0] = Math.min(dp[i-1][1],dp[i-1][2]) + color[i][0];
			dp[i][1] = Math.min(dp[i-1][0],dp[i-1][2]) + color[i][1];
			dp[i][2] = Math.min(dp[i-1][0],dp[i-1][1]) + color[i][2];
		}
		System.out.println(Math.min(dp[N-1][2],Math.min(dp[N-1][0], dp[N-1][1])));
	}
	
}