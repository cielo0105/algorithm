import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * 활주로 건설 가능한 가로, 세로 개수
 * N*N 지형 (6<=N<=20)
 * 높이 1, 길이 X인 경사로 이용
 * 
 */
public class Main {
	static int N, X;
	static int[][] map;
	static int answer;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		answer = 0;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < N; i++) {
			check(i);
		}
		for (int i = 0; i < N; i++) {
			for (int j = i; j < N; j++) {
				swap(i, j);
			}
		}
		for (int i = 0; i < N; i++) {
			check(i);
		}
		System.out.println(answer);
	}

	static void check(int num) {
		int cnt = 1;
		int flag = 0;
		int start = map[num][0];
		for (int i = 1; i < N; i++) { // 가로 부분 확인
			if (map[num][i] == start)
				cnt++;
			else if (map[num][i] - start == 1) { // 증가
				if (flag == 1) { // 전에 감소했던 경우
					if (cnt < 2 * X)
						return;
				} else {
					if (cnt < X)
						return;
				}
				cnt = 1;
				start = map[num][i];
				flag = 0;
			} else if (map[num][i] - start == -1) { // 감소
				if (flag == 1) {
					if (cnt < X)
						return;
				}
				flag = 1;
				cnt = 1;
				start = map[num][i];
			} else
				return;
		}
		if (flag == 1) {
			if (cnt < X)
				return;
		}
		answer++;
	}

	static void swap(int i, int j) {
		int temp = map[i][j];
		map[i][j] = map[j][i];
		map[j][i] = temp;
	}

}