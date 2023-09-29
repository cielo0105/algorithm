import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int INF = 987654321;
	static int[][] map;
	static List<Info>[] link;
	static int[][] dp;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		link = new ArrayList[N];
		
		for(int i=0; i<N; i++) {
			link[i] = new ArrayList<>();
		}
		dp = new int[N][1<<N];
		StringTokenizer st;
		for(int i=0; i<N; i++) {
			Arrays.fill(dp[i], -1);
		}
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				int cost = Integer.parseInt(st.nextToken());
				map[i][j] = cost;
				if(cost>0) {
					link[i].add(new Info(j,cost));
				}
			}
		}
		System.out.println(find(0,1));
		
	}
	
	static int find(int start, int bitmask) {
		if(bitmask == (1<<N)-1) {
			if(map[start][0] == 0) return INF;
			return map[start][0];
		}
		if(dp[start][bitmask] != -1) {
			return dp[start][bitmask];
		}
		dp[start][bitmask] = INF;
		for(Info next:link[start]) {
			if((1<<(next.x) & bitmask) == 0) { // 아직 방문하지 않음
				dp[start][bitmask] = Math.min(dp[start][bitmask], find(next.x, bitmask|(1<<next.x))+next.cost);
			}
		}
		return dp[start][bitmask];
	}
	
	static class Info{
		int x, cost;
		public Info(int x, int cost) {
			this.x = x;
			this.cost = cost;
		}
	}
}