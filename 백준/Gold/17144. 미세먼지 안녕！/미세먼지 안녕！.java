import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;
/*
 * -1 공기청정기
 * 미세먼지 확산 - 4방향
 */
public class Main {
	static int R,C,T;
	static int[][] map;
	static Queue<Dust> q = new ArrayDeque<>();
	static Point[] location = new Point[2];
	static int[][] deltas = {{-1,0},{0,1},{1,0},{0,-1}};
	static int[][] down = {{1,0},{0,1},{-1,0},{0,-1}};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		map = new int[R][C];
		int cnt = 0;
		for(int i=0; i<R; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<C; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j]==-1) {
					location[cnt++] = new Point(i,j); // 공기청정기 위치 저장
				}
			}
		}
		
		for(int i=0; i<T; i++) {
			findDust();
			spread();
			moveUp();
			moveDown();
		}
		
		int answer = 0;
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				if(map[i][j]>0) answer += map[i][j];
			}
		}
		System.out.println(answer);
	}
	static void spread() {
		while(!q.isEmpty()) {
			Dust dust = q.poll();
			int cnt = 0;
			int sp = dust.val / 5;
			for(int i=0; i<4; i++) {
				int nx = dust.x + deltas[i][0];
				int ny = dust.y + deltas[i][1];
				if(nx>=0 && nx<R && ny>=0 && ny<C && map[nx][ny]!=-1) {
					cnt++;
					map[nx][ny] += sp;
				}
			}
			map[dust.x][dust.y] -= sp * cnt;
			
		}
	}
	
	static void moveUp() { // 위쪽 : 반시계 
		int nth = 0;
		int x = location[0].x-1;
		int y = location[0].y;
		while(true) {
			int nx = x + deltas[nth][0];
			int ny = y + deltas[nth][1];
			if(nx==location[0].x && ny==location[0].y) {
				map[x][y] = 0;
				break;
			}
			if(nx>=0 && nx<=location[0].x && ny>=0 && ny<C) {
				map[x][y] = map[nx][ny];
				x = nx;
				y = ny;
			}
			else nth++;
		}
	}
	
	static void moveDown() { // 아래쪽 : 시계
		int nth = 0;
		int x = location[1].x+1;
		int y = location[1].y;
		while(true) {
			int nx = x + down[nth][0];
			int ny = y + down[nth][1];
			if(nx==location[1].x && ny==location[1].y) {
				map[x][y] = 0;
				break;
			}
			if(nx>=location[1].x && nx<R && ny>=0 && ny<C) {
				map[x][y] = map[nx][ny];
				x = nx;
				y = ny;
			}
			else nth++;
		}
	}
	static void findDust() {
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				if(map[i][j] > 0) q.add(new Dust(i,j,map[i][j]));
			}
		}
	}
	
	static class Dust{
		int x, y, val;
		public Dust(int x, int y, int val) {
			this.x = x;
			this.y = y;
			this.val = val;
		}
	}
}