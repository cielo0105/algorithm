import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N,M;
	static char[][] map;
	static boolean[][][] visited;
	static int[][] deltas = {{-1,0},{0,1},{1,0},{0,-1}};
	static int answer = -1;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[N][M];
		for(int i=0; i<N; i++) {
			map[i] = br.readLine().toCharArray();
		}
		visited = new boolean[N][M][2];
		find();
		System.out.println(answer);
	}
	
	static void find() {
		Queue<Info> q = new ArrayDeque<>();
		q.add(new Info(0,0,0,0));
		visited[0][0][0] = true;
		visited[0][0][1] = true;
		while(!q.isEmpty()) {
//			System.out.println(q);
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
						if(info.cnt == 0) { // 전에 벽 부순 적 없으면
							q.add(new Info(nx,ny,info.dist+1,1));
							visited[nx][ny][1] = true;
						}
					}
					else{ // 이동할 수 있는 칸인 경우
						if(info.cnt == 0 && !visited[nx][ny][0]) {
							q.add(new Info(nx,ny,info.dist+1,0));
							visited[nx][ny][0] = true; 
						}
						else if(info.cnt == 1 && !visited[nx][ny][1]) {
							q.add(new Info(nx,ny,info.dist+1,1));
							visited[nx][ny][1] = true;
						}
					}
				}
			}
		}
	}
	
	static class Info{
		int x, y, dist, cnt;
		public Info(int x, int y, int dist, int cnt) {
			this.x = x;
			this.y = y;
			this.dist = dist;
			this.cnt = cnt;
		}
	}
}