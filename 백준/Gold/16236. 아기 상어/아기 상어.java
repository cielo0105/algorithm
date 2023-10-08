import java.awt.Point;
import java.io.BufferedReader;import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * N*N 물고기 M마리, 상어 1마리
 * 상어 크기 2
 * 자신보다 작은 물고기만 먹을 수 있음 (큰 물고기 있는 칸 못지나감)
 * 가장 가까운 물고기 먹음 (위,왼 우선)
 * 9 아기 상어 위치
 * 1~6 물고기 크기
 * 
 */
public class Main {
	static int N;
	static int[][] map;
	static int[][] deltas = {{-1,0},{0,-1},{0,1},{1,0}};
	static int answer = 0;
	static int size = 2; // 초기 상어 크기
	static int eatCnt = 0; // 먹은 물고기 개수
	static int shark_x, shark_y;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 9) {
					shark_x = i; 
					shark_y = j;
					map[shark_x][shark_y] = 0;
				}
			}
		}
		while(true) {
			if(!bfs(shark_x,shark_y)) {
				break;
			}
		}
		System.out.println(answer);
	}
	
	static boolean bfs(int x, int y) {
		boolean[][] visited = new boolean[N][N];
		Queue<Info> q = new ArrayDeque<>(); // 이동할 위치 저장할 큐
		PriorityQueue<Info> fish = new PriorityQueue<>(); // 먹을 수 있는 물고기 저장할 우선순위큐
		visited[x][y] = true;
		q.add(new Info(x,y,0));
		int min_time = -1;
		loop:
		while(!q.isEmpty()) {
			Info p = q.poll();
			for(int i=0; i<4; i++) {
				int nx = p.x + deltas[i][0];
				int ny = p.y + deltas[i][1];
				if(nx>=0 && nx<N && ny>=0 && ny<N && map[nx][ny] <= size && !visited[nx][ny]) {
					visited[nx][ny] = true;
					if(map[nx][ny] == 0 || map[nx][ny] == size) q.add(new Info(nx,ny,p.time+1)); // 지나갈 수 있는 경우
					else if(map[nx][ny] < size) { // 먹을 수 있는 물고기
						if(min_time == -1) {
							min_time = p.time + 1;
							fish.add(new Info(nx,ny,p.time+1));
						}
						else if(min_time == p.time + 1) {
							fish.add(new Info(nx,ny,p.time+1));
						}
						else break loop;
					}
					
				}
			}
		}
		if(fish.isEmpty()) return false;
		Info eat = fish.poll();
		map[eat.x][eat.y] = 0; // 먹은 물고기 자리 0으로 바꿔줌
		shark_x = eat.x;
		shark_y = eat.y;
		answer += eat.time; // 물고기까지의 거리 더해줌
		eatCnt++;
		if(eatCnt == size) {
			size++;
			eatCnt = 0;
		}
		return true;
	}
	static class Info implements Comparable<Info>{ 
		int x, y, time;
		public Info(int x, int y, int time) {
			this.x = x;
			this.y = y;
			this.time = time;
		}
		@Override
		public int compareTo(Info o) {
			if(this.x == o.x) return this.y - o.y;
			return this.x - o.x;
		}
	}
}