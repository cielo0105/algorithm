import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;
/*
 * n*m 연구소
 * 0 빈칸
 * 1 벽
 * 2 바이러스
 * 벽 3개 세워야함
 */
public class Main {
	static int N,M;
	static int[][] map;
	static boolean[][] visited;
	static List<Point> virus = new ArrayList<>();  // 바이러스 위치 저장
	static int[][] deltas = {{-1,0},{0,1},{1,0},{0,-1}};
	static int zero = 0;
	static int answer = 0;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		for(int i=0; i<N; i++) {
			st =  new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 2) {
					virus.add(new Point(i,j)); 
				}
				else if(map[i][j] == 0) zero++;
			}
		}
		zero = zero>3?zero-3:0;
		comb(1,0, new Point[3]);
		System.out.println(answer);
	}
	
	static void comb(int start, int depth, Point[] choose) {
		if(depth == 3) {
			check(choose);
			return;
		}
		for(int i=start; i<= N*M; i++) {
			int x = (i-1)/M;
			int y = (i-1)%M;
			if(map[x][y]==0) {
				map[x][y] = 1;
				choose[depth] = new Point(x,y);
				comb(i+1,depth+1,choose);
				map[x][y] = 0;
			}
		}
	}
	
	static void check(Point[] choose) {
		visited = new boolean[N][M];
		Queue<Point> queue = new ArrayDeque<>();
		
		for(Point p:virus) {
			queue.add(p);
		}
		int virus = 0; // 확산된 영역
		while(!queue.isEmpty()) {
			Point p = queue.poll();
			for(int i=0; i<4; i++) {
				int nx = p.x + deltas[i][0];
				int ny = p.y + deltas[i][1];
				if(nx>=0 && nx<N && ny>=0 && ny<M && map[nx][ny]==0 && !visited[nx][ny]) {
					visited[nx][ny] = true;
					virus++;
					queue.add(new Point(nx,ny));
				}
			}
		}
		answer = Math.max(answer, zero-virus);
	}
}