import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;
/*
 * N*M
 * 0 : 이동 가능
 * 1 : 벽
 * K개 벽 부수기 가능
 */
public class Main {
	static int N,M,K;
	static char[][] map;
	static boolean[][][] visited;
	static int answer = -1;
	static int[][] deltas = {{-1,0},{0,1},{1,0},{0,-1}};
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		map = new char[N][M];
		visited = new boolean[N][M][K+1];
		for(int i=0; i<K; i++) {
			visited[0][0][i] = true;
		}
		for(int i=0; i<N; i++) {
			map[i] = br.readLine().toCharArray();
		}
		move();
		System.out.println(answer);
	}
	
	static void move() {
		Queue<Info> q = new ArrayDeque<>();
		q.add(new Info(0,0,0,0));
		while(!q.isEmpty()) {
			Info info = q.poll();
			if(info.x == N-1 && info.y == M-1) {
				answer = info.dist + 1;
				return;
			}
			for(int i=0; i<4; i++) {
				int nx = info.x + deltas[i][0];
				int ny = info.y + deltas[i][1];
				if(nx>=0 && nx<N && ny>=0 && ny<M) {
					if(map[nx][ny] == '1') { // 벽인 경우
						if(info.cnt < K && !visited[nx][ny][info.cnt+1]) {
							visited[nx][ny][info.cnt+1] = true;
							q.add(new Info(nx,ny,info.cnt+1,info.dist+1));
						}
					}
					else { // 0인 경우
						if(!visited[nx][ny][info.cnt]) {
							visited[nx][ny][info.cnt] = true;
							q.add(new Info(nx,ny,info.cnt,info.dist+1));
						}
					}
				}
			}
		}
	}
	
	static class Info{
		int x, y, cnt, dist;
		public Info(int x, int y, int cnt, int dist) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
			this.dist = dist;
		}
		@Override
		public String toString() {
			return this.x+" "+this.y+" "+this.cnt+" "+this.dist;
		}
	}
}