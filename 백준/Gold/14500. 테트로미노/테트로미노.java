import java.awt.Point;
import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;
/*
 * 4칸 합 최대
 */
public class Main {
	static int[][] deltas = {{-1,0},{0,1},{1,0}}; // 위, 오, 아래 방향으로만 이동
	static int N,M;
	static int[][] map;
	static boolean[][] visited;
	static int answer = 0;
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
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				visited[i][j] = true;
				find(i,j,1,map[i][j]);
				visited[i][j] = false;
			}
		}
		
		System.out.println(answer);
	}
	
	static void find(int x,int y, int cnt, int sum) {
		if(cnt == 4) { // 4개 다 뽑은 경우
			answer = Math.max(answer, sum); // answer 최댓값 갱신
			return;
		}
		
		for(int i=0; i<3; i++) {
			int nx = x + deltas[i][0];
			int ny = y + deltas[i][1];
			if(nx>=0 && nx<N && ny>=0 && ny<M && !visited[nx][ny]) {
				if(cnt == 2) { // ㅓㅗㅏㅜ 모양 처리하기 위해 2번째 칸에서는 다시 해당 칸에서 탐색하게 해줌
					visited[nx][ny] = true;
					find(x,y,cnt+1,sum+map[nx][ny]);
					visited[nx][ny] = false;
				}
				visited[nx][ny] = true;
				find(nx,ny,cnt+1,sum+map[nx][ny]);
				visited[nx][ny] = false;
			}
		}
	}
}