import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N,M;
	static int[][] map;
	static boolean[][] visited;
	static int[][] deltas = {{-1,0},{0,1},{1,0},{0,-1}};
	static ArrayList<ArrayList<Info>> link = new ArrayList<>();
	static int answer = 0;
	static boolean[] choose;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visited = new boolean[N][M];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int num = 1;
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(map[i][j]==1 && !visited[i][j]) {
					map[i][j] = num;
					visited[i][j] = true;
					bfs(i,j,num);
					num++;
				}
			}
		}
		choose = new boolean[num];
		
		for(int i=0; i<=num; i++) { // 섬 개수만큼 
			link.add(new ArrayList<>());
		}
		
		for(int i=0; i<N; i++) { // 연결 가능한 경우 모두 찾음
			for(int j=0; j<M; j++) {
				if(map[i][j]!= 0) {
					find(i,j);
				}
			}
		}
		prim();
		for(int i=1; i<num; i++) {
			if(!choose[i]) {
				answer = -1;
				break;
			}
		}
		System.out.println(answer);
	}
	
	static void bfs(int x, int y, int num) {
		Queue<Point> q = new ArrayDeque<>();
		q.add(new Point(x,y));
		while(!q.isEmpty()) {
			Point p = q.poll();
			for(int i=0; i<4; i++) {
				int nx = p.x + deltas[i][0];
				int ny = p.y + deltas[i][1];
				if(nx>=0 && nx<N && ny>=0 && ny<M && map[nx][ny]==1 && !visited[nx][ny]) {
					visited[nx][ny] = true;
					map[nx][ny] = num;
					q.add(new Point(nx,ny));
				}
			}
		}
	}
	
	static void find(int x, int y) { // 연결 가능한 섬 찾기
		int num = map[x][y]; // 섬 번호
		for(int i=0; i<4; i++) {
			int nth = 1;
			while(true) {
				int nx = x + deltas[i][0]*nth;
				int ny = y + deltas[i][1]*nth;
				if(nx>=0 && nx<N && ny>=0 && ny<M) {
					if(map[nx][ny] == 0) { // 빈칸인 경우 계속 이동
						nth++;
					}
					else if(map[nx][ny] != num) { // 다른 섬 찾은 경우
						if(nth-1>1) link.get(num).add(new Info(map[nx][ny],nth-1)); // 길이 1보다 큰 경우
						break;
					}
					else break;
				}
				else break; // 범위 벗어난 경우
			}
		}
	}
	
	static void prim() {
		PriorityQueue<Info> pq = new PriorityQueue<>();
		// 1번부터 시작
		choose[1] = true;
		for(Info info:link.get(1)) {
			pq.add(info);
		}
		while(!pq.isEmpty()) {
			Info info = pq.poll();
			if(!choose[info.x]) {
				answer += info.dist;
				choose[info.x] = true;
				for(Info next:link.get(info.x)) {
					pq.add(next);
				}
			}
		}
	}
	static class Info implements Comparable<Info>{
		int x, dist;
		public Info(int x, int dist) {
			this.x = x;
			this.dist = dist;
		}
		@Override
		public int compareTo(Info o) {
			return this.dist - o.dist;
		}
	}
	
}