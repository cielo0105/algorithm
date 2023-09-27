import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());
		int[][] dp = new int[N+1][N+1];
		int answer = 0;
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++) {
				if(i==j) dp[i][j] = 0;
				else dp[i][j] = Integer.MAX_VALUE;
			}
		}
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int time = Integer.parseInt(st.nextToken());
			dp[from][to] = time;
		}
		
		for(int mid=1; mid<=N; mid++) {
			for(int i=1; i<=N; i++) {
				for(int j=1; j<=N; j++) {
					if(dp[i][mid]==Integer.MAX_VALUE || dp[mid][j]==Integer.MAX_VALUE) continue;
					dp[i][j] = Math.min(dp[i][j], dp[i][mid]+dp[mid][j]);
				}
			}
		}
		for(int i=1; i<=N; i++) {
			answer = Math.max(answer,dp[i][X]+dp[X][i]);
		}
		System.out.println(answer);
	}
	
}