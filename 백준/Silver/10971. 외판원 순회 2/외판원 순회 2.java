import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
/*
 * 1번~N번  도시 모두 거쳐 원래 도시 돌아오는 순회 여행 경로 (한번 방문한 도시는 다시 안감)
 * 
 * 
 */
public class Main {
	static int N;
	static int[][] cost, least;
	static boolean[] visited;
	
	public static void foo(int bitmask, int city, boolean[] notVisited) {
		for(int j=1; j<=N; j++) { // j : 돌아갈 도시
			if(cost[j][city] != 0 && !notVisited[j]) {
				int bits = bitmask ^ (1<<(j-1));
				least[bits][j] = Math.min(least[bits][j], least[bitmask][city] + cost[j][city]);
				notVisited[j] = true;
				foo(bits, j, notVisited);
				notVisited[j] = false;
			}
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		cost = new int[N+1][N+1];
		least = new int[1<<N][N+1];
		
		for(int i=0; i< 1<<N; i++) {
			for(int j=1; j<=N; j++) {
				least[i][j] = 1234567890;
			}
		}
		
		visited = new boolean[N+1];
		StringTokenizer st;
		
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<=N; j++) {
				cost[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int bitmask = (1<<N) - 1; // 111111111(2)
		for(int i=1; i<=N; i++) {
			least[bitmask][i] = cost[i][1];
		}
		
		// d[10111][5] = d[11111][4] + cost[5][4] (남은 거리)
		// d[11101][2] = d[11111][4] + cost[2][4] 
		// d[bitmask ..][i] = d[bitmask][n] + cost[i][n]
		foo(bitmask, 1, new boolean[N + 1]);
		System.out.println(least[0][1]);
	}
	

	
}