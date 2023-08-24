import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Array;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

/* 9명으로 이루어진 2팀
 * N이닝 동안 진행 (3아웃될때까지)
 * 1~9번 타자 -> 다시 1번 타자
 * 타순은 계속 유지됨 (2이닝때 3번까지 -> 3이닝때 4번부터)
 * 안타(1), 2루타(2), 3루타(3), 홈런(4) 아웃(0)
 * 1번 선수가 4번 타자는 이미 정해놓음
 * 
 * 이닝 수(N) 
 * 이닝마다 각 선수가 얻는 결과
 */
public class Main {
	static int[][] hitter;
	static int[] order;
	static boolean[] visited;
	static int N, score;
	static Queue<Integer> q;
	static int maxScore = Integer.MIN_VALUE;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		hitter = new int[10][N]; // 1-9번 주자의 각 이닝 점수 저장
		order = new int[10];
		order[4] = 1; // 1번 고정
		visited = new boolean[10];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<=9; j++) {
				hitter[j][i] = Integer.parseInt(st.nextToken());
			}
		}
		visited[1] = true; // 1번은 4번타자 확정
		permutation(1);
		check(1);
		System.out.println(maxScore);
	}
	
	
	static void permutation(int depth) {
		if(depth == 10) {
			int score = check(1);
			maxScore = Math.max(maxScore, score);
			return;
		}
		
		for(int i=2; i<=9; i++) {
			if(!visited[i]) {
				visited[i] = true;
				if(depth == 4) {
					depth += 1;
				}
				order[depth] = i;

				permutation(depth+1);
				visited[i] = false;
			}
		}
	}
	
	static int check(int now) {
		// order에 순서 저장됨
		int hitterNum = order[now];
		score = 0;
		for(int i=0; i<N; i++) {
			q = new ArrayDeque<>();
			init();
			int out = 0;
			while(true) {
				
				if(hitter[hitterNum][i] == 0) {
					out++;
					
					if(out == 3) {
						if(now==9) now = 1;
						else now+=1;
						hitterNum = order[now];
						break;
					}
				}
				else if(hitter[hitterNum][i] == 1) {
					in(1);
					out(1);
				}
				else if(hitter[hitterNum][i] == 2) {
					in(2);
					out(2);
				}
				else if(hitter[hitterNum][i] == 3) {
					in(3);
					out(3);
				}
				else if(hitter[hitterNum][i] == 4) {
					out(3);
					score++; // 본인까지
					init(); // 4개 다 poll 했기때문에
				}
				// 주자 변경
				if(now==9) now = 1;
				else now+=1;
				hitterNum = order[now];
			}
		}
		return score;
	}
	
	static void init() {
		for(int a=0; a<3; a++) {
			q.offer(0);
		}
	}
	
	static void in(int n) { // 타자 나감
		q.add(1);
		for(int i=1; i<n; i++) {
			q.add(0);
		}
	}
	
	static void out(int n) { // 홈으로 들어옴
		for(int i=0; i<n; i++) {
			if(q.poll() == 1) score++;
		}
	}
	
	
}