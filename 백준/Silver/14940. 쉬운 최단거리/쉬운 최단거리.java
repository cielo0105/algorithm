import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N,M;
	static int[][] map, answer;
	static int[][] deltas = {{-1,0},{0,1},{1,0},{0,-1}};
	static Info start;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		answer = new int[N][M];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 2) start = new Info(i,j,0);
				if(map[i][j] == 1) answer[i][j] = -1;
			}
		}
		dist();
		for(int [] ans: answer) {
			for(int a:ans ) {
				sb.append(a+" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
	
	static void dist() {
		Queue<Info> q = new ArrayDeque<>();
		q.add(start);
		answer[start.x][start.y] = 0;
		while(!q.isEmpty()) {
			Info p = q.poll();
			for(int i=0; i<4; i++) {
				int nx = p.x + deltas[i][0];
				int ny = p.y + deltas[i][1];
				if(nx>=0 && nx<N && ny>=0 && ny<M && map[nx][ny] == 1 && answer[nx][ny]==-1) {
					answer[nx][ny] = p.dist+1;
					q.add(new Info(nx,ny,p.dist+1));
				}
			}
		}
	}
	
	static class Info{
		int x, y, dist;
		public Info(int x, int y, int dist) {
			this.x = x;
			this.y = y;
			this.dist = dist;
		}
	}
	
}