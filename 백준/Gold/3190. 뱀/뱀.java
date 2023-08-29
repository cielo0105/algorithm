import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;
/*
 * 뱀 - 벽, 자신 부딪히면 게임 끝
 * N*N 
 * 처음 길이 1, 사과 먹으면 길이 늘어남
 * 머리 다음칸 이동 - 사과 있으면 몸 유지, 없으면 꼬리 비워줌
 * x초 끝난 뒤 방향 회전
 * L : 왼쪽 90도
 * D : 오른쪽 90도
 */

public class Main {
	static int[][] graph;
	static int[][] deltas = {{-1,0},{0,1},{1,0},{0,-1}};
	static int dir = 1; // 시작은 오른쪽
	static Queue<Move> q = new ArrayDeque<>();
	static Queue<Point> snake = new ArrayDeque<>();
	static int N,x,y;
	static int totalTime = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine()); // 보드 크기
		int K = Integer.parseInt(br.readLine()); // 사과 개수
		graph = new int[N][N];
		Map<String, Integer> map = new HashMap<>();
		map.put("L", 3);  // 왼쪽 90도 
		map.put("D", 1); // 오른쪽 90도 
		int x,y;
		
		for(int i=0; i<K; i++) {
			st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			graph[x-1][y-1] = 1; // 사과 위치 1
		}
		int L = Integer.parseInt(br.readLine());
		int time, move;
		String direction;
		int dirStart = 1;
		for(int i=0; i<L; i++) {
			st = new StringTokenizer(br.readLine());
			time = Integer.parseInt(st.nextToken());
			direction = st.nextToken();
			dirStart = (dirStart + map.get(direction))%4;
			q.add(new Move(time,dirStart));
		}
		move();
		System.out.println(totalTime);
	}
	static void move() {
		x = 0;
		y = 0; // 처음 시작은 0,0
		
		graph[x][y] = 2; // 뱀 위치 2로 저장
		snake.add(new Point(x,y)); // 뱀 위치 큐에 저장
		Move move = null;
		while(!q.isEmpty()) {
			move = q.poll();
			if(move.time > totalTime) { // 뱀 현재 방향으로 더 움직여야 됨
				if(!moveSnake(move.time-totalTime)) return;
			}
		
			dir = move.dir;
		}
		if(move.time > totalTime) { // 뱀 현재 방향으로 더 움직여야 됨
			if(!moveSnake(move.time-totalTime)) return;
		}
		moveSnake(N);
	}
	
	static boolean moveSnake(int time) {
		int nx, ny;
		for(int i=0; i<time; i++) {
			nx = x + deltas[dir][0];
			ny = y + deltas[dir][1];
			totalTime++;
			if(nx>=0 && nx<N && ny>=0 && ny<N) {
				snake.add(new Point(nx,ny));
				if(graph[nx][ny]==2) {
					return false; // 자신 부딪힌 경우
				}
				if(graph[nx][ny]!=1) { // 사과  없는 경우
					Point p = snake.poll();
					graph[p.x][p.y] = 0;
				}
				graph[nx][ny] = 2;
				x = nx;
				y = ny;
			}
			else {
				return false;
			}
		}
		return true;
	}
	
	static class Move{
		int time, dir;
		public Move(int time, int dir) {
			this.time = time;
			this.dir = dir;
		}
		
	}
}