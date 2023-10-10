import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
 * 도둑루피 - 소지한 루피 감소
 * N*N 동굴 0,0에 위치
 * N-1,N-1로 이동하는 동안 잃는 최소 금액?
 */
public class Main {
	static int N;
	static int[][] map, dp;
	static int[][] deltas = {{-1,0},{0,1},{1,0},{0,-1}};
	static boolean[][] visited;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int t = 1;
		while(true) {
			N = Integer.parseInt(br.readLine());
			if(N == 0) break;
			map = new int[N][N];
			dp = new int[N][N];
			for(int i=0; i<N; i++) {
				Arrays.fill(dp[i], -1);
			}
			visited = new boolean[N][N];
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			find();
			sb.append(String.format("Problem %d: %d\n", t++,dp[N-1][N-1]));
		}
		System.out.println(sb);
	}
	
	static void find() {
		PriorityQueue<Info> pq = new PriorityQueue<>();
		pq.add(new Info(0,0,map[0][0]));
		dp[0][0] = map[0][0];
		while(!pq.isEmpty()) {
			Info info = pq.poll();
			if(info.x==N-1 && info.y==N-1) return;
			for(int i=0; i<4; i++) {
				int nx = info.x + deltas[i][0];
				int ny = info.y + deltas[i][1];
				if(nx>=0 && nx<N && ny>=0 && ny<N) {
					if(dp[nx][ny] == -1 || (dp[nx][ny]>dp[info.x][info.y]+map[nx][ny])) {
						dp[nx][ny] = dp[info.x][info.y]+map[nx][ny];
						pq.add(new Info(nx,ny,dp[nx][ny]));
					}
				}
			}
		}
	}
	
	static class Info implements Comparable<Info>{
		int x, y, sum;
		public Info(int x, int y, int sum) {
			this.x = x;
			this.y = y;
			this.sum = sum;
		}
		@Override
		public int compareTo(Info o) {
			return this.sum - o.sum;
		}
		@Override
			public String toString() {
				return this.x+" "+this.y+" "+this.sum;
			}
	}
}