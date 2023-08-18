import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
* 미로탐색 
* N*M
* 1: 이동 가능 
* 0: 이동 불가
*/

public class Main {
	static int N,M;
	static char[][] graph;
	static int cnt = 0;
	static int[][] deltas = {{-1,0},{0,1},{1,0},{0,-1}};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new  StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		graph = new char[N][M];
		for(int i=0; i<N; i++) {
			graph[i] = br.readLine().toCharArray();
		}
		System.out.println(find(0,0));
		// 0,0 -> N-1,M-1
		
	}
	static int find(int a, int b) {
		Queue<Point> q = new LinkedList<>();
		Point point = new Point(a,b);
		point.depth = 1;
		q.add(point);
		int nx,ny;
		graph[a][b] = '0';
		while(!q.isEmpty()) {
			point = q.poll();
			a = point.x;
			b = point.y;
			int depth = point.depth;
			if(a==N-1 && b==M-1) return point.depth;
			for(int i=0; i<4; i++) {
				nx = a + deltas[i][0];
				ny = b + deltas[i][1];
				if(nx>=0 && nx<N && ny>=0 && ny<M && graph[nx][ny]!='0') {
					point = new Point(nx,ny);
					point.depth = depth + 1;
					q.add(point);
					graph[nx][ny] = '0';
				}
			}
		}
		return 0;
	}
	public static class Point{
		int x, y;
		int depth;
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}