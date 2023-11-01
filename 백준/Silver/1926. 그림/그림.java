import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;
import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;

public class Main {
	static int n, m;
	static int[][] graph;
	static int[][] deltas = {{-1,0},{0,1},{1,0},{0,-1}};
	static int max = 0;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		graph = new int[n][m];
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<m; j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int answer = 0;
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(graph[i][j]==1) {
					answer ++;
					graph[i][j] = 0;
					bfs(i,j);
				}
			}
		}
		System.out.println(answer);
		System.out.println(max);
	}
	
	static void bfs(int x, int y) {
		Queue<Point> q = new ArrayDeque<>();
		int size = 1;
		q.add(new Point(x,y));
		while(!q.isEmpty()) {
			Point p = q.poll();
			for(int i=0; i<4; i++) {
				int nx = p.x + deltas[i][0];
				int ny = p.y + deltas[i][1];
				if(nx>=0 && nx<n && ny>=0 && ny<m && graph[nx][ny]==1) {
					graph[nx][ny] = 0;
					size++;
					q.add(new Point(nx,ny));
				}
			}
		}
		max = Math.max(max, size);
	}
}