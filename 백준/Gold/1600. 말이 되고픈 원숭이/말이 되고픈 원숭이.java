import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;
/*
 * 말처럼 움직일 수 있는 횟수 K 번
 * 0,0 -> H-1,W-1 까지 이동
 * 
 */
public class Main {
	static int[][] horse = {{-2,1},{-1,2},{1,2},{2,1},{2,-1},{1,-2},{-1,-2},{-2,-1}};
	static int[][] deltas = {{-1,0},{0,1},{1,0},{0,-1}};
	static int K, W, H;
	static int[][] map;
	static boolean[][][] visited;
	static int answer = -1;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		K = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		map = new int[H][W];
		visited = new boolean[H][W][K+1];
		for(int i=0; i<H; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<W; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		find();
		System.out.println(answer);
	}
	
	static void find() {
		Queue<Info> q = new ArrayDeque<>();
		q.add(new Info(0,0,0,0));
		visited[0][0][0] = true;
		while(!q.isEmpty()) {
			Info info = q.poll();
			if(info.x == H-1 && info.y == W-1) {
				answer = info.time;
				return;
			}
			for(int i=0; i<4; i++) {
				int nx = info.x + deltas[i][0];
				int ny = info.y + deltas[i][1];
				if(nx>=0 && nx<H && ny>=0 && ny<W && map[nx][ny]==0 && !visited[nx][ny][info.cnt]) {
					visited[nx][ny][info.cnt] = true;
					q.add(new Info(nx,ny,info.time+1,info.cnt));
				}
			}
			if(info.cnt < K) {
				for(int i=0; i<8; i++) {
					int nx = info.x + horse[i][0];
					int ny = info.y + horse[i][1];
					if(nx>=0 && nx<H && ny>=0 && ny<W && map[nx][ny]==0 && !visited[nx][ny][info.cnt+1]) {
						visited[nx][ny][info.cnt+1] = true;
						q.add(new Info(nx,ny,info.time+1,info.cnt+1));
					}
				}
			}
		}
	}
	
	static class Info{
		int x, y, time, cnt;
		public Info(int x, int y, int time, int cnt) {
			this.x = x;
			this.y = y;
			this.time = time;
			this.cnt = cnt;
		}
	}
}