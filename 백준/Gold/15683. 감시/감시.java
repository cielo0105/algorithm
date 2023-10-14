import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * N*M 사무실
 * K개의 CCTV (5종류)
 * 1. 한쪽 방향
 * 2. 반대 방향 2개
 * 3. 직각 방향
 * 4. 3방향
 * 5. 4방향
 */
public class Main {
	static int[][] deltas = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
	static int N, M;
	static int[][] map;
	static ArrayList<Point> five, cctv;
	static int answer = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		five = new ArrayList<>();
		cctv = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 5)
					five.add(new Point(i, j));
				else if (map[i][j] >= 1 && map[i][j] < 5)
					cctv.add(new Point(i, j));
			}
		}

		five(); // 5번 cctv는 항상 4방향 탐색 - 미리 구해두기
		find(0, map);
		System.out.println(answer);
	}

	static void find(int nth, int[][] map) {
		if (nth == cctv.size()) {
			int cnt = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (map[i][j] == 0)
						cnt++;
				}
			}
			answer = Math.min(answer, cnt);
			return;
		}
		int[][] copy = new int[N][M];
		for (int i = 0; i < N; i++)
			copy[i] = map[i].clone();
		Point p = cctv.get(nth);
		int num = map[p.x][p.y];
		if (num == 1) {
			for (int j = 0; j < 4; j++) {
				one(p, j, copy);
				find(nth + 1, copy);
				 for (int k = 0; k < N; k++)
	                    copy[k] = map[k].clone();
	            }
			
		} else if (num == 2) {
			for (int j = 0; j < 2; j++) {
				two(p, j, copy);
				find(nth + 1, copy);
				for (int k = 0; k < N; k++)
                    copy[k] = map[k].clone();
			}
		} else if (num == 3) {
			for (int j = 0; j < 4; j++) {
				three(p, j, copy);
				find(nth + 1, copy);
				for (int k = 0; k < N; k++)
                    copy[k] = map[k].clone();
			}
		} else if (num == 4) {
			for (int j = 0; j < 4; j++) {
				four(p, j, copy);
				find(nth + 1, copy);
				for (int k = 0; k < N; k++)
                    copy[k] = map[k].clone();
			}
		}
	}

	static void one(Point p, int dir, int[][] map) {
		int nth = 1;
		while (true) {
			int nx = p.x + deltas[dir][0] * nth;
			int ny = p.y + deltas[dir][1] * nth;
			if (changeMap(map, nx, ny))
				nth++;
			else
				break;
		}
	}

	static void two(Point p, int dir, int[][] map) {
		int nth = 1;
		while (true) {
			int nx = p.x + deltas[dir][0] * nth;
			int ny = p.y + deltas[dir][1] * nth;
			if (changeMap(map, nx, ny))
				nth++;
			else
				break;
		}
		nth = 1;
		dir = (dir + 2) % 4;
		while (true) {
			int nx = p.x + deltas[dir][0] * nth;
			int ny = p.y + deltas[dir][1] * nth;
			if (changeMap(map, nx, ny))
				nth++;
			else
				break;
		}
	}

	static void three(Point p, int start, int[][] map) {
		int nth = 1;
		while (true) {
			int nx = p.x + deltas[start][0] * nth;
			int ny = p.y + deltas[start][1] * nth;
			if (changeMap(map, nx, ny))
				nth++;
			else
				break;
		}
		nth = 1;
		start = (start + 1) % 4;
		while (true) {
			int nx = p.x + deltas[start][0] * nth;
			int ny = p.y + deltas[start][1] * nth;
			if (changeMap(map, nx, ny))
				nth++;
			else
				break;
		}
	}

	static void four(Point p, int dir, int[][] map) {
		for (int i = 0; i < 4; i++) {
			if (i == dir)
				continue;
			int nth = 1;
			while (true) {
				int nx = p.x + deltas[i][0] * nth;
				int ny = p.y + deltas[i][1] * nth;
				if (changeMap(map, nx, ny))
					nth++;
				else
					break;
			}
		}
	}

	static void five() {
		for (Point p : five) {
			for (int i = 0; i < 4; i++) {
				int nth = 1;
				while (true) {
					int nx = p.x + deltas[i][0] * nth;
					int ny = p.y + deltas[i][1] * nth;
					if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
						if (map[nx][ny] == 6)
							break; // 벽인 경우 탐색 종료
						if (map[nx][ny] == 0) {
							map[nx][ny] = -1; // cctv 감시 가능 영역 표시
						}
						nth++;
					} else
						break;
				}

			}
		}
	}

	static boolean changeMap(int[][] map, int x, int y) {
		if (x >= 0 && x < N && y >= 0 && y < M) {
			if (map[x][y] == 6)
				return false; // 벽인 경우 탐색 종료
			if (map[x][y] == 0) {
				map[x][y] = -1; // cctv 감시 가능 영역 표시
			}
			return true;
		}
		return false; // 범위 벗어난 경우
	}
}