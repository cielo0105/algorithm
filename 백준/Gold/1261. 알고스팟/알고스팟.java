import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int N,M;
	static char[][] map;
	static int[][] deltas = {{-1,0},{0,1},{1,0},{0,-1}};
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		map = new char[N][M];
		for(int i=0; i<N; i++) {
			map[i] = br.readLine().toCharArray();
		}
		System.out.println(bfs());
	}
	
	static int bfs() {
		boolean[][] visited = new boolean[N][M];
		PriorityQueue<Info> pq = new PriorityQueue<>();
		pq.add(new Info(0,0,0));
		while(!pq.isEmpty()) {
			Info info = pq.poll();
			if(info.x == N-1 && info.y == M-1) {
				return info.cnt;
			}
			for(int i=0; i<4; i++) {
				int nx = info.x + deltas[i][0];
				int ny = info.y + deltas[i][1];
				if(nx>=0 && nx<N && ny>=0 && ny<M && !visited[nx][ny]) {
					visited[nx][ny] = true;
					if(map[nx][ny]=='1') pq.add(new Info(nx,ny,info.cnt+1));
					else pq.add(new Info(nx,ny,info.cnt));
				}
				
			}
		}
		return 0;
	}
	
	static class Info implements Comparable<Info>{
		int x, y, cnt;
		public Info(int x, int y, int cnt) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}
		@Override
		public int compareTo(Info o) {
			return this.cnt - o.cnt;
		}
	}
}