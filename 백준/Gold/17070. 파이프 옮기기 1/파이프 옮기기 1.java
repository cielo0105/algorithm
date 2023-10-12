import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * N*N
 * 오른쪽 아래 방향으로만 이동
 * 45도씩 회전 가능
 * 가로 0 대각선 1 세로 2
 */
public class Main {
	static int[][] deltas = {{0,1},{1,1},{1,0}};
	static int N;
	static int[][] map;
	static int[][][] dp;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		dp = new int[N][N][3];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		dp[0][1][0] = 1;
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(i==0 && j==0) continue;
				if(dp[i][j][0] > 0) { // 가로
					if(j+1<N && map[i][j+1]!=1) dp[i][j+1][0] += dp[i][j][0];
					if(i+1<N && j+1<N && check(i,j)) dp[i+1][j+1][1] += dp[i][j][0];
				}
				if(dp[i][j][1] > 0) { // 대각선
					if(j+1<N && map[i][j+1]!=1) dp[i][j+1][0] += dp[i][j][1];
					if(i+1<N && j+1<N && check(i,j)) dp[i+1][j+1][1] += dp[i][j][1];
					if(i+1<N && map[i+1][j]!=1) dp[i+1][j][2] += dp[i][j][1];
				}
				if(dp[i][j][2] > 0) { // 세로
					if(i+1<N && j+1<N && check(i,j)) dp[i+1][j+1][1] += dp[i][j][2];
					if(i+1<N && map[i+1][j]!=1) dp[i+1][j][2] += dp[i][j][2];
				}
			}
		}
		System.out.println(dp[N-1][N-1][0]+dp[N-1][N-1][1]+dp[N-1][N-1][2]);
		
	}
	
	static boolean check(int r, int c) {
		for(int i=0; i<3; i++) {
			int nx = r + deltas[i][0];
			int ny = c + deltas[i][1];
			if(nx>=0 && nx<N && ny>=0 && ny<N && map[nx][ny]!=1) continue;
			return false;
		}
		return true;
	}
	
}